package app.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test {

    private String code;
    private long nhsCode;
    private LabOrder labOrder;

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

    public Parameter getTestParameterFor(String parameterCode){
        for (Parameter testParam: labOrder.getParameters()) {
            if (parameterCode.equals(testParam.getCode()))
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

    public String toString() {
        return "Test:" + labOrder + ", sample=" + sample;
    }

}