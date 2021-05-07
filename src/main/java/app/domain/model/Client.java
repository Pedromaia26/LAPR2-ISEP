package app.domain.model;


import java.util.List;

public class Client {

    private long ccn;
    private long nhs;
    private String birth;
    private String sex;
    private long tif;
    private String email;
    private String name;
    private long phoneNumber;


    public Client (long ccn, long nhs, String birth, String sex, long tif, String email, String name, long phoneNumber) {

        if (String.valueOf(ccn).length()!=16)
            throw new IllegalArgumentException("Description cannot have more than 15 characters");

        this.ccn = ccn;


        if (String.valueOf(nhs).length()!=10)
            throw new IllegalArgumentException("Collecting method cannot have more than 20 characters");

        this.nhs = nhs;

        if (String.valueOf(tif).length()!=10)
            throw new IllegalArgumentException("Code must have 5 alphanumeric characters");

        this.tif = tif;

        if (String.valueOf(phoneNumber).length()!=11)
            throw new IllegalArgumentException("Code must have 5 alphanumeric characters");

        this.phoneNumber = phoneNumber;

        this.name=name;

        //Ver verificacao email

        if(!sex.equals("Male") && !sex.equals("Female"))
            throw new IllegalArgumentException("Incorrect sex");

        this.sex=sex;

        //ver verificacao nascimento

    }

}
