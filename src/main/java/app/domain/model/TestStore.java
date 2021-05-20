package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

    /**
     * List that contains the tests.
     */
    private List<Test> tests;

    public TestStore(){
        tests = new ArrayList<>();
    }
    /**
     * Returns the list of existing tests.
     * @return list of tests.
     */
    public List<Test> getTests() {
        return tests;
    }

    /**
     * Adding a test to the tests list.
     * @param test receives by parameter the test to be added to the list.
     */
    public void addToList (Test test){
        tests.add(test);
    }
    /**
     * Validates the sample received.
     * @param samp the sample to be validated.
     * @return True if the sample is successfully validated, false if it is not.
     */
    public boolean validateSample(Sample samp){
        if (samp == null)
            return false;
        for(Test testss : tests){
            for (Sample samples : testss.getSample()) {
                if (samples.getBarcode()==samp.getBarcode()) {
                    return false;

                }
            }
        }
        return true;
    }
    /**
     * Saves the sample received in the test.
     * @param samp the sample to be saved.
     * @return True if the sample is successfully saved, false if it is not.
     */
    public boolean saveSample(Sample samp) {
        if (!validateSample(samp))
            return false;


        return addSample(samp);
    }

    public boolean addSample(Sample samp){
        for(Test testss : tests){
            if(testss.getLabOrder()==samp.getLabOrder()) {
                testss.getSample().add(samp);
                return true;
            }
        }
        return false;
    }




    /**
     * Create a new sample with the dto received.
     * @param dto The SampleDTO
     * @return The Sample created.
     */
    public Sample RecordNewSample(SampleDTO dto) throws OutputException, BarcodeException {
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
