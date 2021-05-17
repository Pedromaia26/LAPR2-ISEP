package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Test {


    private LabOrder labOrder;

    private List<Sample> sample=new ArrayList<>();

    public Test(LabOrder labOrder) {
        this.labOrder = labOrder;
    }



    public LabOrder getLabOrder() {
        return labOrder;
    }

    public List<Sample> getSample() {
        return sample;
    }

    @Override
    public String toString() {
        return "Test:" + labOrder + ", sample=" + sample;
    }

}
