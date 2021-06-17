package app.controller;

import app.domain.model.*;
import app.mappers.ClientMapper;
import app.mappers.ParameterMapper;
import app.mappers.TestMapper;
import app.mappers.TestTypeMapper;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.ParameterDTO;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestTypeDTO;
import auth.AuthFacade;
import auth.domain.model.Email;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RegistTestController {
    private Company company;
    private Client client;
    private ClientStore clientStore;
    private TestStore testStore;
    private Test ts;
    private TestType tt;
    private TestTypeStore testTypeStore;
    private List<Parameter> par = new ArrayList<>();
    private ParameterCategory cat;
    private TestTypeMapper testTypeMapper;
    private ParameterMapper parameterMapper;
    private ParameterStore parameterStore;
    private ClientMapper clientMapper;
    private TestMapper testMapper;
    private AuthFacade authFacade;
    private Laboratory lab;

    public RegistTestController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this(App.getInstance().getCompany());
        this.testTypeMapper = new TestTypeMapper();
        this.testTypeStore = App.getInstance().getCompany().getTestTypeStore();
        this.clientStore = App.getInstance().getCompany().getClientStore();
        this.testStore = App.getInstance().getCompany().getTestStore();
        this.parameterMapper = new ParameterMapper();
        this.clientMapper = new ClientMapper();
        this.testMapper = new TestMapper();
        this.authFacade= company.getAuthFacade();

    }

    public RegistTestController(Company company) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.company = company;
        this.testTypeMapper = new TestTypeMapper();
        this.testTypeStore = App.getInstance().getCompany().getTestTypeStore();
        this.clientStore = App.getInstance().getCompany().getClientStore();
        this.testStore = App.getInstance().getCompany().getTestStore();
        this.parameterMapper = new ParameterMapper();
        this.clientMapper = new ClientMapper();
        this.testMapper = new TestMapper();
        this.authFacade= company.getAuthFacade();

    }

    public boolean createTest(long tinNumber, String nhsCode, LabOrder labOrder) {

        this.client=clientStore.getClientByTinNumber(tinNumber);

        this.ts = this.company.getTestStore().createTest(this.company, this.client, nhsCode, labOrder, lab);
        return this.company.getTestStore().validateTest(ts);
    }

    public void checkLab(){

        Email empemail= authFacade.getCurrentUserSession().getUserId();

        this.lab=company.getEmployeeStore().getEmpByEmail(String.valueOf(empemail));



    }

    public TestType getTestTypeByCode(String testType){
        TestType tt = this.company.getTestTypeStore().getTestTypeByCode(testType);
        return tt;
    }

    public List<Parameter> getParameterByCode(List<String> codes){
        List<Parameter> par = new ArrayList<>();
        for (String pars: codes){
            par.add(this.company.getParameterStore().getParameterByCode(pars));
        }
        return par;
    }

    public List<TestType> getTestType(){
        return this.company.getTestTypeStore().getTestTypes();
    }

    public List<TestTypeDTO> getTestTypeDto(){
        return this.testTypeMapper.toDto(getTestType());
    }

    public List<Parameter> getParameter(){
        return this.company.getParameterStore().getParameterList();
    }

    public List<ParameterDTO> getParameterDto(){
        return this.parameterMapper.toDto(getParameter());
    }

    public List<Client> getClient(){
        return this.company.getClientStore().getClientList();
    }

    public List<ClientDTO> getClientDto(){
        return this.clientMapper.toDto(getClient());
    }

    public boolean saveTest () {
        return this.company.getTestStore().saveTest(ts);
    }

    public List<Test> getTests(){
        return testStore.getTests();
    }
    public List<TestDTO> getTestDto(){
        return this.testMapper.toDto(getTests());
    }
}




