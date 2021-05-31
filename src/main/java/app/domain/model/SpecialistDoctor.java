package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.UserRole;

import java.util.Objects;

public class SpecialistDoctor extends Employee {

    /**
     * Int that contains the Doctor Index Number of a Specialist Doctor
     */
    private int docIndexNumber;

    /**
     * Regists a new employee, receiving by parameter the Organization Role, Employee ID,
     * Name, Address, Phone Number, Email ,SOC code and Doctor Index Number of a Specialist Doctor.
     * Checks the parameters format.
     *
     * @param userRole The Organization Role of a Specialist Doctor
     * @param employeeId The Employee ID of a Specialist Doctor
     * @param name The name of a Specialist Doctor
     * @param adress The address of a Specialist Doctor
     * @param phoneNumber The Phone Number of a Specialist Doctor
     * @param email The Email of a Specialist Doctor
     * @param socCode The SOC code of a Specialist Doctor
     * @param docIndexNumber The Doctor Index Number of a Specialist Doctor
     */
    public SpecialistDoctor(OrgRole userRole, String employeeId, String name, String adress, long phoneNumber, Email email, int socCode,Laboratory lab, int docIndexNumber) {
        super(userRole, employeeId, name, adress, phoneNumber, email, socCode, lab);
        if(String.valueOf(docIndexNumber).length() != 6)
            throw new IllegalArgumentException("Doctor Index Number should have 6 digits.");
        this.docIndexNumber = docIndexNumber;
    }

    /**
     * Returns the Doctor Index Number of a Specialist Doctor
     * @return the Doctor Index Number of a Specialist Doctor
     */
    public int getDocIndexNumber() {
        return docIndexNumber;
    }

    /**
     * Returns a String with the information of a Specialist Doctor
     * @return attributes of a Specialist Doctor
     */
    @Override
    public String toString() {
        return "SpecialistDoctor{" +
                "docIndexNumber=" + docIndexNumber +
                '}';
    }

    /**
     * Verify if 2 Specialist Doctors have the same information
     * @param o A Object
     * @return A boolean that is true if the 2 Employees have the same information, and false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpecialistDoctor that = (SpecialistDoctor) o;
        return docIndexNumber == that.docIndexNumber;
    }
}
