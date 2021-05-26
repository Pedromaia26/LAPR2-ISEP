package app.domain.model.dto;

import app.domain.model.LabOrder;
import app.domain.model.Sample;
import app.domain.model.Test;

import java.util.List;

public class TestDTO {
    private LabOrder labOrder;

    private String code;

    private List<Sample> sample;

    public TestDTO(Test test) {
        this.labOrder=test.getLabOrder();
        this.sample=test.getSample();
        this.code=test.getCode();
    }

    public String getCode() { return code; }

    @Override
    public String toString() {
        return "TestDTO:"+"code: " +code  +" ,"+ labOrder.toString() + ", sample=" + sample;
    }

    public LabOrder getLabOrder() {
        return labOrder;
    }

    public List<Sample> getSample() {
        return sample;
    }
}
