package app.controller;

import app.domain.model.*;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RegistEmployeeController {

    private OrgRoleStore orgRoleStore = new OrgRoleStore();

    private List<OrgRole> lRoles = new ArrayList<>();
    private List<OrgRole> lRolesDto = new ArrayList<>();

    private Employee emp;
    private SpecialistDoctor empsd;

    public List<OrgRole> getRoles(){
        orgRoleStore.addDefaultRoles();
        for (OrgRole orgRole : orgRoleStore.getOrgRoleStore()){
            lRoles.add(orgRole);
        }
        lRolesDto = RolesMapper.toDTO(lRoles);
        return lRolesDto;
    }

    public Employee createEmployee(EmployeeDto empDto){
        this.emp = App.getInstance().getCompany().getEmployeeStore().createEmployee(empDto);
        App.getInstance().getCompany().getEmployeeStore().validateEmployee(emp);
        return emp;
    }

    public SpecialistDoctor createSpecialistDoctor(EmployeeDto spedocdto){
        this.empsd = App.getInstance().getCompany().getEmployeeStore().createSpecialistDoctor(spedocdto);
        App.getInstance().getCompany().getEmployeeStore().validateSpecialistDoctor(empsd);
        return empsd;
    }

    public List<Employee> getEmployeeList(){
        return App.getInstance().getCompany().getEmployeeStore().getEmployeeList();
    }

    public List<SpecialistDoctor> getSpecialistDoctorList(){
        return App.getInstance().getCompany().getEmployeeStore().getSpecialistDoctors();
    }

    public void saveEmployee() throws FileNotFoundException {
        App.getInstance().getCompany().getEmployeeStore().saveEmployee(emp);
        App.getInstance().getCompany().getEmployeeStore().createUser(emp);
    }

    public void saveSpecialistDoctor() throws FileNotFoundException {
        App.getInstance().getCompany().getEmployeeStore().saveSpecialistDoctor(empsd);
        App.getInstance().getCompany().getEmployeeStore().createSpecialistDoctor(empsd);
    }
}
