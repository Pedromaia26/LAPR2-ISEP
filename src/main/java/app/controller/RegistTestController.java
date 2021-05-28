package app.controller;

import app.domain.model.*;

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

    public RegistTestController() {
        this(App.getInstance().getCompany());
        this.testTypeMapper = new TestTypeMapper();
        this.testTypeStore = App.getInstance().getCompany().getTestTypeStore();
        this.clientStore = App.getInstance().getCompany().getClientStore();
        this.testStore = App.getInstance().getCompany().getTestStore();
        this.parameterMapper = new ParameterMapper();
    }

    public RegistTestController(Company company) {
        this.company = company;
        this.testTypeMapper = new TestTypeMapper();
        this.testTypeStore = App.getInstance().getCompany().getTestTypeStore();
        this.clientStore = App.getInstance().getCompany().getClientStore();
        this.testStore = App.getInstance().getCompany().getTestStore();
        this.parameterMapper = new ParameterMapper();
    }

    public boolean createTest(long tinNumber, long nhsCode, LabOrder labOrder) {
        for (Parameter pars: labOrder.getParameters()){
            par.add(this.company.getParameterStore().getParameterByCode(pars.getCode()));
        }
        this.tt = (this.company.getTestTypeStore().getTestTypeByCode(labOrder.getTestType().getCode()));
        this.ts = this.company.getTestStore().createTest(this.company, tinNumber, nhsCode, labOrder);
        return this.company.getTestStore().validateTest(ts);
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

    public boolean saveTest () {
        return this.company.getTestStore().saveTest(ts);
    }
}




