package app.domain.model;

import app.controller.App;

import java.util.ArrayList;
import java.util.List;

public class TestStore {
    private List<Test> tests= new ArrayList<>();

    public List<Test> getTests() {
        return tests;
    }

    public void addToList (Test test){
        tests.add(test);
    }

    public boolean validateSample(Sample nc){
        if (nc == null)
            return false;
        for(Test testss : tests){
            for (Sample samples : testss.getSample()) {
                if (samples.equals(nc)) {
                    return false;

                }
            }
        }
        return true;
    }

    public boolean saveSample(Sample nc) {
        if (!validateSample(nc))
            return false;

        for(Test testss : tests){
            if(testss.getLabOrder()==nc.getLabOrder()) {
                testss.getSample().add(nc);
                return true;
            }
        }

        return false;
    }

    public Sample RecordNewSample(SampleDTO dto) {
        return SampleMapper.toModel(dto);

    }
}
