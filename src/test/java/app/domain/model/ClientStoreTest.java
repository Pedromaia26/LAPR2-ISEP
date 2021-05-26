package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientStoreTest {

    @Test
    public void createNewClient() {
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        Company comp= new Company("ManyLabs");

        ClientDTO clientDTO = new ClientDTO(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        Client client1=comp.getClientStore().createNewClient(clientDTO);

        Assert.assertEquals(client,client1);

    }

    @Test
    public void validateClient() {
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Client client2 = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        Client client1= null;
        Company comp= new Company("ManyLabs");

        boolean test1= comp.getClientStore().validateClient(client);
        boolean test2= comp.getClientStore().validateClient(client1);
        comp.getClientStore().addNewClient(client);
        boolean test3= comp.getClientStore().validateClient(client);

        assertTrue(test1);
        assertFalse(test2);
        assertFalse(test3);

    }

    @Test
    public void addNewClient() {
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        Client client1= null;
        Client client2 = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        Company comp= new Company("ManyLabs");

        boolean test1= comp.getClientStore().addNewClient(client);
        boolean test2= comp.getClientStore().addNewClient(client1);
        boolean test3= comp.getClientStore().addNewClient(client);
        boolean test4 =comp.getClientStore().addNewClient(client2);

        assertTrue(test1);
        assertFalse(test2);
        assertFalse(test3);
        assertFalse(test4);

    }

}