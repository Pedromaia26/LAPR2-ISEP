package app.domain.model;


import auth.domain.model.Email;
import auth.domain.model.Password;

import java.util.Date;
import java.util.List;

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

        if (name.length()>35)
            throw new IllegalArgumentException("Name cannot be longer then 35 characters");
            this.name=name;

        //Ver verificacao email

        this.email= new Email(email);


        if(!sex.equals("Male") && !sex.equals("Female"))
            throw new IllegalArgumentException("Incorrect sex");

        this.sex=sex;

        //ver verificacao nascimento

        if(!birth.matches("^\\d{2}/\\d{2}/\\d{4}$"))
            throw new IllegalArgumentException("Format of the data is incorrect");
        this.birth=birth;

    }
    public static int soma(int a, int b){
        return a+b;
    }




    public void setPassword(Password password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ccn=" + ccn +
                ", nhs=" + nhs +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                ", tif=" + tif +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password=" + password +
                '}';
    }
}
