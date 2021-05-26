package app.controller;

import app.domain.model.*;
import app.domain.model.TestParameterDto;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WriteReportController {

    private TestStore tStore;

    private List<Test> lTests = new ArrayList<>();
    private List<TestDTO> lTestsDto = new ArrayList<>();
    private List<TestParameter> lResultParameters = new ArrayList<>();
    private List<TestParameterDto> lResultParameterDto = new ArrayList<>();
    private TestMapper testMapper;

    public WriteReportController() {
        this.tStore = App.getInstance().getCompany().getTestStore();
    }

    public List<TestDTO> getTests(){
        lTests = tStore.getTestsToBeReported();
        lTestsDto = testMapper.toDto(lTests);
        return lTestsDto;
    }

    public List<TestParameterDto> getResultParameters(TestDTO testDto) {
        String code = testDto.getCode();
        Test test = tStore.getTestByCode(code);
        lResultParameters = test.getTestParameter();
        lResultParameterDto = TestParameterMapper.toDto(lResultParameters);
        return lResultParameterDto;
    }

    public void addReport(String diagnosis, TestDTO testDto) {
        tStore.getTestByCode(testDto.getCode()).addReport(new Report(diagnosis));
    }
}
