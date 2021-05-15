package app.domain.model;

import app.controller.App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleStore {

    private List<Sample> sampleList = new ArrayList<>();


    public Sample RecordNewSample(SampleDTO dto) {
        return SampleMapper.toModel(dto);

    }

    public List<Sample> getSampleList() {
        return sampleList;
    }

    public boolean validateSample(Sample nc){
        if (nc == null)
            return false;
        return ! this.sampleList.contains(nc);
    }

    public boolean addNewSample(Sample nc){
        if (!validateSample(nc))
            return false;
        return this.sampleList.add(nc);
    }


    public boolean saveSample(Sample nc) {
        validateSample(nc);


        List<Test> testsss=App.getInstance().getCompany().getTestStore().getTests();

        for(Test loDTO : testsss){
            if(loDTO.getLabOrder()==nc.getLabOrder()) {
                loDTO.setSample(nc);

            }
        }



        return addNewSample(nc);
    }


}
