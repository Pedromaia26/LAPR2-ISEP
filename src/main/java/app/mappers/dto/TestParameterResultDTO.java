package app.mappers.dto;

import app.domain.model.ReferenceValue;
import app.domain.model.TestParameterResult;

public class TestParameterResultDTO {

    /**
     * A reference value.
     */
    private ReferenceValue refValue;

    /**
     * The value of a given parameter.
     */
    private Double value;
    /**
     * A string containing the metric of a parameter.
     */
    private String metric;

    /**
     * Constructs an instance of TestParameterResultDto receiving the test parameter result to be converted in Dto.
     * @param testParameterResult the test parameter result to be converted in Dto.
     */
    public TestParameterResultDTO(TestParameterResult testParameterResult){
        this.value = testParameterResult.getValue();
        this.metric = testParameterResult.getMetric();
        this.refValue = testParameterResult.getRefValue();

    }

    public ReferenceValue getRefValue() {
        return refValue;
    }

    public Double getValue() {
        return value;
    }

    public String getMetric() {
        return metric;
    }
}
