package app.domain.mappers.dto;

import app.domain.model.Company;
import app.mappers.dto.ClientDTO;
import org.junit.Assert;
import org.junit.Test;

public class ClientDTOTest {

    @Test
    public void getCcn() {
        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company c = new Company("Many Labs");
        String ccn = nc.getCcnDto();

        Assert.assertEquals("1234567890123456", ccn);
    }

    @Test
    public void getNhs() {
        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company c = new Company("Many Labs");
        long nhs = nc.getNhsDto();

        Assert.assertEquals(1234567890L, nhs);
    }

    @Test
    public void getBirth() {
        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company c = new Company("Many Labs");
        String birth = nc.getBirthDto();

        Assert.assertEquals("12/12/2012", birth);
    }

    @Test
    public void getSex() {
        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company c = new Company("Many Labs");
        String sex = nc.getSexDto();

        Assert.assertEquals("Male", sex);
    }

    @Test
    public void getTif() {
        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company c = new Company("Many Labs");
        long tif = nc.getTifDto();

        Assert.assertEquals(1234567890L, tif);
    }

    @Test
    public void getEmail() {
        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company c = new Company("Many Labs");
        String email = nc.getEmailDto();

        Assert.assertEquals("asd@gmail.com", email);
    }

    @Test
    public void getName() {
        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company c = new Company("Many Labs");
        String name = nc.getNameDto();

        Assert.assertEquals("Moirane", name);
    }

    @Test
    public void getPhoneNumber() {
        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company c = new Company("Many Labs");
        long phoneneumber = nc.getPhoneNumberDto();

        Assert.assertEquals(44123456789L, phoneneumber);
    }

    @Test
    public void testToString() {
        ClientDTO client = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        String a = client.toString();

        Assert.assertEquals("ccn=1234567890123456, nhs=1234567890, birth=12/12/2012, sex=Male, tin=1234567890, email=asd@gmail.com, name=Moirane, phoneNumber=44123456789", a);
    }


}