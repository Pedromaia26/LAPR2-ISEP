package app.domain.model;

import app.controller.App;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LabOrder implements Serializable {
    /**
     * TestType that contains the testtype of a laborder
     */
    private TestType testType;
    /**
     * Parameter list that contains the parameters of a laborder
     */
    private List<Parameter> parameters;
    /**
     * ReferenceValue that contains the referenceValue of a laborder
     */
    private ReferenceValue ref;

    /**
     * Create a lab order, receiving by parameter the testtype and the list of parameters.
     * @param testType The testType
     * @param parameters The list of parameters
     */
    public LabOrder(TestType testType, List<Parameter> parameters) {
        this.testType = testType;
        this.parameters = parameters;

    }

    /**
     * Returns the testtype of a laborder.
     * @return the testtype of a laborder.
     */
    public TestType getTestType() {
        return testType;
    }

    /**
     * Returns the parameters of a laborder.
     * @return the parameters of a laborder.
     */
    public List<Parameter> getParameters() {
        return parameters;
    }


    /**
     * Returns the textual description of a laborder.
     * @return characteristics of a laborder.
     */
    @Override
    public String toString() {
        return String.format("TestTypeCode= %s, TestTypeDescription= %s, Parameters= %s", testType.getCode(),testType.getDescription(),parameters);
    }


}
