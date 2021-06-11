package app.controller;

import app.domain.model.*;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ClinicalChemTechController {

    private Company company;
    private ClientStore cStore;
    private ClientMapper clientMapper;
    private TestStore testStore;
    private TestMapper tMapper;
    private Client client;
    private List<Test> tList;

    public ClinicalChemTechController() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        this(App.getInstance().getCompany());
        this.cStore = company.getClientStore();
        this.testStore = company.getTestStore();
        this.tMapper = new TestMapper();
        this.tList = new ArrayList<>();
        this.clientMapper = new ClientMapper();
    }


    public ClinicalChemTechController(Company company) {
        this.company = company;
        this.cStore = company.getClientStore();
        this.testStore = company.getTestStore();
        this.tMapper = new TestMapper();
        this.tList = new ArrayList<>();
        this.clientMapper = new ClientMapper();
    }

    public List<ClientDTO> getClients(){
        List<Client> clientList = cStore.getClientList();
        return clientMapper.toDto(clientList);

    }

    public List<TestDTO> getTestsByClient(ClientDTO client){
        this.client = this.cStore.getClientByTinNumber(client.getTifDto());
        tList = testStore.getTestsByClient(this.client);
        return tMapper.toDto(tList);

    }
}
