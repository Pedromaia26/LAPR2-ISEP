package app.domain.model;

import java.util.List;

public class LaboratoryStore {

    /**
     * List that contains the Laboratories.
     */
    private List<Laboratory> LaboratoryList;

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
        return !this.LaboratoryList.contains(cl);
    }

    /**
     * Saves the Laboratory received.
     * @param cl Laboratory to be saved.
     * @return True if the Laboratory is successfully saved, false if it is not.
     */

    public boolean saveLaboratory (Laboratory cl){
        if (!validateLaboratory(cl))
            return false;
        return LaboratoryList.add(cl);
    }
}