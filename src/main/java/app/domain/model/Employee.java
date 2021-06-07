package app.domain.model;

import app.controller.App;
import auth.domain.model.Email;
import auth.domain.model.UserRole;
import auth.domain.store.UserRoleStore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Employee implements Serializable {

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
    private String address;
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
     * String that contains the Password of a Employee
     */
    private String password;

    private Laboratory laboratory;

    /**
     * Regists a new employee, receiving by parameter the Organization Role, Employee ID,
     * Name, Address, Phone Number, Email and SOC code of a Employee.
     * Checks the parameters format.
     *
     * @param userRole The Organization Role of a Employee
     * @param employeeId The Employee ID of a Employee
     * @param name The name of a Employee
     * @param adress The address of a Employee
     * @param phoneNumber The Phone Number of a Employee
     * @param email The Email of a Employee
     * @param socCode The SOC code of a Employee
     */
    public Employee(OrgRole userRole, String employeeId, String name, String adress, long phoneNumber, Email email, int socCode, Laboratory lab) {
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

        this.laboratory=lab;
    }

    /**
     * Returns the Organization Role of a Employee
     * @return the Organization Role of a Employee
     */
    public String getUserRole() {
        return userRole.getDesignation();
    }

    /**
     * Returns the Employee ID of a Employee
     * @return the Employee ID of a Employee
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Returns the name of a Employee
     * @return the name of a Employee
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Address of a Employee
     * @return the Address of a Employee
     */
    public String getAdress() {
        return address;
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
     * Change the Password of a Employee
     * @param password The Password of a Employee
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    /**
     * Returns a String with the information of a employee
     * @return attributes of a Employee
     */


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

    /**
     * Returns the Password of a Employee
     * @return the Password of a Employee
     */
    public String getPassword() {
        return password;
    }

    /**
     * Verify if 2 Employees have the same information
     * @param o A Object
     * @return A boolean that is true if the 2 Employees have the same information, and false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee emp = (Employee) o;
        return Objects.equals(userRole.getDesignation(), emp.userRole.getDesignation()) && Objects.equals(employeeId, emp.employeeId) && Objects.equals(name, emp.name) && Objects.equals(address, emp.address) && Objects.equals(phoneNumber, emp.phoneNumber) && Objects.equals(email, emp.email) && Objects.equals(socCode, emp.socCode);
    }
}
