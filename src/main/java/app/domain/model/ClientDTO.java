package app.domain.model;

public class ClientDTO {

    private long ccn;
    private long nhs;
    private String birth;
    private String sex;
    private long tif;
    private String email;
    private String name;
    private long phoneNumber;


    public ClientDTO(long ccn, long nhs, String birth, String sex, long tif, String email, String name, long phoneNumber) {
        this.ccn = ccn;
        this.nhs = nhs;
        this.birth = birth;
        this.sex = sex;
        this.tif = tif;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public long getCcn() {
        return ccn;
    }

    public long getNhs() {
        return nhs;
    }

    public String getBirth() {
        return birth;
    }

    public String getSex() {
        return sex;
    }

    public long getTif() {
        return tif;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "ccn=" + ccn +
                ", nhs=" + nhs +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                ", tif=" + tif +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
