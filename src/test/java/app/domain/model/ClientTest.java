package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.Password;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        String a = client.toString();

        Assert.assertEquals("ccn=1234567890123456, nhs=1234567890, birth='12/12/2012', sex='Male', tif=1234567890, email='asd@gmail.com', name='Moirane', phoneNumber=44123456789, password=null", a);
    }

    @Test
    public void testEquals() {
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Client client1 = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Client client2 = new Client(1234567890123457L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Client client3 = new Client(1234567890123456L,1234567899L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Client client4 = new Client(1234567890123456L,1234567890L,"12/12/2013","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Client client5 = new Client(1234567890123456L,1234567890L,"12/12/2012","Female",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Client client6 = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567895L,"asde@gmail.com","Moirane",44123456789L);
        Client client7 = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Random",44123456789L);
        Client client8 = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456723L);

        Client client11 = new Client(1234567890123459L,1234567899L,"12/12/2016","Female",1234567897L,"asde@gmail.com","Random",44123456723L);
        Client client12 = new Client(1234567890123456L,1234567899L,"12/12/2016","Female",1234567897L,"asde@gmail.com","Random",44123456723L);
        Client client13 = new Client(1234567890123456L,1234567890L,"12/12/2016","Female",1234567897L,"asde@gmail.com","Random",44123456723L);
        Client client14 = new Client(1234567890123456L,1234567890L,"12/12/2012","Female",1234567897L,"asde@gmail.com","Random",44123456723L);
        Client client15 = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567897L,"asde@gmail.com","Random",44123456723L);
        Client client16 = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asde@gmail.com","Random",44123456723L);
        Client client17 = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Random",44123456723L);




        Client client9 = null;

        ClientDTO client10 = new ClientDTO(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);



        Assert.assertNotEquals(client,client2);
        Assert.assertNotEquals(client,client3);
        Assert.assertNotEquals(client,client4);
        Assert.assertNotEquals(client,client5);
        Assert.assertNotEquals(client,client6);
        Assert.assertNotEquals(client,client7);
        Assert.assertNotEquals(client,client8);
        Assert.assertEquals(client,client1);
        Assert.assertNotEquals(client,client9);
        Assert.assertNotEquals(client,client10);
        Assert.assertEquals(client,client);
        Assert.assertNotEquals(client,client11);
        Assert.assertNotEquals(client,client12);
        Assert.assertNotEquals(client,client13);
        Assert.assertNotEquals(client,client14);
        Assert.assertNotEquals(client,client15);
        Assert.assertNotEquals(client,client16);
        Assert.assertNotEquals(client,client17);



    }

    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckNHSRules() {
        Client client = new Client(1234567890123451L,123456789L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckBirthRules() {
        Client client = new Client(1234567890123451L,1234567890L,"12/12-2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckTifRules() {
        Client client = new Client(1234567890123451L,1234567890L,"12/12/2012","Male",123456789L,"asd@gmail.com","Moirane",44123456789L);

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckPhoneNumberRules() {
        Client client = new Client(1234567890123451L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",4412345689L);

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckNameNullRules() {
        Client client = new Client(1234567890123451L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com",null,44123456789L);

    }
    @Test
    public void ClientCheckName35Rules() {
        Client client = new Client(1234567890123451L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuiopasdfghjklçzxcvbnmqwertyui",44123456789L);

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckNamemore35Rules() {
        Client client = new Client(1234567890123451L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuiopasdfghjklçzxcvbnmqwertyuia",44123456789L);

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckCCNRules() {
        Client client = new Client(123456789012345L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckEmailRules() {
        Client client = new Client(1234567890123451L,1234567890L,"12/12/2012","Male",1234567890L,null,"Moirane",44123456789L);

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckEmailBlankRules() {
        Client client = new Client(1234567890123451L,1234567890L,"12/12/2012","Male",1234567890L,"asd","Moirane",44123456789L);

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckSexRules() {
        Client client = new Client(1234567890123451L,1234567890L,"12/12/2012","ASD",1234567890L,"asd@gmail.com","Moirane",44123456789L);

    }
    @Test
    public void ClientCheckSexlowercaseRules() {
        Client client = new Client(1234567890123451L,1234567890L,"12/12/2012","male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

    }

    @Test
    public void calculateAge150() {
        Company c= new Company("ManyLabs");
        Client client = new Client(1234567890123451L,1234567890L,"09/05/1871","male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        int anosdif= client.calculateAge("09/05/1871");

        Assert.assertEquals(anosdif,150);

    }
    @Test(expected = IllegalArgumentException.class)
    public void calculateAge150plus() {
        Company c= new Company("ManyLabs");
        Client client = new Client(1234567890123451L,1234567890L,"09/05/1870","male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        int anosdif= client.calculateAge("09/05/1871");

        Assert.assertEquals(anosdif,151);

    }
    @Test
    public void calculateAge() {
        Company c= new Company("ManyLabs");
        Client client = new Client(1234567890123451L,1234567890L,"09/05/1871","male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        int anosdif= client.calculateAge("09/05/2000");

        Assert.assertEquals(anosdif,21);

    }

    @Test
    public void getEmail() {
        Client nc = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company c = new Company("Many Labs");
        Email email = nc.getEmail();

        Assert.assertEquals(String.valueOf(email), "asd@gmail.com");
    }

    @Test
    public void getName() {
        Client nc = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company c = new Company("Many Labs");
        String name = nc.getName();

        Assert.assertEquals(name, "Moirane");
    }
}