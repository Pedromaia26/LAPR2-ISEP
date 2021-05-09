package app.domain.model;

import auth.AuthFacade;
import auth.domain.store.UserRoleStore;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private TestTypeStore testTypeStore;
    private ParameterCategoryStore parameterCategoryStore;
    private ParameterStore parameterStore;
    private ClientStore clientStore;
    private EmployeeStore employeeStore;
    private UserRoleStore userRoleStore;


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
        this.userRoleStore = new UserRoleStore();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public TestTypeStore getTestTypeStore() {
        return testTypeStore;
    }
    public ParameterCategoryStore getParameterCategoryStore() {
        return parameterCategoryStore;
    }
    public ParameterStore getParameterStore() {
        return parameterStore;
    }
    public ClientStore getClientStore() { return clientStore; }
    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }
    public UserRoleStore getUserRoleStore() { return userRoleStore; }

}
