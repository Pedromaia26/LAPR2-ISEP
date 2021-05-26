package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.UserRole;

import java.util.Objects;

public class SpecialistDoctor extends Employee {

    private int docIndexNumber;

    public SpecialistDoctor(OrgRole userRole, String employeeId, String name, String adress, long phoneNumber, Email email, int socCode, int docIndexNumber) {
        super(userRole, employeeId, name, adress, phoneNumber, email, socCode);
        if(String.valueOf(docIndexNumber).length() != 6)
            throw new IllegalArgumentException("Doctor Index Number should have 6 digits.");
        this.docIndexNumber = docIndexNumber;
    }

    public int getDocIndexNumber() {
        return docIndexNumber;
    }

    @Override
    public String toString() {
        return "SpecialistDoctor{" +
                "docIndexNumber=" + docIndexNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpecialistDoctor that = (SpecialistDoctor) o;
        return docIndexNumber == that.docIndexNumber;
    }
}
