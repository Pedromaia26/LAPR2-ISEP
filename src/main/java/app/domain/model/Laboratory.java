package app.domain.model;

import java.util.List;
import java.util.Objects;

public class Laboratory {

    private final String laboratoryID;
    private final String name;
    private final String address;
    private int phoneNumber;
    private int tinNumber;
    private final List<TestType> listPC;


    /**
     *
     * Create a new Clynical Analysis Laboratory with the kind of test it operates.
     * @param laboratoryID Laboratory ID
     * @param name Laboratory's name
     * @param address Laboratory's address
     * @param phoneNumber Laboratory's phone number
     * @param tinNumber Laboratory's Tax Identification Number
     * @param listPC Types of tests list
     * @return The test type created.
     */
    public Laboratory (String laboratoryID, String name, String address, int phoneNumber, int tinNumber, List <TestType> listPC) {

        if (name.trim().length() > 20)
            throw new IllegalArgumentException("Description cannot have more than 20 characters");

        this.name = name;

        if (address.trim().length() > 30)
            throw new IllegalArgumentException("Description cannot have more than 30 characters");

        this.address = address;

        if (String.valueOf(tinNumber).length() != 11)
            throw new IllegalArgumentException("Phone number should have 11 digits");

        this.tinNumber = tinNumber;

        if (String.valueOf(tinNumber).length() != 10)
            throw new IllegalArgumentException("Tax Identification Number should have 10 digits");

        this.laboratoryID = laboratoryID;

        if (laboratoryID.trim().length() != 5)
            throw new IllegalArgumentException("LaboratoryID must have 5 alphanumeric characters");

        this.phoneNumber = phoneNumber;
        this.listPC = listPC;
    }
    public String toString(){
        return String.format("laboratoryID: %s; Name: %s; Address: %s; Phone Number: %d; tinNumber: %d; Test Types: %s;", laboratoryID, name, address, phoneNumber, tinNumber, listPC);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laboratory laboratory = (Laboratory) o;
        return Objects.equals(name, laboratory.name) && Objects.equals(address, laboratory.address) && Objects.equals(listPC, laboratory.listPC);
    }

}