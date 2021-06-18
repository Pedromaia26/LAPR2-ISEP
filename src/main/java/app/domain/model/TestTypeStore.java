package app.domain.model;

import app.serialization.Serialization;

import java.util.ArrayList;
import java.util.List;

public class TestTypeStore {

    /**
     * List that contains the types of tests.
     */
    private List <TestType> testTypeList;

    /**
     * Object used to save the information.
     */
    private Serialization ser = new Serialization();

    public TestTypeStore() {
        testTypeList = new ArrayList<>();
    }

    /**
     * Adds a new type of test to the list of test types.
     * @param tt receives an instance of TestType.
     */
    public boolean addToList (TestType tt){
        if (!validateTestType(tt))
            return false;

        return testTypeList.add(tt);
    }

    public void add(TestType testType){
        testTypeList.add(testType);
    }

    /**
     * Create a new type of test with the attributes received.
     * @param description The test type description
     * @param collectingMethod The collecting method description
     * @param code The test type code
     * @param cat The parameter category list
     * @return The test type created.
     */

    public TestType createTestType (String description, String collectingMethod, String code, List<ParameterCategory> cat) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        return new TestType(description, collectingMethod, code, cat);
    }

    public TestType createTestType (String description, String collectingMethod, String code, List<ParameterCategory> cat, String api) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        return new TestType(description, collectingMethod, code, cat, api);
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
        testTypeList.add(tt);
        save();
        return true;
    }


    public TestType getTestTypeByCode(String code) {
        for (TestType tt: this.testTypeList) {
            if (code.equals(tt.getCode()))
                return tt;
        }
        throw new IllegalArgumentException("There is no Test Type with such code!");
    }
    /**
     * Returns the list of test types.
     * @return list of test types.
     */
    public List<TestType> getTestTypes(){
        return testTypeList;
    }


    public void save(){
        ser.escrever((List<Object>) (List<?>) testTypeList, "testType.ser");
    }

    public void read(Company c){
        testTypeList = (List<TestType>) (List<?>) ser.ler("testType.ser");
    }


    public TestType getTestTypeByDescription(String test) {

        for (TestType tt: this.testTypeList) {


            if (test.equals(tt.getDescription())) {

                return tt;

            }
        }
        throw new IllegalArgumentException("There is no Test Type with such Description!");
    }

}


