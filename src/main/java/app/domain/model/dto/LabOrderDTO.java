package app.domain.model.dto;

import app.domain.model.LabOrder;
import app.domain.model.Parameter;
import app.domain.model.TestType;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LabOrderDTO {

    private TestType testType;

    private List<Parameter>parameters;

    public LabOrderDTO(LabOrder order) {
        this.testType = order.getTestType();
        this.parameters = order.getParameters();

        //testype.getcode......
    }

    @Override
    public String toString() {
        return String.format("LabOrder: TestTypeCode= %s, TestTypeCollectionMethod= %s, TestTypeDescription= %s, Parameters= %s", testType.getCode(),testType.getCollectingMethod(),testType.getDescription(),parameters);

    }

}
