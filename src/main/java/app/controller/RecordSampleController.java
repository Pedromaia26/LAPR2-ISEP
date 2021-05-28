package app.controller;

import app.domain.model.*;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.util.List;
import java.util.Properties;

public class RecordSampleController {
    private TestStore testStore;

    private Company company;

    private Sample samp;

    private TestMapper testMapper;

    private Test test;

    private SampleMapper sampleMapper;




    public RecordSampleController(){
        this.company=App.getInstance().getCompany();
        this.testStore=App.getInstance().getCompany().getTestStore();
        this.testMapper = new TestMapper();
        this.sampleMapper= new SampleMapper();

    }

    public RecordSampleController(Company company) {
        this.testStore=company.getTestStore();
        this.company= company;
        this.testMapper = new TestMapper();
        this.sampleMapper= new SampleMapper();

    }

    public Sample getSamp() {
        return samp;
    }

    public boolean createNewSample(SampleDTO dto) throws BarcodeException, IllegalAccessException, InstantiationException, ClassNotFoundException, OutputException {
        this.test=sampleMapper.toModel(dto,testStore);
        this.samp = this.test.RecordNewSample(company);

       return this.test.validateSample(samp,company );

    }

    public boolean saveSample () throws BarcodeException, OutputException {

        //var=testStore.getTestByCode();
        //this.samp = var.RecordNewSample(dto);

        //criar e "guardar" sample na classe test

        return this.test.saveSample(samp, company);
    }





    public List<Test> getTest(){
        return this.company.getTestStore().getTests();
    }

    public List<TestDTO> getTestDto(){
        return this.testMapper.toDto(getTest());
    }
}
