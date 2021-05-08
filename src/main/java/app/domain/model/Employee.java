package app.domain.model;

public class Employee {

    private int employeeId;
    private String name;
    private String adress;
    private int phoneNumber;
    private String email;
    private int socCode;

    public Employee(int employeeId, String name, String adress, int phoneNumber, String email, int socCode) {
        this.employeeId = employeeId;

        if (name.length() > 35)
            throw new IllegalArgumentException("Name cannot have more than 35 characters");
        this.name = name;

        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socCode = socCode;
    }
}
