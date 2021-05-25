package app.controller;

import app.domain.model.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WriteReportController {

    private TestStore tStore;

    private List<Test> lTests = new ArrayList<>();
    private List<TestDTO> lTestsDto = new ArrayList<>();
    private List<TestParameterResult> lResultParameters = new ArrayList<>();
    //private List<TestParameterResultDTO> lResultParameterDto = new ArrayList<>();
    private TestMapper testMapper;

    public List<TestDTO> getTests(){
        tStore = App.getInstance().getCompany().getTestStore();
        lTests = tStore.getTestsToBeReported();
        lTestsDto = testMapper.toDto(lTests);
        return lTestsDto;
    }

    public void getResultParameters(TestDTO testDto) {
        tStore = App.getInstance().getCompany().getTestStore();
        String code = testDto.getCode();
        Test test = tStore.getTestByCode(code);
        //lResultParameters = test.getResultParameters();
        //lResultParameterDto = TestParameterResultMapper.toDto(lResultParameter);
    }
}
