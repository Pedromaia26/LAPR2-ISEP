package app.mappers.dto;

import app.domain.model.Laboratory;
import app.domain.model.TestType;

import java.util.List;

public class LaboratoryDTO {
    /**
     * String that contains the laboratoryID
     */
    private  String laboratoryID;
    /**
     * String that contains the name
     */
    private  String name;
    /**
     * String that contains the address
     */
    private  String address;
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
    private  List<TestType> listPC;

    public LaboratoryDTO(Laboratory lab){
        this.laboratoryID = lab.getLaboratoryID();
        this.name= lab.getName();
        this.address = lab.getAddress();
        this.phoneNumber= lab.getPhoneNumber();
        this.tinNumber=lab.getTinNumber();
        this.listPC = lab.getListPC();
    }

    public String getLaboratoryIDDto() {
        return laboratoryID;
    }

    public String getNameDto() {
        return name;
    }

    public String getAddressDto() {
        return address;
    }

    public long getPhoneNumberDto() {
        return phoneNumber;
    }

    public long getTinNumberDto() {
        return tinNumber;
    }

    public List<TestType> getListPCDto() {
        return listPC;
    }
}
