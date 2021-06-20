package app.domain.model;


import app.controller.App;
import auth.domain.model.Email;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

public class Client implements Serializable {
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
    private Email email;
    /**
     * String that contains the name of a client
     */
    private String name;
    /**
     * String that contains the Phone Number of a client
     */
    private long phoneNumber;
    /**
     * String that contains the Password of a client
     */
    private String password;

    private String address;




    /**
     * Regists a client, receiving by parameter The Citizen Card Number, The National Health Service Number,
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
    public Client (String ccn, long nhs, String birth, String sex, long tif, String email, String name, long phoneNumber, String address) {

        if (String.valueOf(ccn).length()!=16)
            throw new IllegalArgumentException("Citizen Card Number must be 16 characters long");

        this.ccn = ccn;


        if (String.valueOf(nhs).length()!=10)
            throw new IllegalArgumentException("National Health Service Number must be 10 characters long");

        this.nhs = nhs;

        if (String.valueOf(tif).length()!=10)
            throw new IllegalArgumentException("Tax Identification Number must be 10 characters long");

        this.tif = tif;

        if (String.valueOf(phoneNumber).length()!=11)
            throw new IllegalArgumentException("Phone Number must be 11 characters long");

        this.phoneNumber = phoneNumber;
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be Blank");

        if (name.length()>35)
            throw new IllegalArgumentException("Name cannot be longer then 35 characters");


            this.name=name;


        //Ver verificacao email

        this.email= new Email(email);

        if (StringUtils.isBlank(sex)){
            sex="Undifined";
        }

        if(!sex.equalsIgnoreCase("MALE") && !sex.equalsIgnoreCase("FEMALE") && !sex.equalsIgnoreCase("UNDIFINED"))
            throw new IllegalArgumentException("Incorrect sex");

        this.sex=sex;

        //ver verificacao nascimento

        if(!birth.matches("^\\d{2}/\\d{2}/\\d{4}$"))
            throw new IllegalArgumentException("Format of the data is incorrect");

        int anosdif=calculateAge(birth);

        if (anosdif<=0)
            throw new IllegalArgumentException("Incorrect data");

        if (anosdif>150)
            throw new IllegalArgumentException("Client older than 150 years");


        this.birth=birth;

        this.address=address;

    }

    /**
     * Change the password of a client.
     * @param password the new password of a client.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Returns the integral Age of a client.
     * @return Age of a client.
     */
    public int calculateAge(String birth){
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String data=formatter.format(date);

        String[] array = data.split("/");

        String[] array2 = birth.split("/");
        int anosdif=Integer.parseInt(array[2])-Integer.parseInt(array2[2])-1;

        if (Integer.parseInt(array[1])>Integer.parseInt(array2[1])){
            anosdif++;
        }
        else {
            if (Integer.parseInt(array[1])==Integer.parseInt(array2[1])){
                if (Integer.parseInt(array[0])>=Integer.parseInt(array2[0])){
                    anosdif++;
                }
            }
        }
        return anosdif;
    }

    /**
     * Returns the textual description of a client.
     * @return characteristics of a client.
     */
    @Override
    public String toString() {
        return  String.format("ccn=%s, nhs=%d, birth=%s, sex=%s, tif=%d, email=%s, name=%s, phoneNumber=%d",ccn,nhs,birth,sex,tif,email,name, phoneNumber );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return this.getCcn().equals((client).getCcn()) || this.getNhs()==((client).getNhs()) || this.getTif()==((client).getTif()) || this.getEmail().getEmail().equals((client).getEmail().getEmail()) || this.getPhoneNumber()==(client).getPhoneNumber();
    }

    /**
     * Returns the email of a client.
     * @return the email of a client.
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Returns the Name of a client.
     * @return the name of a client.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the password of a client.
     * @return the password of a client.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Returns the ccn of a client.
     * @return ccn of a client.
     */
    public String getCcn() {
        return ccn;
    }
    /**
     * Returns the nhs of a client.
     * @return nhs of a client.
     */
    public long getNhs() {
        return nhs;
    }
    /**
     * Returns the date of birth of a client.
     * @return birth date of a client.
     */
    public String getBirth() {
        return birth;
    }
    /**
     * Returns the sex of a client.
     * @return sex of a client.
     */
    public String getSex() {
        return sex;
    }
    /**
     * Returns the tin number of a client.
     * @return tin number of a client.
     */
    public long getTif() {
        return tif;
    }
    /**
     * Returns the phone number of a client.
     * @return phone number of a client.
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Notify the client that the test is available in the system.
     */
    public void notifyClient() throws IOException {

        String pwd = System.getProperty("user.dir");


        File emailAndSMSMessages = new File(pwd + "\\src\\main\\emailAndSMSMessages");
        if (!emailAndSMSMessages.exists()) {
            emailAndSMSMessages.mkdirs();
        }

        PrintWriter asd = new PrintWriter(pwd + "\\src\\main\\emailAndSMSMessages\\notify_"+name+"_"+ccn+".txt");

        asd.printf("Dear Client %s, with CCN %s,\nYour test was validated and you can check it when you want.\nHave a good day,\nMany Labs.\n",name,ccn);

        asd.close();

    }
    /**
     * set the email of client.
     */
    public void setEmail(Email email) {
        this.email = email;
    }
    /**
     * set the phone number of client.
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * set the ccn of client.
     */
    public void setCcn(String ccn) {
        this.ccn = ccn;
    }
    /**
     * set the nhs of client.
     */
    public void setNhs(long nhs) {
        this.nhs = nhs;
    }
    /**
     * set the birth day of client.
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }
    /**
     * set the sex of client.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * set the tin of client.
     */
    public void setTif(long tif) {
        this.tif = tif;
    }
    /**
     * set the name of client.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * set the address of client.
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
