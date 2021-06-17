package app.domain.model;

import app.mappers.dto.ClientDTO;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

public class ClientTest {

/*
    @Test
    public void setPassword() {
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Password pw = new Password("123456789");
        client.setPassword(pw);
        String name = client.;

        Assert.assertEquals ("Antibodies", name);
    }
*/

    @Test
    public void testToString() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        String a = client.toString();

        Assert.assertEquals("ccn=1234567890123456, nhs=1234567890, birth=12/12/2012, sex=Male, tif=1234567890, email=asd@gmail.com, name=Moirane, phoneNumber=44123456789", a);
    }

    @Test
    public void testEquals() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Client client1 = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Assert.assertEquals(client,client1);






    }

    @Test
    public void testEqualsNull() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Client client9 = null;

        Assert.assertNotEquals(client,client9);
    }
    @Test
    public void testEqualsDiffCCN() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Client client2 = new Client("1234567890123457",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Assert.assertNotEquals(client.getCcn(),client2.getCcn());
    }

    @Test
    public void testEqualsDiffNHS() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Client client3 = new Client("1234567890123456",1234567899L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Assert.assertNotEquals(client.getNhs(),client3.getNhs());
    }
    @Test
    public void testEqualsDiffBirth() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Client client4 = new Client("1234567890123456",1234567890L,"12/12/2013","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Assert.assertNotEquals(client.getBirth(),client4.getBirth());
    }

    @Test
    public void testEqualsDiffSex() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Client client5 = new Client("1234567890123456",1234567890L,"12/12/2012","Female",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Assert.assertNotEquals(client.getSex(),client5.getSex());
    }

    @Test
    public void testEqualsDiffTin() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Client client6 = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567895L,"asde@gmail.com","Moirane",44123456789L,"asdasda");

        Assert.assertNotEquals(client.getTif(),client6.getTif());
    }

    @Test
    public void testEqualsDiffName() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Client client7 = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Random",44123456789L,"asdasda");

        Assert.assertNotEquals(client.getName(),client7.getName());
    }

    @Test
    public void testEqualsDiffEmail() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Client client8 = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asde@gmail.com","Moirane",44123456789L,"asdasda");

        Assert.assertNotEquals(client.getEmail().getEmail(),client8.getEmail().getEmail());
    }

    @Test
    public void testEqualsDiffPN() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Client client8 = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456723L,"asdasda");

        Assert.assertNotEquals(client.getPhoneNumber(),client8.getPhoneNumber());
    }

    @Test
    public void testEqualsDiffClass() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        ClientDTO client10 = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Assert.assertNotEquals(client,client10);
    }

    @Test
    public void testEqualsSameObject() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");


        Assert.assertEquals(client,client);

    }

        @Test(expected = IllegalArgumentException.class)
    public void ClientCheckNHSRules() {
        Client client = new Client("1234567890123456",123456789L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckBirthRules() {
        Client client = new Client("1234567890123456",1234567890L,"12/12-2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckTifRules() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",123456789L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckPhoneNumberRules() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",4412345689L,"asdasda");

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckNameNullRules() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com",null,44123456789L,"asdasda");

    }
    @Test
    public void ClientCheckName35Rules() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuiopasdfghjklçzxcvbnmqwertyui",44123456789L,"asdasda");

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckNamemore35Rules() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuiopasdfghjklçzxcvbnmqwertyuia",44123456789L,"asdasda");

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckCCNRules() {
        Client client = new Client("12345678901234567",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckEmailRules() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,null,"Moirane",44123456789L,"asdasda");

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckEmailBlankRules() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd","Moirane",44123456789L,"asdasda");

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckSexRules() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","ASD",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

    }
    @Test
    public void ClientCheckSexlowercaseRules() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

    }

    @Test
    public void calculateAge150() {
        Company c= new Company("ManyLabs");
        Client client = new Client("1234567890123456",1234567890L,"09/05/1871","male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        int anosdif= client.calculateAge("09/05/1871");

        Assert.assertEquals(anosdif,150);

    }
    @Test(expected = IllegalArgumentException.class)
    public void calculateAge150plus() {
        Company c= new Company("ManyLabs");
        Client client = new Client("1234567890123456",1234567890L,"09/05/1870","male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        int anosdif= client.calculateAge("09/05/1871");

        Assert.assertEquals(anosdif,151);

    }
    @Test
    public void calculateAge() {
        Company c= new Company("ManyLabs");
        Client client = new Client("1234567890123456",1234567890L,"09/05/1871","male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        int anosdif= client.calculateAge("09/05/2000");

        Assert.assertEquals(anosdif,21);

    }

    @Test
    public void getEmail() {
        Client nc = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company c = new Company("Many Labs");
        Email email = nc.getEmail();

        Assert.assertEquals(String.valueOf(email), "asd@gmail.com");
    }

    @Test
    public void getName() {
        Client nc = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company c = new Company("Many Labs");
        String name = nc.getName();

        Assert.assertEquals(name, "Moirane");
    }
}