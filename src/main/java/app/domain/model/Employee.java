package app.domain.model;

import app.controller.App;
import auth.domain.model.Email;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Employee {

    private UserRole userRole;
    private String employeeId;
    private String name;
    private String address;
    private long phoneNumber;
    private Email email;
    private int socCode;
    private String password;

    public Employee(UserRole userRole, String employeeId, String name, String adress, long phoneNumber, Email email, int socCode) {
        /*Company c = new Company("Many Labs");
        List<UserRoleStore> store = c.getAuthFacade().getRoles();
        for (UserRole ur : store){
            System.out.println("OLA");
            System.out.println(ur);
        }
        if (c.getAuthFacade().addUserRole(userRole.getId(), userRole.getDescription())){
            throw new IllegalArgumentException("User role invalid");
        } */
        this.userRole = userRole;

        this.employeeId = employeeId;

        if (name.length() > 35)
            throw new IllegalArgumentException("Name cannot have more than 35 characters");
        this.name = name;

        if (adress.isEmpty())
            throw new IllegalArgumentException("Adress cannot be empty");
        this.address = adress;

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
        return address;
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

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userRole=" + userRole +
                ", employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                ", socCode=" + socCode +
                '}';
    }

    public String getPassword() {
        return password;
    }
}
