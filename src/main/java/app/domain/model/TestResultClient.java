package app.domain.model;

import app.mappers.dto.ParameterDTO;
import app.mappers.dto.TestParameterDto;
import app.mappers.dto.TestParameterResultDTO;

public class TestResultClient {

    /**
     * Short name of the parameter
     */
    private String shortName;
    /**
     * Double with the minimum value of the parameter
     */
    private Double minimum;
    /**
     * Double with the maximum value of the parameter
     */
    private Double maximum;
    /**
     * String with the code of the parameter
     */
    private String code;
    /**
     * The value of a given parameter.
     */
    private Double value;
    /**
     * A string containing the metric of a parameter.
     */
    private String metric;

    public TestResultClient(ParameterDTO parameter, TestParameterResultDTO tpresult){
        code = parameter.getCodeDTO();
        shortName = parameter.getShortName();
        minimum = tpresult.getRefValue().getMinimum();
        maximum = tpresult.getRefValue().getMaximum();
        value = tpresult.getValue();
        metric = tpresult.getMetric();
    }

    public TestResultClient(TestParameterDto parameter, TestParameterResult tpresult){
        code = parameter.getParameterdto().getCode();
        shortName = parameter.getParameterdto().getShortName();
        minimum = tpresult.getRefValue().getMinimum();
        maximum = tpresult.getRefValue().getMaximum();
        value = tpresult.getValue();
        metric = tpresult.getMetric();
    }
    /**
     * Returns the short name
     *
     * @return the short name
     */
    public String getShortName() {
        return shortName;
    }
    /**
     * Returns the minimum
     *
     * @return the minimum
     */
    public Double getMinimum() {
        return minimum;
    }
    /**
     * Returns the maximum
     *
     * @return the maximum
     */
    public Double getMaximum() {
        return maximum;
    }

    /**
     * Returns the Value
     *
     * @return the Value
     */
    public Double getValue() {
        return value;
    }

    /**
     * Returns the Code
     *
     * @return the Code
     */
    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "TestResultClient{" +
                "shortName='" + shortName + '\'' +
                ", minimum=" + minimum +
                ", maximum=" + maximum +
                ", code='" + code + '\'' +
                ", value=" + value +
                ", metric='" + metric + '\'' +
                '}';
    }


    /**
     * Returns the Metric
     *
     * @return the metric
     */
    public String getMetric() {
        return metric;
    }
}
