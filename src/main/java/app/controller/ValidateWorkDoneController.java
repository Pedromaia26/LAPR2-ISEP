package app.controller;

import app.domain.model.*;
import app.mappers.TestMapper;
import app.mappers.dto.TestDtoDate;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ValidateWorkDoneController {

    private Company company;
    private List<Test> testsList;
    private List<Test> testsReadyToValidate;
    private List<TestDtoDate> testsDtoDateList;
    private TestMapper testMapper;

    public ValidateWorkDoneController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this(App.getInstance().getCompany());
        this.testsList = new ArrayList<>();
        this.testsReadyToValidate = new ArrayList<>();
        this.testsDtoDateList = new ArrayList<>();
        this.testMapper = new TestMapper();
    }

    public ValidateWorkDoneController(Company company){
        this.company = company;
        this.testsList = new ArrayList<>();
        this.testsReadyToValidate = new ArrayList<>();
        this.testsDtoDateList = new ArrayList<>();
        this.testMapper = new TestMapper();
    }

    public List<TestDtoDate> getTests(){
        testsList = company.getTestStore().getTests();
        for(Test test : testsList){

            if((test.getReport()!= null) && (test.getValidationDate() == null)){
                testsReadyToValidate.add(test);
            }
        }
        if(testsReadyToValidate.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("There are no tests to be validated.");
        }else {
            testsDtoDateList = testMapper.toDtoDate(testsReadyToValidate);
            return testsDtoDateList;
        }
    }

    public void validateTests(List<String> codes) throws IOException {
        for (String code: codes){
            company.getTestStore().validateWorkDone(code);
        }
    }
}
