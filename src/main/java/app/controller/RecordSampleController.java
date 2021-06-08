package app.controller;

import app.domain.model.*;
import auth.AuthFacade;
import auth.domain.model.Email;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class RecordSampleController {
    private TestStore testStore;

    private Company company;

    private Sample samp;

    private TestMapper testMapper;

    private Test test;

    private SampleMapper sampleMapper;
    private AuthFacade authFacade;
    private Laboratory lab;



    public RecordSampleController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this.company=App.getInstance().getCompany();
        this.testStore=App.getInstance().getCompany().getTestStore();
        this.testMapper = new TestMapper();
        this.sampleMapper= new SampleMapper();
        this.authFacade= company.getAuthFacade();

    }

    public RecordSampleController(Company company) {
        this.testStore=company.getTestStore();
        this.company= company;
        this.testMapper = new TestMapper();
        this.sampleMapper= new SampleMapper();
        this.authFacade= company.getAuthFacade();

    }

    public Sample getSamp() {
        return samp;
    }

    public boolean createNewSample(SampleDTO dto) throws BarcodeException, IllegalAccessException, InstantiationException, ClassNotFoundException, OutputException, IOException, ParseException {
        this.test=sampleMapper.toModel(dto,testStore);
        this.samp = this.test.RecordNewSample(company);

       return this.test.validateSample(samp,company );

    }

    public boolean saveSample () throws BarcodeException, OutputException, ParseException {

        //var=testStore.getTestByCode();
        //this.samp = var.RecordNewSample(dto);

        //criar e "guardar" sample na classe test

        boolean flag = this.test.saveSample(samp, company, new Date().toString());
        testStore.save();
        return flag;
    }


    public boolean checkLab(TestDTO test){

        Email empemail= authFacade.getCurrentUserSession().getUserId();

        this.lab=company.getEmployeeStore().getEmpByEmail(String.valueOf(empemail));

        if(test.getLaboratoryDTO().getLaboratoryID().equals(lab.getLaboratoryID())){
            return true;
        }
        throw new ArrayIndexOutOfBoundsException("There are no tests to be validated.");

    }


    public List<Test> getTest(){
        return this.company.getTestStore().getTests();
    }

    public List<TestDTO> getTestDto(){
        return this.testMapper.toDto(getTest());
    }
}
