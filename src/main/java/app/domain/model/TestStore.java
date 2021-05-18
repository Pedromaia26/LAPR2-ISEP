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

    /**
     * Returns the test whose result the technician wishes to record in the software.
     * @param barcode the barcode received by parameter, in order to receive the respective test.
     * @return test selected by its sample's barcode.
     */

    public Test getTestByBarcode(String barcode){
        for (Test test: tests) {
            for (Sample samples : test.getSample()) {
                if (barcode.equals(samples.getBarcode()))
                    return test;
            }
        }
        throw new IllegalArgumentException("There is no Sample with such barcode!");
    }
}
