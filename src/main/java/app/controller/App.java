package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;
import auth.domain.store.UserRoleStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;
    private UserRoleStore userRoleStore;

    private App() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    public Company getCompany()
    {
        return this.company;
    }


    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ignored)
        {

        }
        return props;
    }

    public Properties getprops(){
        return getProperties();
    }

    private void bootstrap() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_REC,Constants.ROLE_REC);
        this.authFacade.addUserRole(Constants.ROLE_MLT,Constants.ROLE_MLT);
        this.authFacade.addUserRole(Constants.ROLE_CCT,Constants.ROLE_CCT);
        this.authFacade.addUserRole(Constants.ROLE_LC,Constants.ROLE_LC);
        this.authFacade.addUserRole(Constants.ROLE_SD,Constants.ROLE_SD);
        this.authFacade.addUserRole(Constants.ROLE_C,Constants.ROLE_C);

        /*this.getCompany().getOrgRoleStore().addOrgRole(new OrgRole(Constants.ROLE_ADMIN));
        this.getCompany().getOrgRoleStore().addOrgRole(new OrgRole(Constants.ROLE_REC));
        this.getCompany().getOrgRoleStore().addOrgRole(new OrgRole(Constants.ROLE_MLT));
        this.getCompany().getOrgRoleStore().addOrgRole(new OrgRole(Constants.ROLE_CCT));
        this.getCompany().getOrgRoleStore().addOrgRole(new OrgRole(Constants.ROLE_LC));
        this.getCompany().getOrgRoleStore().addOrgRole(new OrgRole(Constants.ROLE_SD));*/



        ParameterCategory pc1 = new ParameterCategory("Hemogram", "11111");
        this.getCompany().getParameterCategoryStore().saveParameterCategory(pc1);

        ParameterCategory pc2 = new ParameterCategory("Cholesterol", "11112");
        this.getCompany().getParameterCategoryStore().saveParameterCategory(pc2);

        ParameterCategory pc3 = new ParameterCategory("Covid", "11113");
        this.getCompany().getParameterCategoryStore().saveParameterCategory(pc3);

        List<ParameterCategory> parameterCategories = this.getCompany().getParameterCategoryStore().getParameterCategories();

        TestType testType= new TestType("Blood", "Swab", "12345", parameterCategories,"Domain.ExternalModuleAdapter2");

        TestType testType1= new TestType("Blood", "Swab", "12344", parameterCategories,"Domain.ExternalModuleAdapter3");

        TestType testType2= new TestType("Covid", "Swab", "12346", parameterCategories,"Domain.ExternalModuleAdapter1");


        this.getCompany().getTestTypeStore().saveTestType(testType);
        this.getCompany().getTestTypeStore().saveTestType(testType1);
        this.getCompany().getTestTypeStore().saveTestType(testType2);


        Parameter p1 = new Parameter("HB000", "test", "HB000", pc1);

        Parameter p2 = new Parameter("WBC00", "test", "WBC00", pc1);

        Parameter p3 = new Parameter("PLT00", "test", "PLT00", pc1);

        Parameter p4 = new Parameter("RBC00", "test", "RBC00", pc1);

        Parameter p5 = new Parameter("HDL00", "test", "HDL00", pc1);

        Parameter p6 = new Parameter("IgGAN", "test", "IgGAN", pc3);



        this.getCompany().getParameterStore().saveParameter(p1);
        this.getCompany().getParameterStore().saveParameter(p2);
        this.getCompany().getParameterStore().saveParameter(p3);
        this.getCompany().getParameterStore().saveParameter(p4);
        this.getCompany().getParameterStore().saveParameter(p5);
        this.getCompany().getParameterStore().saveParameter(p6);



        Laboratory l = new Laboratory("001LR", "ExeterLaboratory", "Manchester", 11111111111L, 9811111111L, this.getCompany().getTestTypeStore().getTestTypes());

        this.getCompany().getLaboratoryStore().saveLaboratory(l);


        Client client = new Client("1234567890123456",1234567890L,"12/12/2002","male",1234567890L,"client@lei.sem2.pt","Client",12312312312L);

        this.getCompany().getClientStore().addNewClient(client);

        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);

        this.authFacade.addUserWithRole("Receptionist", "rec@lei.sem2.pt", "123456",Constants.ROLE_REC);

        this.authFacade.addUserWithRole("Medical Lab Technician", "mlt@lei.sem2.pt", "123456",Constants.ROLE_MLT);

        this.authFacade.addUserWithRole("Specialist Doctor", "sd@lei.sem2.pt", "123456",Constants.ROLE_SD);

        this.authFacade.addUserWithRole("Laboratory Coordinator", "lc@lei.sem2.pt", "123456",Constants.ROLE_LC);

        this.authFacade.addUserWithRole("Clinical Chemistry Technologist", "cct@lei.sem2.pt", "123456",Constants.ROLE_CCT);

        this.authFacade.addUserWithRole("Client", "client@lei.sem2.pt", "123456",Constants.ROLE_C);

        company.getEmployeeStore().read(company);
        company.getEmployeeStore().readSpecialistDoctor(company);
        company.getClientStore().read(company);
        company.getParameterCategoryStore().read(company);
        company.getParameterStore().read(company);
        company.getTestTypeStore().read(company);
        company.getLaboratoryStore().read(company);
        company.getTestStore().read(company);
    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }

}
