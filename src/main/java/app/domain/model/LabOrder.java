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
        return "LabOrder:" +
                " TestTypeCode= " + testType.getCode() +
                ", TestTypeCollectionMethod= " + testType.getCollectingMethod() +
                ", TestTypeDescription= " + testType.getDescription() +
                ", Parameters= " + parameters ;
    }
}
