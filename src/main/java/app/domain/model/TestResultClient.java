package app.domain.model;

import app.mappers.DTO.ParameterDTO;
import app.mappers.DTO.TestParameterDto;
import app.mappers.DTO.TestParameterResultDTO;

public class TestResultClient {

    /**
     * Short name of the parameter
     */
    private String shortName;

    private Double minimum;

    private Double maximum;

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

    public String getShortName() {
        return shortName;
    }

    public Double getMinimum() {
        return minimum;
    }

    public Double getMaximum() {
        return maximum;
    }

    public Double getValue() {
        return value;
    }

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

    public String getMetric() {
        return metric;
    }
}
