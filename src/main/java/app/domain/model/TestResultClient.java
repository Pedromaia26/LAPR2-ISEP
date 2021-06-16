package app.domain.model;

public class TestResultClient {

    /**
     * Short name of the parameter
     */
    private String shortName;

    /**
     * A reference value.
     */
    private ReferenceValue refValue;

    /**
     * The value of a given parameter.
     */
    private Double value;
    /**
     * A string containing the metric of a parameter.
     */
    private String metric;

    public TestResultClient(ParameterDTO parameter, TestParameterResultDTO tpresult){
        shortName = parameter.getShortName();
        refValue = tpresult.getRefValue();
        value = tpresult.getValue();
        metric = tpresult.getMetric();
    }

    public String getShortName() {
        return shortName;
    }

    public ReferenceValue getRefValue() {
        return refValue;
    }

    public Double getValue() {
        return value;
    }

    public String getMetric() {
        return metric;
    }
}
