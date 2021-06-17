package app.controller;

import app.domain.model.*;
import app.mappers.TestMapper;
import app.mappers.TestParameterMapper;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestParameterDto;
import auth.AuthFacade;
import auth.domain.model.Email;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RecordTestResultController {

    private TestStore tStore;
    private List<Test> listT = new ArrayList<>();
    private List<TestDTO> listTDto = new ArrayList<>();
    private TestMapper tMapper;
    private TestParameterMapper tpMapper;
    private List <TestParameter> testParameterList = new ArrayList<>();
    private List <TestParameterDto> testParameterDto = new ArrayList<>();
    private Test test;
    private Company c;
    private AuthFacade authFacade;
    private Laboratory lab;



    public RecordTestResultController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.c = App.getInstance().getCompany();
        tStore = App.getInstance().getCompany().getTestStore();
        tMapper = new TestMapper();
        tpMapper = new TestParameterMapper();
        this.authFacade= c.getAuthFacade();
    }

    public Test getTestByBarcode(String code){
        this.test = tStore.getTestByBarcode(code);
        return tStore.getTestByBarcode(code);

    }

    public List <TestParameterDto> getTestParameters(String barcode){
        test = tStore.getTestByBarcode(barcode);
        testParameterList = test.getTestParameter();
        testParameterDto = tpMapper.toDto(testParameterList);
        return testParameterDto;
    }

    public List<TestDTO> getTestListStore(){
        listT = tStore.getTests();
        listTDto = tMapper.toDto(listT);
        return listTDto;
    }

    public boolean checkLab(TestDTO test){

        Email empemail= authFacade.getCurrentUserSession().getUserId();

        this.lab=c.getEmployeeStore().getEmpByEmail(String.valueOf(empemail));

        if(test.getLaboratoryDTO().getLaboratoryID().equals(lab.getLaboratoryID())){
            return true;
        }
        throw new ArrayIndexOutOfBoundsException("There are no tests to be validated.");

    }

    public Test getTest(){
        return this.test;
    }

    public void addTestParameterResult(String barcode, String parameterCode, Double result, String metric) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, OutputException, ParseException, BarcodeException {
        test.addTestParameterResult(barcode, parameterCode, result, metric);
    }


    public boolean saveTestParameterResult(String testParameterResult) {
        boolean flag = test.saveTestParameterResult(testParameterResult);
        tStore.save();
        return flag;
    }
}
