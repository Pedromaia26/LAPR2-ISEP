package app.domain.model;

import auth.AuthFacade;
import auth.domain.store.UserRoleStore;
import auth.domain.store.UserStore;
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
    private UserStore userStore;
    private UserRoleStore userRoleStore;
    private LaboratoryStore laboratoryStore;
    private OrgRoleStore orgRoleStore;
    private OrgRole orgRole;
    private SampleStore sampleStore;
    private LabOrderStore labOrderStore;


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
        this.sampleStore=new SampleStore();
        this.labOrderStore=new LabOrderStore();
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
    public ClientStore getClientStore() {
        return clientStore;
    }
    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }
    public UserStore getUserStore() {
        return userStore;
    }
    public UserRoleStore getUserRoleStore() { return userRoleStore; }
    public LaboratoryStore getLaboratoryStore() {
        return laboratoryStore;
    }
    public OrgRoleStore getOrgRoleStore() { return orgRoleStore; }
    public OrgRole getOrgRole(){ return orgRole; }
    public SampleStore getSampleStore(){return sampleStore; }
    public LabOrderStore getLabOrderStore(){return labOrderStore; }

}
