package app.mappers.dto;

import app.domain.model.Client;

public class ClientDTO {
    /**
     * String that contains the Citizen card number
     */
    private String ccn;
    /**
     * String that contains the National Health Service Number
     */
    private long nhs;
    /**
     * String that contains the date of birth
     */
    private String birth;
    /**
     * String that contains the sex of a client
     */
    private String sex;
    /**
     * String that contains the Tax Identification Number
     */
    private long tif;
    /**
     * String that contains the email of a client
     */
    private String email;
    /**
     * String that contains the name of a client
     */
    private String name;
    /**
     * String that contains the Phone Number of a client
     */
    private long phoneNumber;

    private String address;

    /**
     * Regists a clientDTO, receiving by parameter The Citizen Card Number, The National Health Service Number,
     * The date of birth, The sex of a client, The Tax Identification Number, The email of a client, The name of a client, The Phone Number of a client.
     * Checks all parameters rules to see if the inputted data is valid.
     *
     * @param ccn The Citizen Card Number
     * @param nhs The National Health Service Number
     * @param birth The date of birth
     * @param sex The sex of a client
     * @param tif The Tax Identification Number
     * @param email The email of a client
     * @param name The name of a client
     * @param phoneNumber The Phone Number of a client
     */

    public ClientDTO(String ccn, long nhs, String birth, String sex, long tif, String email, String name, long phoneNumber, String adress) {
        this.ccn = ccn;
        this.nhs = nhs;
        this.birth = birth;
        this.sex = sex;
        this.tif = tif;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address=adress;
    }

    /**
     * Regists a clientDTO, receiving by parameter client
     * @param client The Citizen Card Number
     */
    public ClientDTO(Client client){
        this.ccn = client.getCcn();
        this.birth= client.getBirth();
        this.nhs = client.getNhs();
        this.sex = client.getSex();
        this.email=String.valueOf(client.getEmail());
        this.name=client.getName();
        this.phoneNumber= client.getPhoneNumber();
        this.tif=client.getTif();
        this.address=client.getAddress();
    }



    /**
     * Returns the Citizen Card Number of a client.
     * @return the Citizen Card Number of a client.
     */
    public String getCcnDto() {
        return ccn;
    }
    /**
     * Returns the National Health Service Number of a client.
     * @return the National Health Service Number of a client.
     */
    public long getNhsDto() {
        return nhs;
    }
    /**
     * Returns the date of birth of a client.
     * @return the date of birth of a client.
     */
    public String getBirthDto() {
        return birth;
    }
    /**
     * Returns the sex of a client.
     * @return the sex of a client.
     */
    public String getSexDto() {
        return sex;
    }
    /**
     * Returns the Tax Identification Number of a client.
     * @return the Tax Identification Number of a client.
     */
    public long getTifDto() {
        return tif;
    }
    /**
     * Returns the email of a client.
     * @return the email of a client.
     */
    public String getEmailDto() {
        return email;
    }
    /**
     * Returns the name of a client.
     * @return the name of a client.
     */
    public String getNameDto() {
        return name;
    }
    /**
     * Returns the Phone Number of a client.
     * @return the Phone Number of a client.
     */
    public long getPhoneNumberDto() {
        return phoneNumber;
    }

    public String getAddressDto() {
        return address;
    }

    /**
     * Returns the textual description of a clientDTO.
     * @return characteristics of a clientDTO.
     */
    @Override
    public String toString() {
        return  String.format("ccn=%s, nhs=%d, birth=%s, sex=%s, tin=%d, email=%s, name=%s, phoneNumber=%d",ccn,nhs,birth,sex,tif,email,name, phoneNumber );
    }
}
