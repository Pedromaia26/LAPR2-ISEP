package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class LabOrderStore {
    private List<LabOrder> labOrders= new ArrayList<>();

    public List<LabOrder> getLabOrders() {
        return labOrders;
    }

    public boolean validateLB(LabOrder lb){
        if (lb == null)
            return false;
        return ! this.labOrders.contains(lb);
    }

    public boolean addToList (LabOrder labOrder){
        if (!validateLB(labOrder))
            return false;
        return this.labOrders.add(labOrder);
    }

   /* public LabOrder getLabOrderByCode(String code) {
        for (LabOrder tt: this.labOrders) {
            if (code.equals(tt.getTestType().getCode()))
                return tt;
        }
        throw new IllegalArgumentException("There is no Test Type with such code!");
    }*/
}
