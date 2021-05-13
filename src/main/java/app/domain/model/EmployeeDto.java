package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.User;
import auth.domain.model.UserRole;

public class EmployeeDto {
    /**
     * Object that contains the Organization Role of a Employee
     */
    private OrgRole userRole;
    /**
     * String that contains the Employee ID of a Employee
     */
    private String employeeId;
    /**
     * String that contains the Name of a Employee
     */
    private String name;
    /**
     * String that contains the Address of a Employee
     */
    private String adress;
    /**
     * Long that contains the Phone Number of a Employee
     */
    private long phoneNumber;
    /**
     * String that contains the Email of a Employee
     */
    private Email email;
    /**
     * Int that contains the SOC code of a Employee
     */
    private int socCode;
    /**
     * Int that contains the Doctor Index Number of a Specialist Doctor
     */
    private int docIndexNumber;

    /**
     * Creates a new Employee with the received information: Organization Role, Employee ID, Name,
     * Address, Phone Number, Email and the SOC code of a Employee.
     *
     * @param userRole The Organization Role of a Employee
     * @param employeeId The Employee ID of a Employee
     * @param name The name of a Employee
     * @param adress The address of a Employee
     * @param phoneNumber The Phone Number of a Employee
     * @param email The Email of a Employee
     * @param socCode The SOC code of a Employee
     */
    public EmployeeDto(OrgRole userRole, String employeeId, String name, String adress, long phoneNumber, Email email, int socCode) {
        this.userRole = userRole;
        this.employeeId = employeeId;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socCode = socCode;
    }

    /**
     * Creates a new Specialist Doctor with the received information: Organization Role, Employee ID, Name,
     * Address, Phone Number, Email, SOC code and the Doctor Index Number of a Specialist Doctor.
     *
     * @param userRole The Organization Role of a Employee
     * @param employeeId The Employee ID of a Employee
     * @param name The name of a Employee
     * @param adress The address of a Employee
     * @param phoneNumber The Phone Number of a Employee
     * @param email The Email of a Employee
     * @param socCode The SOC code of a Employee
     * @param docIndexNumber The Doctor Index Number of a Specialist Doctor
     */
    public EmployeeDto(OrgRole userRole, String employeeId, String name, String adress, long phoneNumber, Email email, int socCode, int docIndexNumber) {
        this.userRole = userRole;
        this.employeeId = employeeId;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socCode = socCode;
        this.docIndexNumber = docIndexNumber;
    }

    /**
     * Returns the Organization Role of a Employee
     * @return the Organization Role of a Employee
     */
    public OrgRole getUserRole() {
        return userRole;
    }

    /**
     * Returns the Employee ID of a Employee
     * @return the Employee ID of a Employee
     */
    public String getEmployeeId() { return employeeId; }

    /**
     * Returna the Name of a Employee
     * @return the Name of a Employee
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Address of a Employee
     * @return the Address of a Employee
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Returns the Phone Number of a Employee
     * @return the Phone Number of a Employee
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the Email of a Employee
     * @return the Email of a Employee
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Returns the SOC code of a Employee
     * @return the SOC code of a Employee
     */
    public int getSocCode() {
        return socCode;
    }

    /**
     * Returns the Doctor Index Number of a Specialist Doctor
     * @return the Doctor Index Number of a Specialist Doctor
     */
    public int getDocIndexNumber() { return docIndexNumber; }
}
