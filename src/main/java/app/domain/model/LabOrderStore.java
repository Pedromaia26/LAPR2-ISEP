package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class LabOrderStore {
    private List<LabOrder> labOrders= new ArrayList<>();

    public List<LabOrder> getLabOrders() {
        return labOrders;
    }

    public void addToList (LabOrder labOrder){
        labOrders.add(labOrder);
    }
}
