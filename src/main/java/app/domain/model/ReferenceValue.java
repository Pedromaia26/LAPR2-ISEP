package app.domain.model;

import java.io.Serializable;

public class ReferenceValue implements Serializable {

    private Double minimum;
    private Double maximum;
    private String metric;

    public ReferenceValue(Double minimum, Double maximum, String metric){
        this.minimum = minimum;
        this.maximum = maximum;
        this.metric = metric;
    }

    public String getMetric() {
        return metric;
    }

    public Double getMinimum() {
        return minimum;
    }

    public Double getMaximum() {
        return maximum;
    }

    @Override
    public String toString() {
        return "Minimum=" + minimum +
                ", Maximum=" + maximum;
    }
}
