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
    private List <TestParameterDto> testResultParameterDto = new ArrayList<>();
    private Test t;


    public List<TestDTO> getTestListStore(){
        tStore = App.getInstance().getCompany().getTestStore();
        listT = tStore.getTests();
        listTDto = tMapper.toDto(listT);
        return listTDto;
    }

    /* public List<TestParameterDto> getTestParameters (TestDTO testDTO){
        String code = testDTO.getSample();
        t = tStore.getTestByBarcode(code);
        testParameterList = t.getTestParameter();
        testResultParameterDto = TestParameterMapper.toDto(testParameterList);
        return testResultParameterDto;
    } */

    public void addTestResult(String parameterCode, Double result){
        t.addTestResult(parameterCode, result);
    }

    
}
