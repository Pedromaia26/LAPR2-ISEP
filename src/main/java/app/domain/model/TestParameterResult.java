package app.domain.model;

import java.util.Date;

public class TestParameterResult {

    /**
     * A reference value.
     */
    private ReferenceValue refValue;
    private Date createdAt;
    /**
     * The value of a given parameter.
     */
    private Double value;
    /**
     * A string containing the metric of a parameter.
     */
    private String metric;

    /**
     * Constructs an instance of TestParameterResult receiving the value of a parameter, its metric and the reference interval.
     * @param value the value of a parameter.
     * @param metric the metric of the parameter.
     * @param refValue the reference values corresponding to the parameter.
     */
    public TestParameterResult(Double value, String metric, ReferenceValue refValue){
        this.value = value;
        this.metric = metric;
        this.refValue = refValue;

    }


    /**
     * Returns the reference interval for a given parameter.
     * @return the reference values.
     */
    public ReferenceValue getRefValue() {
        return refValue;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Returns the value of a parameter.
     * @return the value of the parameter.
     */
    public Double getValue() {
        return value;
    }

    /**
     * Returns the metric of a parameter.
     * @return the metric of the parameter.
     */

    public String getMetric() {
        return metric;
    }

    /**
     * Returns the textual description of a test parameter result.
     * @return the characteristics of the test parameter result.
     */
    @Override
    public String toString() {
        return "TestParameterResult{" +
                "refValue=" + refValue +
                ", createdAt=" + createdAt +
                ", value='" + value + '\'' +
                ", metric='" + metric + '\'' +
                '}';
    }
}
