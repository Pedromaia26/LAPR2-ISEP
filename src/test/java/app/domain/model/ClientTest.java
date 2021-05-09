package app.domain.model;

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

        Assert.assertEquals(client,client1);
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

}