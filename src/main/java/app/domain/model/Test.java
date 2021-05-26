package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test {

    private String code;
    private long nhsCode;
    private LabOrder labOrder;
    private ExternalModule em;
    private List<TestParameter> testParameterList;

    /**
     * List containing the samples.
     */
    private List<Sample> sample = new ArrayList<>();

    public Test(String code, long nhsCode, LabOrder labOrder){

        if (code.trim().length() != 10)
            throw new IllegalArgumentException("Code should have 10 digits");
        this.code = code;

        if (String.valueOf(nhsCode).length() != 10)
            throw new IllegalArgumentException("National Health Service Code should have 10 digits");

        this.nhsCode = nhsCode;

        this.labOrder = labOrder;

    }

    /**
     * Returns the code of a test.
     * @return the code of a test .
     */

    public String getCode() {
        return code;
    }

    /**
     * Returns the National Health Service code of a test.
     * @return the National Health Service code of a test.
     */

    public long getNhsCode() {
        return nhsCode;
    }


    /**
     * Returns the lab order of a test.
     * @return the lab order.
     */

    public LabOrder getLabOrder() {
        return labOrder;
    }

    /**
     * Returns the list of existing samples.
     * @return list of samples.
     */

    public List<Sample> getSample() {
        return sample;
    }

    /**
     * Returns the list of parameters of a test.
     * @return list of parameters of a test.
     */

    public List<TestParameter> getTestParameter(){ return testParameterList; }

    /**
     * Returns the test parameter from a test.
     * @param parameterCode receives a parameter code by parameter and proceeds to check if this code exists.
     * @return the test parameter intended if the code exists. If not, informs the user that the code does not exist.
     */

    public TestParameter getTestParameterFor(String parameterCode){
        for (TestParameter testParam: testParameterList) {
            if (parameterCode.equals(testParam.getParameter().getCode()))
                return testParam;
        }
        throw new IllegalArgumentException ("There is no parameter with such code");
    }


    /**
     * Returns the textual description of a test.
     * @return characteristics of a test.
     */


    @Override

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(code, test.code) && Objects.equals(nhsCode, test.nhsCode) && Objects.equals(labOrder, test.labOrder);
    }

    /**
     * Returns the textual description of a test.
     * @return characteristics of a test.
     */

    public String toString() {
        return "Test:" + labOrder + ", sample=" + sample;
    }

    /**
     * Validates the sample received.
     * @param samp the sample to be validated.
     * @return True if the sample is successfully validated, false if it is not.
     */
    public boolean validateSample(Sample samp, Company company){
        if (samp == null)
            return false;

        List<Test> tests= company.getTestStore().getTests();
        for(Test testss : tests){
            for (Sample samples : testss.getSample()) {
                if (samples.getBarcode().equals(samp.getBarcode())) {
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
    public boolean saveSample(Sample samp, Company company) throws BarcodeException, OutputException {
        if (!validateSample(samp,company))
            return false;

        samp.imageIoWrite(samp.makeUPCABarcode(samp.getBarcode()), samp.getBarcode());
        return addSample(samp);
    }

    public boolean addSample(Sample samp){

        return this.sample.add(samp);

    }

    /**
     * Create a new sample with the dto received.
     * @return The Sample created.
     */
    public Sample RecordNewSample(Company c) {
        return new Sample(c);
    }

    public ExternalModule getExternalModule (){
        return em;
    }


    public void addTestResult (String parameterCode, String result, String metric){
        TestParameter tp = getTestParameterFor(parameterCode);
        ReferenceValue refValue = em.getReferenceValue(tp.getParameter());
        tp.addResult(result, metric, refValue);
    }
}

