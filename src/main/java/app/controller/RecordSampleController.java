package app.controller;

import app.domain.model.*;

import java.io.IOException;
import java.util.List;

public class RecordSampleController {
    private SampleStore sampleStore;

    private Company company;

    private Sample samp;

    private LabOrderMapper labOrderMapper;


    public RecordSampleController(){
        this(App.getInstance().getCompany());
        this.sampleStore=App.getInstance().getCompany().getSampleStore();
        this.labOrderMapper = new LabOrderMapper();

    }

    public RecordSampleController(Company company) {
        this.sampleStore=company.getSampleStore();
        this.company= company;
        this.labOrderMapper = new LabOrderMapper();

    }


    public boolean createNewSample(SampleDTO dto) {
        this.samp = sampleStore.RecordNewSample(dto);
        return this.sampleStore.validateSample(samp);
    }

    public boolean saveSample (){

        return this.company.getSampleStore().saveSample(samp);
    }

    public List<LabOrder> getLabOrder(){
        return this.company.getLabOrderStore().getLabOrders();
    }

    public List<LabOrderDTO> getLabOrderDto(){
        return this.labOrderMapper.toDto(getLabOrder());
    }
}
