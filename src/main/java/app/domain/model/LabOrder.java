package app.domain.model;

import app.controller.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LabOrder {
    private TestType testType;

    private List<Parameter> parameters;

    private ReferenceValue ref;


    public LabOrder(TestType testType, List<Parameter> parameters) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
