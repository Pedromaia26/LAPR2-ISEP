package app.domain.model;

public class EmployeeDto {

    private String userRole;
    private String name;
    private String adress;
    private long phoneNumber;
    private String email;
    private int socCode;

    public String getUserRole() {
        return userRole;
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

    public String getEmail() {
        return email;
    }

    public int getSocCode() {
        return socCode;
    }
}
