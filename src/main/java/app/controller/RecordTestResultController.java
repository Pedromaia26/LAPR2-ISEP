package app.controller;

import app.domain.model.*;

import javax.naming.ldap.ExtendedRequest;
import java.util.ArrayList;
import java.util.List;

public class RecordTestResultController {

    private TestStore tStore;
    private List<Test> listT = new ArrayList<>();
    private List<TestDTO> listTDto = new ArrayList<>();
    private TestMapper tMapper;
    private List <TestParameter> testParameterList = new ArrayList<>();
    private List <TestParameterDto> testParameterDto = new ArrayList<>();
    private Test test;
    private Company c;

    public RecordTestResultController(){
        this.c = App.getInstance().getCompany();
        tStore = App.getInstance().getCompany().getTestStore();
        tMapper = new TestMapper();
    }

    public Test getTestByBarcode(String code){
        this.test = tStore.getTestByBarcode(code);
        return tStore.getTestByBarcode(code);

    }

    public List<TestDTO> getTestListStore(){
        listT = tStore.getTests();
        listTDto = tMapper.toDto(listT);
        return listTDto;
    }

    public Test getTest(){
        return this.test;
    }

    public void addTestResult(String barcode, String parameterCode, Double result, String metric) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        test.addTestResult(barcode, parameterCode, result, metric);
    }


    public boolean saveTestResult(String testParameterResult) {
        return test.saveTestParameterResult(testParameterResult);
    }
}
