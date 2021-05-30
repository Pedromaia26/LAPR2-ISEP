package app.domain.model;

import app.controller.App;
import auth.domain.model.Email;
import auth.domain.model.User;
import auth.domain.model.UserRole;

public class EmployeeDto {
    /**
     * Object that contains the Organization Role of a Employee
     */
    private String orgRole;
    /**
     * String that contains the Employee id
     */
    private String id;
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
     * Int that contains the Doctor Index Number of a Specialist Doctor
     */
    private int docIndexNumber;

    /**
     * Creates a new Employee with the received information: Organization Role, Employee ID, Name,
     * Address, Phone Number, Email and the SOC code of a Employee.
     *
     * @param orgRole The Organization Role of a Employee
     * @param name The name of a Employee
     * @param adress The address of a Employee
     * @param phoneNumber The Phone Number of a Employee
     * @param email The Email of a Employee
     * @param socCode The SOC code of a Employee
     */
    public EmployeeDto(String orgRole, String name, String adress, long phoneNumber, Email email, int socCode) {
        this.orgRole = orgRole;
        this.name = name;
        this.address = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socCode = socCode;
    }

    /**
     * Creates a new Specialist Doctor with the received information: Organization Role, Employee ID, Name,
     * Address, Phone Number, Email, SOC code and the Doctor Index Number of a Specialist Doctor.
     *
     * @param orgRole The Organization Role of a Employee
     * @param name The name of a Employee
     * @param adress The address of a Employee
     * @param phoneNumber The Phone Number of a Employee
     * @param email The Email of a Employee
     * @param socCode The SOC code of a Employee
     * @param docIndexNumber The Doctor Index Number of a Specialist Doctor
     */
    public EmployeeDto(String orgRole, String name, String adress, long phoneNumber, Email email, int socCode, int docIndexNumber) {
        this.orgRole = orgRole;
        this.name = name;
        this.address = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socCode = socCode;
        this.docIndexNumber = docIndexNumber;
    }

    /**
     * Returns the Organization Role of a Employee
     * @return the Organization Role of a Employee
     */
    public String getUserRole() {
        return orgRole;
    }
    /**
     * Returns the id of a Employee
     * @return the id of a Employee
     */
    public String getId() {
        id = String.valueOf(Character.toUpperCase(name.charAt(0)));
        for (int i = 1; i < name.length(); i++){
            if(name.charAt(i) == ' '){
                id += Character.toUpperCase(name.charAt(i + 1));
            }
        }
        id += String.format("%05d", App.getInstance().getCompany().getEmployeeStore().getEmployeeList().size()+1);
        return id;
    }
    /**
     * Returns the Name of a Employee
     * @return the Name of a Employee
     */
    public String getNameDto() {
        return name;
    }

    /**
     * Returns the Address of a Employee
     * @return the Address of a Employee
     */
    public String getAdressDto() {
        return address;
    }

    /**
     * Returns the Phone Number of a Employee
     * @return the Phone Number of a Employee
     */
    public long getPhoneNumberDto() {
        return phoneNumber;
    }

    /**
     * Returns the Email of a Employee
     * @return the Email of a Employee
     */
    public Email getEmailDto() {
        return email;
    }

    /**
     * Returns the SOC code of a Employee
     * @return the SOC code of a Employee
     */
    public int getSocCodeDto() {
        return socCode;
    }

    /**
     * Returns the Doctor Index Number of a Specialist Doctor
     * @return the Doctor Index Number of a Specialist Doctor
     */
    public int getDocIndexNumberDto() { return docIndexNumber; }
    /**
     * Returns the textual description of a employeeDto.
     * @return characteristics of a employeeDto.
     */
    @Override
    public String toString() {
        return "EmployeeDto{" +
                "orgRole='" + orgRole + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                ", socCode=" + socCode +
                ", docIndexNumber=" + docIndexNumber +
                '}';
    }
}
