package app.domain.model;

import app.domain.shared.Constants;
import auth.domain.model.Email;
import auth.domain.model.UserRole;

public class OrgRole {

    private String designation;

    public OrgRole(){}

    public OrgRole(String designation){
        this.designation = designation;
    }

    public  Employee createEmployee(String Orole, String employeeId, String name, String address, long phoneNumber, Email email, int socCode){
        OrgRole role = new OrgRole(Orole);
        return new Employee(role, employeeId, name, address, phoneNumber, email, socCode);
    }

    public SpecialistDoctor createEmployee(String Orole, String employeeId, String name, String address, long phoneNumber, Email email, int socCode, int docIndexNumber){
        OrgRole role = new OrgRole(Orole);
        return new SpecialistDoctor(role, employeeId, name, address, phoneNumber, email, socCode, docIndexNumber);
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return designation;

    }
}
