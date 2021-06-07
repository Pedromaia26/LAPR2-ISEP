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
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        Company comp= new Company("ManyLabs");

        ClientDTO clientDTO = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        Client client1=comp.getClientStore().createNewClient(clientDTO);

        Assert.assertEquals(client,client1);

    }

    @Test
    public void validateClient() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);


        Company comp= new Company("ManyLabs");

        boolean test1= comp.getClientStore().validateClient(client);

        assertTrue(test1);




    }
    @Test
    public void validateClientNull() {
        Client client1= null;
        Company comp= new Company("ManyLabs");

        boolean test2= comp.getClientStore().validateClient(client1);
        assertFalse(test2);
    }

    @Test
    public void validateClientSameTestAlreadyOnTheList() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company comp= new Company("ManyLabs");
        comp.getClientStore().addNewClient(client);

        boolean test3= comp.getClientStore().validateClient(client);
        assertFalse(test3);
    }

    @Test
    public void validateClientEqualTestAlreadyOnTheList() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company comp= new Company("ManyLabs");
        comp.getClientStore().addNewClient(client);
        Client client2 = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        boolean test4= comp.getClientStore().validateClient(client2);
        assertFalse(test4);
    }


    @Test
    public void addNewClient() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        Company comp= new Company("ManyLabs");

        boolean test1= comp.getClientStore().addNewClient(client);



        assertTrue(test1);




    }

    @Test
    public void addNewClientNull() {
        Client client1= null;
        Company comp= new Company("ManyLabs");

        boolean test2= comp.getClientStore().addNewClient(client1);
        assertFalse(test2);


    }

    @Test
    public void addNewClientSameTestAlreadyOnTheList() {

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company comp= new Company("ManyLabs");

        comp.getClientStore().addNewClient(client);
        boolean test3= comp.getClientStore().addNewClient(client);
        assertFalse(test3);


    }

    @Test
    public void addNewClientEqualTestAlreadyOnTheList() {

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        Company comp= new Company("ManyLabs");

        Client client2 = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);


         comp.getClientStore().addNewClient(client);

        boolean test4 =comp.getClientStore().addNewClient(client2);

        assertFalse(test4);


    }

}