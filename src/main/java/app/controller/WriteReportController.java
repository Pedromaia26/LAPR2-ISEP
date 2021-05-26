package app.controller;

import app.domain.model.*;
import app.domain.model.dto.TestDTO;
import app.domain.model.dto.TestParameterDto;
import app.domain.model.mappers.TestMapper;
import app.domain.model.mappers.TestParameterMapper;
import app.domain.model.stores.TestStore;

import java.util.ArrayList;
import java.util.List;

public class WriteReportController {

    private TestStore tStore;

    private List<Test> lTests = new ArrayList<>();
    private List<TestDTO> lTestsDto = new ArrayList<>();
    private List<TestParameter> lResultParameters = new ArrayList<>();
    private List<TestParameterDto> lResultParameterDto = new ArrayList<>();
    private TestMapper testMapper;

    public List<TestDTO> getTests(){
        tStore = App.getInstance().getCompany().getTestStore();
        lTests = tStore.getTestsToBeReported();
        lTestsDto = testMapper.toDto(lTests);
        return lTestsDto;
    }

    public List<TestParameterDto> getResultParameters(TestDTO testDto) {
        tStore = App.getInstance().getCompany().getTestStore();
        String code = testDto.getCode();
        Test test = tStore.getTestByCode(code);
        lResultParameters = test.getTestParameter();
        lResultParameterDto = TestParameterMapper.toDto(lResultParameters);
        return lResultParameterDto;
    }

    public boolean addReport(String diagnosis){
        //do association with test
        return true;
    }
}
