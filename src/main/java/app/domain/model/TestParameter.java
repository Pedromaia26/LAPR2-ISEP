package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class TestParameter {

    private List<Parameter> testParameterList;

    public TestParameter () {

    }

    public TestParameter (Test test){
        testParameterList = new ArrayList<>();
        for (Parameter pam: test.getLabOrder().getParameters()){
            testParameterList.add(pam);
        }
    }

    /**
     * Returns the test parameter from a test.
     * @param parameterCode receives a parameter code by parameter and proceeds to check if this code exists.
     * @return the test parameter intended if the code exists. If not, informs the user that the code does not exist.
     */


    public Parameter getTestParameterFor(String parameterCode){
        for (Parameter testParam: testParameterList) {
            if (parameterCode.equals(testParam.getCode()))
                return testParam;
        }
        throw new IllegalArgumentException ("There is no parameter with such code");
    }
}
