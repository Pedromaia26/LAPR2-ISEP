package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

    /**
     *
     */
    private LabOrder labOrder;

    /**
     * List containing the samples.
     */
    private List<Sample> sample = new ArrayList<>();

    public Test(){

    }

    /**
     * Constructs an instance of Test, receiving by parameter a lab order.
     * @param labOrder The lab order relating to the test.
     */
    public Test(LabOrder labOrder) {
        this.labOrder = labOrder;
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
     * @return the test parameter intended if the code exists. If not, informs the user that the code does not exists.
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
    public String toString() {
        return "Test:" + labOrder + ", sample=" + sample;
    }

}
