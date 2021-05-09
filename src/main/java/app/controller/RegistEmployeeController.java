package app.controller;

import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class RegistEmployeeController {

    private List<OrgRole> lRoles = new ArrayList<>();
    private List<OrgRole> lRolesDto = new ArrayList<>();

    private Employee emp;

    public List<OrgRole> getRoles(){
        RolesStore.addDefaultRoles();
        lRoles = RolesStore.getRoles();
        lRolesDto = RolesMapper.toDTO(lRoles);
        return lRolesDto;
    }

    public boolean createEmployee(Employee empDto){
        this.emp = EmployeeStore.createEmployee(empDto);
        return App.getInstance().getCompany().getEmployeeStore().validateEmployee(emp);
    }

    public void saveEmployee(){
        App.getInstance().getCompany().getEmployeeStore().saveEmployee(emp);
    }
}
