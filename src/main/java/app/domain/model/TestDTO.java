package app.domain.model;

public class TestDTO {
    private LabOrder labOrder;

    private Sample sample;

    public TestDTO(Test test) {
        this.labOrder=test.getLabOrder();
        this.sample=test.getSample();
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "labOrder=" + labOrder.toString() +
                ", sample=" + sample +
                '}';
    }

    public LabOrder getLabOrder() {
        return labOrder;
    }

    public Sample getSample() {
        return sample;
    }
}
