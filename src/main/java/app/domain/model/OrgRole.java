package app.domain.model;

import app.domain.shared.Constants;
import auth.domain.model.Email;
import auth.domain.model.UserRole;

public class OrgRole {

    /**
     * String that contains the Designation of a OrgRole
     */
    private String designation;

    /**
     * Constructor that create a empty instance of a OrgRole
     */
    public OrgRole(){}

    /**
     * Create a new instance of a OrgRole, receiving by parameter the designation
     * @param designation Designation of a OrgRole
     */
    public OrgRole(String designation){
        this.designation = designation;
    }

    /**
     * Receive by parameter the attributes of a Employee, and return the method to create a instance of a Employee
     * @param Orole a String that contains the description of intended OrgRole
     * @param employeeId the EmployeeID of a Employee
     * @param name the Name of a Employee
     * @param address the Address of a Employee
     * @param phoneNumber the Phone Number of a Employee
     * @param email the Email of a Employee
     * @param socCode the SocCode of a Employee
     * @return the Constructor to a new Employee
     */
    public  Employee createEmployee(String Orole, String employeeId, String name, String address, long phoneNumber, Email email, int socCode){
        OrgRole role = new OrgRole(Orole);
        return new Employee(role, employeeId, name, address, phoneNumber, email, socCode);
    }

    /**
     * Receive by parameter the attributes of a Specialist Doctor, and return the method to create a instance of a Specialist Doctor
     * Receive by parameter the attributes of a Specialist Doctor, and return the method to create a instance of a Specialist Doctor
     * @param Orole a String that contains the description of intended OrgRole
     * @param employeeId the EmployeeID of a Specialist Doctor
     * @param name the Name of a Specialist Doctor
     * @param address the Address of a Specialist Doctor
     * @param phoneNumber the Phone Number of a Specialist Doctor
     * @param email the Email of a Specialist Doctor
     * @param socCode the SocCode of a Specialist Doctor
     * @param docIndexNumber the Doctor Index Number of a Specialist Doctor
     * @return the Constructor to a new Specialist Doctor
     */
    public SpecialistDoctor createEmployee(String Orole, String employeeId, String name, String address, long phoneNumber, Email email, int socCode, int docIndexNumber){
        OrgRole role = new OrgRole(Orole);
        return new SpecialistDoctor(role, employeeId, name, address, phoneNumber, email, socCode, docIndexNumber);
    }

    /**
     * Returns the Description of a OrgRole
     * @return the Description of a OrgRole
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Returns a String with the information of a OrgRole
     * @return attributes of a OrgRole
     */
    @Override
    public String toString() {
        return designation;
    }


}
