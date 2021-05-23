package app.controller;

import app.domain.model.*;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.util.List;

public class RecordSampleController {
    private TestStore testStore;

    private Company company;

    private Sample samp;

    private TestMapper testMapper;

    private Test test;


    public RecordSampleController(){
        this(App.getInstance().getCompany());
        this.testStore=App.getInstance().getCompany().getTestStore();
        this.testMapper = new TestMapper();

    }

    public RecordSampleController(Company company) {
        this.testStore=company.getTestStore();
        this.company= company;
        this.testMapper = new TestMapper();

    }

    public Sample getSamp() {
        return samp;
    }

    public boolean createNewSample(SampleDTO dto) {
        this.test=testStore.getTestByCode(dto.getOrderid());
        this.samp = this.test.RecordNewSample();

       return this.test.validateSample(samp);

    }

    public boolean saveSample () throws BarcodeException, OutputException {

        //var=testStore.getTestByCode();
        //this.samp = var.RecordNewSample(dto);

        //criar e "guardar" sample na classe test

        return this.test.saveSample(samp);
    }

    public List<Test> getTest(){
        return this.company.getTestStore().getTests();
    }

    public List<TestDTO> getTestDto(){
        return this.testMapper.toDto(getTest());
    }
}
