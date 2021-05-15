package app.domain.model;

public class Test {


    private LabOrder labOrder;

    private Sample sample;

    public Test(LabOrder labOrder) {
        this.labOrder = labOrder;
    }

    public void setSample(Sample sample) {

        this.sample = sample;
    }

    public LabOrder getLabOrder() {
        return labOrder;
    }

    public Sample getSample() {
        return sample;
    }

    @Override
    public String toString() {
        return "Test{" +
                "labOrder=" + labOrder +
                ", sample=" + sample +
                '}';
    }

}
