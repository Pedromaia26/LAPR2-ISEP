package app.domain.model;

import app.mappers.dto.ClientDTO;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void changeName() {

        Company company= new Company("ManyLabs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuio",44123456789L,"asdasda");

        String name="asd";

        company.getClientStore().ChangeName(client,name);

        assertEquals("asd",client.getName());


    }


    @Test
    public void changePN() {

        Company company= new Company("ManyLabs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456891L,"asdasda");

        long name=44123456894L;

        company.getClientStore().ChangePN(client,name);

        assertEquals(44123456894L,client.getPhoneNumber());


    }

    @Test
    public void changeAddress() {
        Company company= new Company("ManyLabs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuio",44123456789L,"asdasda");

        String name="asd";

        company.getClientStore().ChangeAddress(client,name);

        assertEquals("asd",client.getAddress());
    }


    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckNamemore35Rules() {
        Company company= new Company("ManyLabs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuio",44123456789L,"asdasda");

        String name="qwertyuiopasdfghjklçzxcvbnmqwertyuia";

        company.getClientStore().ChangeName(client,name);

    }
    @Test
    public void ClientCheckNameequals35Rules() {
        Company company= new Company("ManyLabs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuio",44123456789L,"asdasda");

        String name="qwertyuiopasdfghjklçzxcvbnmqwertyui";

        company.getClientStore().ChangeName(client,name);

        assertEquals("qwertyuiopasdfghjklçzxcvbnmqwertyui",client.getName());

    }
    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckSexRules() {
        Company company= new Company("ManyLabs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuio",44123456789L,"asdasda");

        String name="m";

        company.getClientStore().ChangeSex(client,name);

    }
    @Test
    public void ClientChangeSex1() {
        Company company= new Company("ManyLabs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuio",44123456789L,"asdasda");

        String name="Male";

        company.getClientStore().ChangeSex(client,name);

        assertEquals("Male",client.getSex());

    }
    @Test
    public void ClientChangeSex2() {
        Company company= new Company("ManyLabs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuio",44123456789L,"asdasda");

        String name="Female";

        company.getClientStore().ChangeSex(client,name);
        assertEquals("Female",client.getSex());

    }
    @Test
    public void ClientChangeSex3() {
        Company company= new Company("ManyLabs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","qwertyuio",44123456789L,"asdasda");

        String name="UNDIFINED";

        company.getClientStore().ChangeSex(client,name);

        assertEquals("UNDIFINED",client.getSex());

    }

    @Test(expected = IllegalArgumentException.class)
    public void ClientCheckPhoneNumberRules() {
        Company company= new Company("ManyLabs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456891L,"asdasda");

        long name=4412345689L;

        company.getClientStore().ChangePN(client,name);



    }




    @Test
    public void getClientList() throws IOException {
        Company company= new Company("ManyLabs");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456891L,"asdasda");

        company.getClientStore().addToList(client);


        List<Client> clientList=company.getClientStore().getClientList();

        List<Client> clientList1= new ArrayList<>();

        clientList1.add(client);

        assertEquals(clientList1,clientList);


    }

    @Test
    public void getClientByTinNumber() {

        Company company= new Company("ManyLabs");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456891L,"asdasda");

        company.getClientStore().addToList(client);

        Client client1=company.getClientStore().getClientByTinNumber(1234567890L);

        assertEquals(client,client1);

    }

    @Test
    public void getClientByEmail() {

        Company company= new Company("ManyLabs");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456891L,"asdasda");

        company.getClientStore().addToList(client);

        Client client1=company.getClientStore().getClientByEmail("asd@gmail.com");

        assertEquals(client,client1);

    }

    @Test
    public void getClientByCcn() {
        Company company= new Company("ManyLabs");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456891L,"asdasda");

        company.getClientStore().addToList(client);

        boolean b=company.getClientStore().getClientByCcn("1234567890123456");


        assertTrue(b);

    }

    @Test
    public void getClientByCcnFalse() {
        Company company= new Company("ManyLabs");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456891L,"asdasda");

        company.getClientStore().addToList(client);

        boolean b=company.getClientStore().getClientByCcn("1234567890123452");


        assertFalse(b);

    }


}