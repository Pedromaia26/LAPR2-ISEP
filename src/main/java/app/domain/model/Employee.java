package app.domain.model;

import app.controller.App;
import auth.domain.model.Email;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Employee {

    private OrgRole userRole;
    private String employeeId;
    private String name;
    private String address;
    private long phoneNumber;
    private Email email;
    private int socCode;
    private String password;

    public Employee(OrgRole userRole, String employeeId, String name, String adress, long phoneNumber, Email email, int socCode) {
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

    public String getUserRole() {
        return userRole.getDesignation();
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee client = (Employee) o;
        return Objects.equals(userRole, client.userRole) && Objects.equals(employeeId, client.employeeId) && Objects.equals(name, client.name) && Objects.equals(address, client.address) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(email, client.email) && Objects.equals(socCode, client.socCode);
    }
}
