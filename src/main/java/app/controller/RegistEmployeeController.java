package app.controller;

import app.domain.model.*;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RegistEmployeeController {

    private OrgRoleStore rStore;

    private List<OrgRole> lRoles = new ArrayList<>();
    private List<OrgRoleDto> lRolesDto = new ArrayList<>();

    private Employee emp;
    private SpecialistDoctor empsd;

    private RolesMapper rolesmapper = new RolesMapper();

    public List<OrgRoleDto> getRoles(){
        rStore = App.getInstance().getCompany().getOrgRoleStore();
        rStore.addDefaultRoles();
        lRoles = rStore.getRoles();
        lRolesDto = rolesmapper.toDTO(lRoles);
        return lRolesDto;
    }

    public boolean createEmployee(EmployeeDto empDto){
        this.emp = App.getInstance().getCompany().getEmployeeStore().createEmployee(empDto);
        return App.getInstance().getCompany().getEmployeeStore().validateEmployee(emp);
    }

    public boolean createSpecialistDoctor(EmployeeDto spedocdto){
        this.empsd = App.getInstance().getCompany().getEmployeeStore().createSpecialistDoctor(spedocdto);
        return App.getInstance().getCompany().getEmployeeStore().validateSpecialistDoctor(empsd);
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
        App.getInstance().getCompany().getEmployeeStore().createUser(empsd);
    }
}
