package app.domain.model;

import java.io.Serializable;

public class ReferenceValue implements Serializable {
    /**
     * Double that contains minimum value
     */
    private Double minimum;
    /**
     * Double that contains maximum value
     */
    private Double maximum;
    /**
     * String that contains the metric
     */
    private String metric;

    public ReferenceValue(Double minimum, Double maximum, String metric){
        this.minimum = minimum;
        this.maximum = maximum;
        this.metric = metric;
    }

    /**
     * Returns the metric of a reference value
     * @return the metric of a reference value
     */
    public String getMetric() {
        return metric;
    }

    /**
     * Returns the minimum of a reference value
     * @return the minimum of a reference value
     */
    public Double getMinimum() {
        return minimum;
    }

    /**
     * Returns the maximum of a reference value
     * @return the maximum of a reference value
     */
    public Double getMaximum() {
        return maximum;
    }

    @Override
    public String toString() {
        return "Minimum=" + minimum +
                ", Maximum=" + maximum;
    }
}
