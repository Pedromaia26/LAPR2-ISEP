package app.domain.model;

public class ReferenceValue {

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
}
