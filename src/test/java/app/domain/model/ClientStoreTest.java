package app.domain.model;

import app.mappers.DTO.ClientDTO;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ClientStoreTest {

    @Test
    public void createNewClient() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Company comp= new Company("ManyLabs");

        ClientDTO clientDTO = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Client client1=comp.getClientStore().createNewClient(clientDTO);

        Assert.assertEquals(client,client1);

    }

    @Test
    public void validateClient() {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");


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
    public void validateClientSameTestAlreadyOnTheList() throws IOException {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company comp= new Company("ManyLabs");
        comp.getClientStore().addNewClient(client);

        boolean test3= comp.getClientStore().validateClient(client);
        assertFalse(test3);
    }

    @Test
    public void validateClientEqualTestAlreadyOnTheList() throws IOException {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company comp= new Company("ManyLabs");
        comp.getClientStore().addNewClient(client);
        Client client2 = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        boolean test4= comp.getClientStore().validateClient(client2);
        assertFalse(test4);
    }


    @Test
    public void addNewClient() throws IOException {
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Company comp= new Company("ManyLabs");

        boolean test1= comp.getClientStore().addNewClient(client);



        assertTrue(test1);




    }

    @Test
    public void addNewClientNull() throws IOException {
        Client client1= null;
        Company comp= new Company("ManyLabs");

        boolean test2= comp.getClientStore().addNewClient(client1);
        assertFalse(test2);


    }

    @Test
    public void addNewClientSameTestAlreadyOnTheList() throws IOException {

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company comp= new Company("ManyLabs");

        comp.getClientStore().addNewClient(client);
        boolean test3= comp.getClientStore().addNewClient(client);
        assertFalse(test3);


    }

    @Test
    public void addNewClientEqualTestAlreadyOnTheList() throws IOException {

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        Company comp= new Company("ManyLabs");

        Client client2 = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");


         comp.getClientStore().addNewClient(client);

        boolean test4 =comp.getClientStore().addNewClient(client2);

        assertFalse(test4);


    }

}