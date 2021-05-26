package app.domain.model;

import java.util.Date;

public class TestParameterResult {

    private ReferenceValue refValue;
    private Date createdAt;
    private Double value;
    private String metric;


    public TestParameterResult(Double value, String metric, ReferenceValue refValue){
        this.value = value;
        this.metric = metric;
        this.refValue = refValue;

    }


    public ReferenceValue getRefValue() {
        return refValue;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Double getValue() {
        return value;
    }

    public String getMetric() {
        return metric;
    }

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
