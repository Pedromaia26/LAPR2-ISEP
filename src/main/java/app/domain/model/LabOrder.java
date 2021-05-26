package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class LabOrder {
    private TestType testType;

    private List<Parameter> parameters;


    public LabOrder(TestType testType, List<Parameter> parameters) {
        this.testType = testType;
        this.parameters = parameters;
    }


    public TestType getTestType() {
        return testType;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }



    @Override
    public String toString() {
        return String.format("LabOrder: TestTypeCode= %s, TestTypeCollectionMethod= %s, TestTypeDescription= %s, Parameters= %s", testType.getCode(),testType.getCollectingMethod(),testType.getDescription(),parameters);
    }
}
