package app.domain.model;

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
        return "LabOrder:" +
                " testTypeCode= " + testType.getCode() +
                ", testTypeCode= " + testType.getCollectingMethod() +
                ", testTypeCode= " + testType.getDescription() +
                ", parameters= " + parameters ;
    }

}
