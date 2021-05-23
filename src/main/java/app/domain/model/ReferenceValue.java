package app.domain.model;

public class ReferenceValue {

    private Double minimum;
    private Double maximum;

    public ReferenceValue(Double minimum, Double maximum){
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Double getMinimum() {
        return minimum;
    }

    public Double getMaximum() {
        return maximum;
    }
}
