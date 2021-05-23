package app.domain.model;

import com.example3.CovidReferenceValues1API;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test {

    private String code;
    private long nhsCode;
    private LabOrder labOrder;
    private List<TestParameter> testParameterList;
    private ExternalModule em;

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

    public ExternalModule getExternalModule (){
        return em;
    }

    public void addTestResult (String parameterCode, String result, String metric){
        TestParameter tp = getTestParameterFor(parameterCode);
        ReferenceValue refValue = em.getReferenceValue(tp.getParameter());
        tp.addResult(result, metric, refValue);
    }
}