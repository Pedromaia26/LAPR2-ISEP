package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class TestTypeStore {

    /**
     * List that contains the types of tests.
     */
    private List <TestType> testTypeList = new ArrayList<>();

    /**
     * Adds a new type of test to the list of test types.
     * @param tt receives an instance of TestType.
     */
    public void addToList (TestType tt){
        if (!validateTestType(tt))
            testTypeList.add(tt);
    }

    /**
     * Create a new type of test with the attributes received.
     * @param description The test type description
     * @param collectingMethod The collecting method description
     * @param code The test type code
     * @param cat The parameter category list
     * @return The test type created.
     */

    public TestType createTestType (String description, String collectingMethod, String code, List<ParameterCategory> cat) {

        return new TestType(description, collectingMethod, code, cat);
    }


    /**
     * Validates the type of test received.
     * @param tt the type of test to be validated.
     * @return True if the type of test is successfully validated, false if it is not.
     */

    public boolean validateTestType (TestType tt){
        if (tt == null)
            return false;
        return !this.testTypeList.contains(tt);
    }

    /**
     * Saves the test of type received.
     * @param tt the type of test to be saved.
     * @return True if the type of test is successfully saved, false if it is not.
     */

    public boolean saveTestType (TestType tt){
        if (!validateTestType(tt))
            return false;
        return testTypeList.add(tt);
    }

    /**
     * Returns the list of test types.
     * @return list of test types.
     */
    public List<TestType> getTestTypes(){
        return testTypeList;
    }
}
