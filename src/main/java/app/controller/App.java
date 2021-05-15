package app.controller;

import app.domain.model.Company;
import app.domain.model.OrgRole;
import app.domain.model.OrgRoleStore;
import app.domain.model.RolesStore;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;
    private UserRoleStore userRoleStore;

    private App()
    {
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


    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_REC,Constants.ROLE_REC);
        this.authFacade.addUserRole(Constants.ROLE_MLT,Constants.ROLE_MLT);
        this.authFacade.addUserRole(Constants.ROLE_CCT,Constants.ROLE_CCT);
        this.authFacade.addUserRole(Constants.ROLE_LC,Constants.ROLE_LC);
        this.authFacade.addUserRole(Constants.ROLE_SD,Constants.ROLE_SD);
        this.authFacade.addUserRole(Constants.ROLE_C,Constants.ROLE_C);

        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);

        this.authFacade.addUserWithRole("Receptionist", "rec@lei.sem2.pt", "123456",Constants.ROLE_REC);

        this.authFacade.addUserWithRole("Medical Lab Technician", "mlt@lei.sem2.pt", "123456",Constants.ROLE_MLT);


    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance()
    {
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
