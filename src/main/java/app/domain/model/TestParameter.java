package app.domain.model;

import app.controller.App;

public class TestParameter {

    private Parameter parameter;
    private TestParameterResult tpr;

    public TestParameter(){

    }

    public Parameter getParameter(){
        return parameter;

    }

    public void addResult(String result, String metric, ReferenceValue refValue){
        TestParameterResult testResult = new TestParameterResult(result, metric, refValue);
    }

    public TestParameterResult getTpr() {
        return tpr;
    }
}