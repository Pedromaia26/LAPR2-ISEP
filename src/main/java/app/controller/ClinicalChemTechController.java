package app.controller;

import app.domain.model.*;
import app.mappers.ClientMapper;
import app.mappers.TestMapper;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.TestDTO;
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
    private List<Test> tValidList;
    private List<Client> clientList;

    public ClinicalChemTechController() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        this(App.getInstance().getCompany());
        this.cStore = company.getClientStore();
        this.testStore = company.getTestStore();
        this.tMapper = new TestMapper();
        this.tList = new ArrayList<>();
        this.clientMapper = new ClientMapper();
        this.tValidList = new ArrayList<>();
        this.clientList = new ArrayList<>();
    }


    public ClinicalChemTechController(Company company) {
        this.company = company;
        this.cStore = company.getClientStore();
        this.testStore = company.getTestStore();
        this.tMapper = new TestMapper();
        this.tList = new ArrayList<>();
        this.clientMapper = new ClientMapper();
        this.tValidList = new ArrayList<>();
        this.clientList = new ArrayList<>();
    }

    public List<ClientDTO> getClients(){
        try {
            List<Client> clientList = cStore.getClientList();
            for (Client client : clientList) {
                for (Test test : testStore.getTestsByClient(client)) {
                    if (test.getValidationDate() != null) {
                        if (!this.clientList.contains(client)) {
                            this.clientList.add(client);
                        }
                    }
                }
            }
            System.out.println(this.clientList);
            return clientMapper.toDto(this.clientList);
        }catch(ArrayIndexOutOfBoundsException e){
            return new ArrayList<ClientDTO>();
        }
    }

    public List<TestDTO> getTestsByClient(ClientDTO client){
        this.client = this.cStore.getClientByTinNumber(client.getTifDto());
        tList = testStore.getTestsByClient(this.client);
        for(Test t : tList){
            if(t.getValidationDate()!=null){
                tValidList.add(t);
            }
        }
        return tMapper.toDto(tValidList);
    }
}
