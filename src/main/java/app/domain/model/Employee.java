package app.domain.model;

import auth.domain.model.Email;

public class Employee {

    private String userRole;
    private String employeeId;
    private String name;
    private String adress;
    private long phoneNumber;
    private Email email;
    private int socCode;

    public Employee(String userRole, String employeeId, String name, String adress, long phoneNumber, Email email, int socCode) {
        this.employeeId = employeeId;

        if (name.length() > 35)
            throw new IllegalArgumentException("Name cannot have more than 35 characters");
        this.name = name;

        if (adress.isEmpty())
            throw new IllegalArgumentException("Adress cannot be empty");
        this.adress = adress;

        if (String.valueOf(socCode).length() != 11)
            throw new IllegalArgumentException("Phone number cannot have more than 11 digits");
        this.phoneNumber = phoneNumber;

        this.email = new Email(email.toString());

        if (String.valueOf(socCode).length() != 4)
            throw new IllegalArgumentException("Soc code cannot have more than 4 characters");
        this.socCode = socCode;

        this.userRole = userRole;
    }

    public String getUserRole() {
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
}
