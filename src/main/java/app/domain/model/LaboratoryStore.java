package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class LaboratoryStore {

    /**
     * List that contains the Laboratories.
     */
    private List<Laboratory> laboratoryList = new ArrayList<>();

    /**
     * Create a new Clynical Analysis Laboratory with the kind of test it operates.
     * @param laboratoryID Laboratory ID
     * @param name Laboratory's name
     * @param address Laboratory's address
     * @param phoneNumber Laboratory's phone number
     * @param tinNumber Laboratory's Tax Identification Number
     * @param test Types of tests list
     * @return The test type created.
     */

    public Laboratory createLaboratory (String laboratoryID, String name, String address, long phoneNumber, long tinNumber, List<TestType> test) {
        return new Laboratory(laboratoryID, name, address, phoneNumber, tinNumber, test);
    }


    /**
     * Validates the Laboratory received.
     * @param cl the Laboratory to be validated.
     * @return True if the Laboratory is successfully validated, false if it is not.
     */

    public boolean validateLaboratory (Laboratory cl){
        if (cl == null)
            return false;
        return !this.laboratoryList.contains(cl);
    }

    /**
     * Saves the Laboratory received.
     * @param cl Laboratory to be saved.
     * @return True if the Laboratory is successfully saved, false if it is not.
     */

    public boolean saveLaboratory (Laboratory cl){
        if (!validateLaboratory(cl))
            return false;
        return laboratoryList.add(cl);
    }

    public List<Laboratory> getLaboratoryList() {
        return laboratoryList;
    }

    public Laboratory getLabByLabId(String labid){

        for (Laboratory lab: laboratoryList) {
            if (labid.equals(lab.getLaboratoryID()))
                return lab;
        }
        throw new IllegalArgumentException("There is no Lab with such ID!");
    }
}