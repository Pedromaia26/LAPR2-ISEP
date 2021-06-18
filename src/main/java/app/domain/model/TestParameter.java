package app.domain.model;

import app.controller.App;

import java.io.Serializable;
import java.util.Objects;

public class TestParameter implements Serializable {

    /**
     * Parameter of a test.
     */
    private Parameter parameter;
    /**
     * Result of a given test parameter.
     */
    private TestParameterResult tpr;

    /**
     * Constructs an instance of TestParameter, receiving a parameter.
     * @param parameter a parameter of the test.
     */
    public TestParameter(Parameter parameter){
        this.parameter = parameter;
    }

    /**
     * Returns a parameter of the test.
     * @return the parameter.
     */
    public Parameter getParameter(){
        return parameter;

    }

    public void addResult(Double result, String metric, ReferenceValue refValue){
        tpr = new TestParameterResult(result, metric, refValue);
    }

    /**
     * Returns the parameter result of a given test.
     * @return
     */
    public TestParameterResult getTpr() {
        return tpr;
    }
    /**
     * Returns the textual description of a test parameter.
     * @return characteristics of a test parameter.
     */
    @Override
    public String toString() {
        return "TestParameter{" +
                "parameter=" + parameter +
                ", tpr=" + tpr +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestParameter test = (TestParameter) o;
        return Objects.equals(parameter, test.parameter) && Objects.equals(tpr, test.tpr);
    }

}