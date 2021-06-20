package app.domain.model;

import app.controller.SendReportAutomaticController;
import auth.AuthFacade;
import auth.domain.store.UserRoleStore;
import auth.domain.store.UserStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {
    /**
     * String that contains the designation
     */
    private String designation;
    /**
     * AuthFacade that contains the authFacade
     */
    private AuthFacade authFacade;
    /**
     * Store that contains the test types
     */
    private TestTypeStore testTypeStore;
    /**
     * Store that contains the Parameter Category
     */
    private ParameterCategoryStore parameterCategoryStore;
    /**
     * Store that contains the paremeters
     */
    private ParameterStore parameterStore;

    /**
     * Store that contains the clients
     */
    private ClientStore clientStore;
    /**
     * Store that contains the employess
     */
    private EmployeeStore employeeStore;
    /**
     * Store that contains the users
     */
    private UserStore userStore;
    /**
     * Store that contains the User roles
     */
    private UserRoleStore userRoleStore;
    /**
     * Store that contains the Labs
     */
    private LaboratoryStore laboratoryStore;
    /**
     * Store that contains the org Role
     */
    private OrgRoleStore orgRoleStore;
    /**
     * OrgRole that contains the orgRole
     */
    private OrgRole orgRole;
    /**
     * Store that contains the lab orders
     */
    private LabOrderStore labOrderStore;
    /**
     * Store that contains the tests
     */
    private TestStore testStore;



    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.testTypeStore = new TestTypeStore();
        this.parameterCategoryStore = new ParameterCategoryStore();
        this.clientStore= new ClientStore();
        this.parameterStore = new ParameterStore();
        this.employeeStore = new EmployeeStore();
        this.userStore= new UserStore();
        this.userRoleStore = new UserRoleStore();
        this.laboratoryStore = new LaboratoryStore();
        this.orgRoleStore = new OrgRoleStore();
        this.orgRole = new OrgRole();
        this.labOrderStore=new LabOrderStore();
        this.testStore=new TestStore();
        Timer timer = new Timer();
        Date current = new Date();
        if(current.getHours()<6){
            current.setHours(6);
            current.setMinutes(0);
            current.setSeconds(0);
        }else {
            current.setHours(6);
            current.setMinutes(0);
            current.setSeconds(0);
            current.setHours(current.getHours()+24);
        }
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    SendReportAutomaticController controller = new SendReportAutomaticController();
                    controller.readProperties();
                    controller.sendReport();
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | OutputException | BarcodeException | ParseException | IOException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(timerTask, current, 86400000);
    }
    /**
     * Returns the designation.
     * @return the desiggnation.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Returns the authFacade.
     * @return the authFacade.
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * Returns the store of a test types.
     * @return the store of a test types.
     */

    public TestTypeStore getTestTypeStore() {
        return testTypeStore;
    }

    /**
     * Returns the store of a parameter category.
     * @return the store of a parameter category.
     */
    public ParameterCategoryStore getParameterCategoryStore() {
        return parameterCategoryStore;
    }
    /**
     * Returns the store of a parameters.
     * @return the store of a parameters.
     */
    public ParameterStore getParameterStore() {
        return parameterStore;
    }

    /**
     * Returns the store of a clients.
     * @return the store of a clients.
     */
    public ClientStore getClientStore() {
        return clientStore;
    }

    /**
     * Returns the store of a employees.
     * @return the store of a employees.
     */
    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    /**
     * Returns the store of users.
     * @return the store of users.
     */
    public UserStore getUserStore() {
        return userStore;
    }

    /**
     * Returns the store of a user roles.
     * @return the store of a user roles.
     */
    public UserRoleStore getUserRoleStore() { return userRoleStore; }

    /**
     * Returns the store of a laboratorys.
     * @return the store of a laboratorys.
     */
    public LaboratoryStore getLaboratoryStore() {
        return laboratoryStore;
    }

    /**
     * Returns the store of a org roles.
     * @return the store of a org roles.
     */
    public OrgRoleStore getOrgRoleStore() { return orgRoleStore; }

    /**
     * Returns the org role.
     * @return the org role.
     */
    public OrgRole getOrgRole(){ return orgRole; }

    /**
     * Returns the store of a lab orders.
     * @return the store of a lab orders.
     */
    public LabOrderStore getLabOrderStore(){return labOrderStore; }

    /**
     * Returns the store of a tests.
     * @return the store of a tests.
     */
    public TestStore getTestStore(){return testStore;}

    /**
     * Returns the NHS report.
     * @return the Nhs report.
     */
    public ReportNHS createReportNHS(){
        return new ReportNHS();
    }



}
