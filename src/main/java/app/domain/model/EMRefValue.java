package app.domain.model;

import java.util.Date;
import java.util.Objects;

public class EMRefValue {

    /**
     * String that contains the ID of the parameter.
     */
    String parameterID;
    /**
     * String that contains the metric used
     */
    String metric;
    /**
     * Minimum reference value for a parameter of a given test.
     */
    Double minValue;
    /**
     * Maximum reference value for a parameter of a given test.
     */
    Double maxValue;
    /**
     * Date when the reference value was created.
     */
    Date onDate;

    /**
     * Instantiates a new EmRefValue.
     * @param parameterID the parameter.
     * @param metric the metric used.
     * @param minValue the minimum reference value.
     * @param maxValue the maximum reference value.
     * @param onDate the date.
     */
    public EMRefValue (String parameterID, String metric, double minValue, double maxValue, Date onDate){
        this.parameterID = parameterID;
        this.metric = metric;
        this.minValue = minValue;
        this.onDate = onDate;
    }

    /**
     * Returns the parameter ID.
     * @return the parameter ID.
     */
    public String getParameterID() {
        return parameterID;
    }

    /**
     * Returns the measurement unit used.
     * @return the metric.
     */
    public String getMetric() {
        return metric;
    }

    /**
     * Returns the minimum reference value for a parameter.
     * @return the minimum value.
     */

    public Double getMinValue() {
        return minValue;
    }
    /**
     * Returns the maximum reference value for a parameter.
     * @return the maximum value.
     */

    public Double getMaxValue() {
        return maxValue;
    }

    /**
     * Returns the date of when the reference value was created.
     * @return the date.
     */

    public Date getOnDate() {
        return onDate;
    }

    /**
     * Compares reference value object that evokes the method with another
     * @param o The object to compare
     * @return True if reference values are equal and false if different
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EMRefValue referenceValue = (EMRefValue) o;
        return Objects.equals(parameterID, referenceValue.parameterID) && Objects.equals(metric, referenceValue.metric) && Objects.equals(minValue, referenceValue.minValue) && Objects.equals(maxValue, referenceValue.maxValue) && Objects.equals(onDate, referenceValue.onDate);
    }

    /**
     * Returns the textual description of a reference value.
     * @return Characteristics of the reference value.
     */
    @Override
    public String toString() {
        return String.format("Parameter ID: %s\nMetric: %s\nMin Value: %d\nMax Value: %d\nDate: %s");
    }
}
