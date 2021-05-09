package app.domain.model;


import auth.domain.model.Email;
import auth.domain.model.Password;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Client {

    private long ccn;
    private long nhs;
    private String birth;
    private String sex;
    private long tif;
    private Email email;
    private String name;
    private long phoneNumber;
    private Password password;


    public Client (long ccn, long nhs, String birth, String sex, long tif, String email, String name, long phoneNumber) {

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


        if(!sex.toUpperCase().equals("MALE") && !sex.toUpperCase().equals("FEMALE"))
            throw new IllegalArgumentException("Incorrect sex");

        this.sex=sex;

        //ver verificacao nascimento

        if(!birth.matches("^\\d{2}/\\d{2}/\\d{4}$"))
            throw new IllegalArgumentException("Format of the data is incorrect");
        this.birth=birth;

    }




    public void setPassword(Password password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  "ccn=" + ccn +
                ", nhs=" + nhs +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                ", tif=" + tif +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password=" + password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(ccn, client.ccn) && Objects.equals(nhs, client.nhs) && Objects.equals(birth, client.birth) && Objects.equals(sex, client.sex) && Objects.equals(tif, client.tif) && Objects.equals(email, client.email) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(name, client.name);
    }

}
