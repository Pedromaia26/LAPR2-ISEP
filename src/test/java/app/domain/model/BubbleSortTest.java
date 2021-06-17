package app.domain.model;

import app.mappers.dto.ClientDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void orderClientsByTin() throws IllegalAccessException, ParseException, InstantiationException, IOException, OutputException, BarcodeException, ClassNotFoundException {
        Company company=new Company("Many Labs");

        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ClientDTO nc1 = new ClientDTO("1234567890123457",1234567891L,"12/12/2012","Male",9999999999L,"asde@gmail.com","Moira",44123456788L,"asdasda");

        List<ClientDTO> clientDTOList=new ArrayList<>();

        clientDTOList.add(nc);
        clientDTOList.add(nc1);

        company.getClientStore().setOrderingAlgorithm("Domain.OrderByTin");

        company.getClientStore().OrderingAlgorithm().orderClientsByTin(clientDTOList);

        List<ClientDTO> expected =new ArrayList<>();

        expected.add(nc);
        expected.add(nc1);

        assertEquals(expected,clientDTOList);



    }
    @Test
    public void orderClientsByTinFail() throws IllegalAccessException, ParseException, InstantiationException, IOException, OutputException, BarcodeException, ClassNotFoundException {
        Company company=new Company("Many Labs");

        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",9999999999L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ClientDTO nc1 = new ClientDTO("1234567890123457",1234567891L,"12/12/2012","Male",1234567890L,"asde@gmail.com","Moira",44123456788L,"asdasda");

        List<ClientDTO> clientDTOList=new ArrayList<>();

        clientDTOList.add(nc);
        clientDTOList.add(nc1);

        List<ClientDTO> copy=new ArrayList<>();

        for (ClientDTO clientDTO:clientDTOList){
            copy.add(clientDTO);
        }

        company.getClientStore().setOrderingAlgorithm("Domain.OrderByTin");

        company.getClientStore().OrderingAlgorithm().orderClientsByTin(copy);

        List<ClientDTO> expected =new ArrayList<>();

        expected.add(nc);
        expected.add(nc1);



        assertNotEquals(expected,copy);



    }


    @Test
    public void orderClientsByName() throws IllegalAccessException, ParseException, InstantiationException, IOException, OutputException, BarcodeException, ClassNotFoundException {

        Company company=new Company("Many Labs");

        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Ana",44123456789L,"asdasda");

        ClientDTO nc1 = new ClientDTO("1234567890123457",1234567891L,"12/12/2012","Male",9999999999L,"asde@gmail.com","Moira",44123456788L,"asdasda");

        List<ClientDTO> clientDTOList=new ArrayList<>();

        clientDTOList.add(nc);
        clientDTOList.add(nc1);

        company.getClientStore().setOrderingAlgorithm("Domain.OrderByTin");

        company.getClientStore().OrderingAlgorithm().orderClientsByName(clientDTOList);

        List<ClientDTO> expected =new ArrayList<>();

        expected.add(nc);
        expected.add(nc1);

        assertEquals(expected,clientDTOList);

    }

    @Test
    public void orderClientsByNameFail() throws IllegalAccessException, ParseException, InstantiationException, IOException, OutputException, BarcodeException, ClassNotFoundException {
        Company company=new Company("Many Labs");

        ClientDTO nc = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moira",44123456789L,"asdasda");

        ClientDTO nc1 = new ClientDTO("1234567890123457",1234567891L,"12/12/2012","Male",9999999999L,"asde@gmail.com","Ana",44123456788L,"asdasda");

        List<ClientDTO> clientDTOList=new ArrayList<>();

        clientDTOList.add(nc);
        clientDTOList.add(nc1);

        List<ClientDTO> copy=new ArrayList<>();

        for (ClientDTO clientDTO:clientDTOList){
            copy.add(clientDTO);
        }

        company.getClientStore().setOrderingAlgorithm("Domain.OrderByTin");

        company.getClientStore().OrderingAlgorithm().orderClientsByName(copy);

        List<ClientDTO> expected =new ArrayList<>();

        expected.add(nc);
        expected.add(nc1);



        assertNotEquals(expected,copy);



    }
}