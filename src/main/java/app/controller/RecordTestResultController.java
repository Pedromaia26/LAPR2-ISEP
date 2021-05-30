package app.controller;

import app.domain.model.*;

import javax.naming.ldap.ExtendedRequest;
import java.util.ArrayList;
import java.util.List;

public class RecordTestResultController {

    private TestTypeStore testTypeStore; //temporary
    private TestStore tStore;
    private List<Test> listT = new ArrayList<>();
    private List<TestDTO> listTDto = new ArrayList<>();
    private TestMapper tMapper;
    private List <TestParameter> testParameterList = new ArrayList<>();
    private List <TestParameterDto> testParameterDto = new ArrayList<>();
    private Test test;
    private List<TestType> listTT = new ArrayList<>(); //temporary
    private ParameterCategoryStore pcs; //temporary
    private Company c;

    public RecordTestResultController(){
        this.c = App.getInstance().getCompany();
        tStore = App.getInstance().getCompany().getTestStore();
        testTypeStore = App.getInstance().getCompany().getTestTypeStore(); //temporary
        pcs = App.getInstance().getCompany().getParameterCategoryStore(); //temporary
        tMapper = new TestMapper();
    }

    public Test getTestByBarcode(String code){
        return tStore.getTestByBarcode(code);
    }

    public Test getTest(){
        return test;
    }

    public List<TestDTO> getTestListStore(){
        listT = tStore.getTests();
        listTDto = tMapper.toDto(listT);
        return listTDto;
    }


    public List<TestParameterDto> getTestParameters (TestDTO testDTO){
        String barcode = testDTO.getSample().get(0).getBarcode().getBarcodeNumber();
        test = tStore.getTestByBarcode(barcode);
        testParameterList = test.getTestParameter();
        testParameterDto = TestParameterMapper.toDto(testParameterList);
        return testParameterDto;
    }

    public void addTestResult(String barcode, String parameterCode, Double result, String metric) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        test.addTestResult(barcode, parameterCode, result, metric);
    }

    public TestTypeStore getTestTypeStore(){ //temporary
        return testTypeStore;
    }

    public ParameterCategoryStore getParameterCategoryStore(){ //temporary
        return pcs;
    }
}
