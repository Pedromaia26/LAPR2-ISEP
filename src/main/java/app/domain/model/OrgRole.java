package app.domain.model;

import auth.domain.model.Email;

public class OrgRole {

    private String description;

    public OrgRole(String orgRole){
        if (orgRole.length() > 15)
            throw new IllegalArgumentException("Organization Role cannot have more than 15 characters");
        this.description = orgRole;
    }

    public void create(String role, String employeeId, String name, String address, long phoneNumber, Email email, int socCode){
        new Employee(role, employeeId, name, address, phoneNumber, email, socCode);
    }

    @Override
    public String toString() {
        return "" + description;
    }
}
