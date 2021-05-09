package app.domain.model;

import app.controller.App;
import auth.domain.model.Email;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

public class Employee {

    private UserRole userRole;
    private String employeeId;
    private String name;
    private String adress;
    private long phoneNumber;
    private Email email;
    private int socCode;

    public Employee(UserRole userRole, String employeeId, String name, String adress, long phoneNumber, Email email, int socCode) {
        Company c = new Company("Many Labs");
        if(!(c.getAuthFacade().addUserRole(userRole.getId(), userRole.getDescription()))){
            System.out.println("OLA");
            throw new IllegalArgumentException("User role invalid");
        }
        this.userRole = userRole;

        this.employeeId = employeeId;

        if (name.length() > 35)
            throw new IllegalArgumentException("Name cannot have more than 35 characters");
        this.name = name;

        if (adress.isEmpty())
            throw new IllegalArgumentException("Adress cannot be empty");
        this.adress = adress;

        if (String.valueOf(phoneNumber).length() != 11)
            throw new IllegalArgumentException("Phone number should have 11 digits");
        this.phoneNumber = phoneNumber;

        this.email = new Email(email.toString());

        if (String.valueOf(socCode).length() != 4)
            throw new IllegalArgumentException("Soc code should have 4 characters");
        this.socCode = socCode;

        this.userRole = userRole;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public Email getEmail() {
        return email;
    }

    public int getSocCode() {
        return socCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userRole=" + userRole +
                ", employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                ", socCode=" + socCode +
                '}';
    }
}
