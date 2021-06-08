package app.controller;

import app.domain.model.*;
import auth.AuthFacade;
import auth.UserSession;
import auth.domain.model.Email;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
<<<<<<< HEAD
import java.text.ParseException;
=======
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
import java.util.ArrayList;
import java.util.List;

public class CheckTestResultsController {

    private Company company;

    private ClientStore clientStore;

    private AuthFacade authFacade;

    private UserSession us;

    private Email id;

    private TestStore tStore;

    private TestMapper tMapper;

    private ReportMapper rMapper;

    private TestParameterMapper tpMapper;

    private ParameterMapper pMapper;

    private TestParameterResultMapper tprMapper;

    private List<Test> listClientTests;

    private List<Test> listTests;

    private List<TestDTO> clientTests;

    private List<TestParameter> listTestParameter;

    private List<TestParameterDto> listTestParameterDto;

    private Parameter parameter;

    private TestParameterResult tpResult;

<<<<<<< HEAD
    public CheckTestResultsController() throws IllegalAccessException, ParseException, InstantiationException, OutputException, IOException, BarcodeException, ClassNotFoundException {
=======
    public CheckTestResultsController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
        company = App.getInstance().getCompany();
        clientStore = company.getClientStore();
        authFacade = company.getAuthFacade();
        tMapper = new TestMapper();
        rMapper = new ReportMapper();
        pMapper = new ParameterMapper();
        tprMapper = new TestParameterResultMapper();
    }

    public String getUserName(){

        return clientStore.getClientByEmail(authFacade.getCurrentUserSession().getUserId().toString()).getName();
    }

    public List<TestDTO> getTests(){
        us = authFacade.getCurrentUserSession();
        id = us.getUserId();
        tStore = company.getTestStore();
        listTests = tStore.getTestsByClient(id);
        for (Test test : listTests){
            if (test.getReport() != null){
                listClientTests.add(test);
            }
        }
        clientTests = tMapper.toDto(listClientTests);
        return clientTests;
    }

    public ReportDTO getTestReport(String code) {
        tStore = company.getTestStore();
        Test test = tStore.getTestByCode(code);
        Report report = test.getReport();
        ReportDTO reportDto = rMapper.toDTO(report);
        return reportDto;
    }

    public List<TestParameterDto> getTestParameter(String code){
        tStore = company.getTestStore();
        Test test = tStore.getTestByCode(code);
        listTestParameter = test.getTestParameter();
        listTestParameterDto = tpMapper.toDto(listTestParameter);
        return listTestParameterDto;
    }

    public ParameterDTO getParameter(TestParameterDto testParameterDto){
        List<Parameter> listParameter = new ArrayList<>();
        List<ParameterDTO> listParameterDto = new ArrayList<>();
        parameter = testParameterDto.getParameterdto();
        listParameter.add(parameter);
        listParameterDto = pMapper.toDto(listParameter);
        return listParameterDto.get(0);
    }

    public TestParameterResultDTO getResults(TestParameterDto testParameterDto) {
        List<TestParameterResult> listResult = new ArrayList<>();
        List<TestParameterResultDTO> listResultDto;
        tpResult = testParameterDto.getTprdto();
        listResult.add(tpResult);
        listResultDto = tprMapper.toDto(listResult);
        return listResultDto.get(0);
    }
}
