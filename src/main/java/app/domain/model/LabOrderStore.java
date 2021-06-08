package app.domain.model;

import app.serialization.Serialization;

import java.util.ArrayList;
import java.util.List;

public class LabOrderStore {
    /**
     * List that contains the laborders.
     */
    private List<LabOrder> labOrders= new ArrayList<>();

    /**
     * Object used to save the information.
     */
    private Serialization ser = new Serialization();

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
        this.labOrders.add(labOrder);
        save();
        return true;
    }


    public void save(){
        ser.escrever((List<Object>) (List<?>) labOrders, "labOrders.ser");
    }

    public void read(Company c){
        labOrders = (List<LabOrder>) (List<?>) ser.ler("labOrders.ser");
        System.out.println(labOrders);
    }


    public LabOrder createLabOrder (TestType testType, List<Parameter> parameters) {

        return new LabOrder(testType, parameters);
    }

}
