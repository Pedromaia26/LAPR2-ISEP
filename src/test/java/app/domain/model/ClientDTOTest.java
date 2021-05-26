package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientDTOTest {

    @Test
    public void getCcn() {
        ClientDTO nc = new ClientDTO(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company c = new Company("Many Labs");
        long ccn = nc.getCcn();

        Assert.assertEquals(1234567890123456L, ccn);
    }

    @Test
    public void getNhs() {
        ClientDTO nc = new ClientDTO(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company c = new Company("Many Labs");
        long nhs = nc.getNhs();

        Assert.assertEquals(1234567890L, nhs);
    }

    @Test
    public void getBirth() {
        ClientDTO nc = new ClientDTO(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company c = new Company("Many Labs");
        String birth = nc.getBirth();

        Assert.assertEquals("12/12/2012", birth);
    }

    @Test
    public void getSex() {
        ClientDTO nc = new ClientDTO(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company c = new Company("Many Labs");
        String sex = nc.getSex();

        Assert.assertEquals("Male", sex);
    }

    @Test
    public void getTif() {
        ClientDTO nc = new ClientDTO(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company c = new Company("Many Labs");
        long tif = nc.getTif();

        Assert.assertEquals(1234567890L, tif);
    }

    @Test
    public void getEmail() {
        ClientDTO nc = new ClientDTO(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company c = new Company("Many Labs");
        String email = nc.getEmail();

        Assert.assertEquals("asd@gmail.com", email);
    }

    @Test
    public void getName() {
        ClientDTO nc = new ClientDTO(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company c = new Company("Many Labs");
        String name = nc.getName();

        Assert.assertEquals("Moirane", name);
    }

    @Test
    public void getPhoneNumber() {
        ClientDTO nc = new ClientDTO(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company c = new Company("Many Labs");
        long phoneneumber = nc.getPhoneNumber();

        Assert.assertEquals(44123456789L, phoneneumber);
    }

    @Test
    public void testToString() {
        ClientDTO client = new ClientDTO(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        String a = client.toString();

        Assert.assertEquals("ccn=1234567890123456, nhs=1234567890, birth=12/12/2012, sex=Male, tif=1234567890, email=asd@gmail.com, name=Moirane, phoneNumber=44123456789", a);
    }


}