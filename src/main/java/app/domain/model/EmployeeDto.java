package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.User;
import auth.domain.model.UserRole;

public class EmployeeDto {

    private UserRole userRole;
    private String employeeId;
    private String name;
    private String adress;
    private long phoneNumber;
    private Email email;
    private int socCode;
    private int docIndexNumber;

    public EmployeeDto(UserRole userRole, String employeeId, String name, String adress, long phoneNumber, Email email, int socCode) {
        this.userRole = userRole;
        this.employeeId = employeeId;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socCode = socCode;
    }

    public EmployeeDto(UserRole userRole, String employeeId, String name, String adress, long phoneNumber, Email email, int socCode, int docIndexNumber) {
        this.userRole = userRole;
        this.employeeId = employeeId;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socCode = socCode;
        this.docIndexNumber = docIndexNumber;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public String getEmployeeId() { return employeeId; }

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

    public int getDocIndexNumber() { return docIndexNumber; }
}
