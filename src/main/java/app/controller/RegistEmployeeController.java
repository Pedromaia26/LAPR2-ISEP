package app.controller;

import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class RegistEmployeeController {

    private List<OrgRole> lRoles = new ArrayList<>();
    private List<OrgRole> lRolesDto = new ArrayList<>();

    private Employee emp;
    private SpecialistDoctor empsd;

    public List<OrgRole> getRoles(){
        lRoles = RolesStore.getRoles();
        lRolesDto = RolesMapper.toDTO(lRoles);
        return lRolesDto;
    }

    public boolean createEmployee(EmployeeDto empDto){
        this.emp = EmployeeStore.createEmployee(empDto);
        return App.getInstance().getCompany().getEmployeeStore().validateEmployee(emp);
    }

    public boolean createSpecialistDoctor(EmployeeDto spedocdto){
        this.empsd = EmployeeStore.createSpecialistDoctor(spedocdto);
        return App.getInstance().getCompany().getEmployeeStore().validateSpecialistDoctor(empsd);
    }

    public List<Employee> getEmployeeList(){
        return App.getInstance().getCompany().getEmployeeStore().getEmployeeList();
    }

    public List<SpecialistDoctor> getSpecialistDoctorList(){
        return App.getInstance().getCompany().getEmployeeStore().getSpecialistDoctors();
    }

    public void saveEmployee(){
        App.getInstance().getCompany().getEmployeeStore().saveEmployee(emp);
    }

    public void saveSpecialistDoctor(){
        App.getInstance().getCompany().getEmployeeStore().saveSpecialistDoctor(empsd);
    }
}
