package app.domain.model;

import app.controller.App;

public class TestParameter {

    private Parameter parameter;
    private TestParameterResult tpr;


    public TestParameter(Parameter parameter){
        this.parameter = parameter;

    }

    public Parameter getParameter(){
        return parameter;

    }

    public void addResult(String result, String metric, ReferenceValue refValue){
        tpr = new TestParameterResult(result, metric, refValue);
    }

    public TestParameterResult getTpr() {
        return tpr;
    }

    @Override
    public String toString() {
        return "TestParameter{" +
                "parameter=" + parameter +
                ", tpr=" + tpr +
                '}';
    }
}