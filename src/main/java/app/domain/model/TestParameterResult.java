package app.domain.model;

import java.util.Date;

public class TestParameterResult {

    private ReferenceValue refValue;
    private Date createdAt;
    private String value;
    private String metric;


    public TestParameterResult(String value, String metric, ReferenceValue refValue){
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

    public String getValue() {
        return value;
    }

    public String getMetric() {
        return metric;
    }
}
