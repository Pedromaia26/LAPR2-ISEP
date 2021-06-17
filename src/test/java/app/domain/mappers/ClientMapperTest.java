package app.domain.mappers;

import app.domain.model.Client;
import app.domain.model.Company;
import app.mappers.ClientMapper;
import app.mappers.dto.ClientDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientMapperTest {

    @Test
    public void toModel() {

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Company comp= new Company("Many Labs");

        ClientDTO clientDTO1 = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Client client1=comp.getClientStore().createNewClient(clientDTO1);

        assertEquals(client, client1);

    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void toDtoWithEmptyList() {

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        Company comp= new Company("Many Labs");

        ClientDTO clientDTO1 = new ClientDTO("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        List<Client> clientList = new ArrayList<>();

        ClientMapper clientMapper = new ClientMapper();

        List <ClientDTO> clientDTOList = clientMapper.toDto(clientList);

    }
}