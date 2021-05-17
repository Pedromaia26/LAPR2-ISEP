package app.domain.model;

import java.util.List;

public class TestDTO {
    private LabOrder labOrder;

    private List<Sample> sample;

    public TestDTO(Test test) {
        this.labOrder=test.getLabOrder();
        this.sample=test.getSample();
    }

    @Override
    public String toString() {
        return "TestDTO:" + labOrder.toString() + ", sample=" + sample;
    }

    public LabOrder getLabOrder() {
        return labOrder;
    }

    public List<Sample> getSample() {
        return sample;
    }
}
