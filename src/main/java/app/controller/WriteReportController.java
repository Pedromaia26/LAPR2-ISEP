package app.controller;

import app.domain.model.*;
import app.domain.model.TestParameterDto;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WriteReportController {

    private TestStore tStore;

    private List<Test> lTests = new ArrayList<>();
    private List<Test> lTestsToBeReported = new ArrayList<>();
    private List<TestDTO> lTestsDto = new ArrayList<>();
    private List<TestParameter> lResultParameters = new ArrayList<>();
    private List<TestParameterDto> lResultParameterDto = new ArrayList<>();
    private Test test;
    private TestMapper testMapper = new TestMapper();
    private TestParameterMapper testParameterMapper= new TestParameterMapper();

    public WriteReportController() {
        this.tStore = App.getInstance().getCompany().getTestStore();
        testMapper = new TestMapper();
        lTests = tStore.getTests();
    }

    public List<TestDTO> getTests(){
        for(Test test : lTests){
            for (TestParameter testparameter : test.getTestParameter()){
                if(testparameter.getTpr() != (null) && !lTestsToBeReported.contains(test) && test.getReport() == null){

                    lTestsToBeReported.add(test);
                }
            }
        }
        lTestsDto = testMapper.toDto(lTestsToBeReported);
        return lTestsDto;
    }

    public boolean removeTestToBeReported(){
        boolean flag = lTestsToBeReported.remove(test);
        tStore.save();
        return flag;
    }

    public List<TestParameterDto> getResultParameters(TestDTO testDto) {
        String code = testDto.getCode();
        test = tStore.getTestByCode(code);
        lResultParameters = test.getTestParameter();
        lResultParameterDto = testParameterMapper.toDto(lResultParameters);
        return lResultParameterDto;
    }

    public List<Test> getTest(){
        return lTests;
    }

    public void addReport(String diagnosisText) {
        test.addReport(diagnosisText);

    }


}
