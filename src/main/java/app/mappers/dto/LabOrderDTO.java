package app.mappers.dto;

import app.domain.model.LabOrder;
import app.domain.model.Parameter;
import app.domain.model.TestType;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LabOrderDTO {
    /**
     * TestType that contains the testtype of a laborder
     */
    private TestType testType;
    /**
     * Parameter list that contains the parameters of a laborder
     */
    private List<Parameter>parameters;
    /**
     * Create a lab order, receiving by parameter the laborder.
     * @param order The labOrder
     */
    public LabOrderDTO(LabOrder order) {
        this.testType = order.getTestType();
        this.parameters = order.getParameters();

        //testype.getcode......
    }
    /**
     * Returns the textual description of a labOrderDto.
     * @return characteristics of a labOrderDto.
     */
    @Override
    public String toString() {
        return String.format("LabOrder: TestTypeCode= %s, TestTypeCollectionMethod= %s, TestTypeDescription= %s, Parameters= %s", testType.getCode(),testType.getCollectingMethod(),testType.getDescription(),parameters);

    }

}
