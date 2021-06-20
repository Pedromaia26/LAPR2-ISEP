package app.domain.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Laboratory implements Serializable {
    /**
     * String that contains the laboratoryID
     */
    private final String laboratoryID;
    /**
     * String that contains the name
     */
    private final String name;
    /**
     * String that contains the address
     */
    private final String address;
    /**
     * String that contains the phoneNumber
     */
    private long phoneNumber;
    /**
     * String that contains the tinNumber
     */
    private long tinNumber;
    /**
     * String that contains the Parameter category list
     */
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
    public Laboratory (String laboratoryID, String name, String address, long phoneNumber, long tinNumber, List <TestType> listPC) {

        if (name.trim().length() > 20)
            throw new IllegalArgumentException("Description cannot have more than 20 characters");

        this.name = name;

        if (address.trim().length() > 30)
            throw new IllegalArgumentException("Description cannot have more than 30 characters");

        this.address = address;

        if (String.valueOf(tinNumber).length() != 10)
            throw new IllegalArgumentException("Tax Identification Number should have 10 digits");

        this.tinNumber = tinNumber;

        if (String.valueOf(phoneNumber).length() != 11)
            throw new IllegalArgumentException("Phone number should have 11 digits");

        this.phoneNumber = phoneNumber;


        if (laboratoryID.trim().length() != 5)
            throw new IllegalArgumentException("LaboratoryID must have 5 alphanumeric characters");

        this.laboratoryID = laboratoryID;


        this.listPC = listPC;
    }
    /**
     * Returns the textual description of a laboratory.
     * @return characteristics of a laboratory.
     */
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
    /**
     * Returns the labid of a laboratory.
     * @return the labid of a laboratory.
     */
    public String getLaboratoryID() {
        return laboratoryID;
    }
    /**
     * Returns the name of a laboratory.
     * @return the name of a laboratory.
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the address of a laboratory.
     * @return the address of a laboratory.
     */
    public String getAddress() {
        return address;
    }
    /**
     * Returns the phone number of a laboratory.
     * @return the phone number of a laboratory.
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Returns the tin of a laboratory.
     * @return the tin of a laboratory.
     */
    public long getTinNumber() {
        return tinNumber;
    }
    /**
     * Returns the test types list of a laboratory.
     * @return the test types list of a laboratory.
     */
    public List<TestType> getListPC() {
        return listPC;
    }


}