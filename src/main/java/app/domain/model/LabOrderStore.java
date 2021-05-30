package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class LabOrderStore {
    /**
     * List that contains the laborders.
     */
    private List<LabOrder> labOrders= new ArrayList<>();
    /**
     * Returns the list of labOrders.
     * @return the list of a laborders.
     */
    public List<LabOrder> getLabOrders() {
        return labOrders;
    }
    /**
     * Validates the labOrder received.
     * @param lb the laborder to be validated.
     * @return True if the laborder is successfully validated, false if it is not.
     */
    public boolean validateLB(LabOrder lb){
        if (lb == null)
            return false;
        return ! this.labOrders.contains(lb);
    }
    /**
     * Saves the laborder received.
     * @param labOrder the laborder to be saved.
     * @return True if the laborder is successfully saved, false if it is not.
     */
    public boolean addToList (LabOrder labOrder){
        if (!validateLB(labOrder))
            return false;
        return this.labOrders.add(labOrder);
    }

}
