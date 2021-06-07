package app.domain.model;

import app.controller.App;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class TestType implements Serializable {


    /**
     * String that contains the description of a type of test
     */
    private String description;

    /**
     * String that contains the description of a collecting method
     */
    private String collectingMethod;

    /**
     * String that contains the code of a type of test
     */
    private String code;

    /**
     * List that contains the parameter categories.
     */
    private List<ParameterCategory> listPC;

    private ReferenceValue ref;
    private String api;



    /**
     * Constructs an instance of TestType receiving by parameter the description of the type of test, the collecting method,
     * the code, and the list containing the categories for the type of test.
     * Checks rule descriptions to see if the inputted data is valid.
     *
     * @param description The test type description
     * @param collectingMethod The collecting method description
     * @param code The test type code
     * @param listPC The parameter category list
     */
    public TestType (String description, String collectingMethod, String code, List<ParameterCategory> listPC) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        checkTestTypeRules(description, collectingMethod, code, listPC);


    }

    public TestType (String descriptionAPI, String collectingMethodAPI, String codeAPI, List<ParameterCategory> listPCAPI, String api) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        checkTestTypeRules(descriptionAPI, collectingMethodAPI, codeAPI, listPCAPI);
        this.api = api;
    }

    public String getApi() {
        return api;
    }

    /**
     * Returns the textual description of a test type.
     * @return characteristics of a test type.
     */
    public String toString(){
        return String.format("Description: %s\nCollecting Method: %s\nCode: %s\nCategories:\n%s", description, collectingMethod, code, listPC.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestType testType = (TestType) o;
        return Objects.equals(description, testType.description) && Objects.equals(collectingMethod, testType.collectingMethod) && Objects.equals(code, testType.code) && Objects.equals(listPC, testType.listPC);
    }

    /**
     * Returns the description of a test type.
     * @return the description of a test type.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Change the description of a test type.
     * @param description the new description of a test type.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the collecting method of a test type.
     * @return the collecting method the test type.
     */

    public String getCollectingMethod() {
        return collectingMethod;
    }

    /**
     * Change the collecting method of a test type.
     * @param collectingMethod the new collecting method of the test type.
     */

    public void setCollectingMethod(String collectingMethod) {
        this.collectingMethod = collectingMethod;
    }

    /**
     * Returns the code of a test type.
     * @return the code of the test type.
     */

    public String getCode() {
        return code;
    }

    /**
     * Change the code of a test type.
     * @param code the new code of the test type.
     */

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns the parameter categories of a test type.
     * @return list of parameter categories of the test type.
     */
    public List<ParameterCategory> getListPC() {
        return listPC;
    }

    /**
     * Change the list of parameter categories of a test type.
     * @param listPC the new list of parameter categories of the test type.
     */
    public void setListPC(List<ParameterCategory> listPC) {
        this.listPC = listPC;
    }

    public void checkTestTypeRules (String description, String collectingMethod, String code, List<ParameterCategory> listPC){

        if (description.trim().length() > 15)
            throw new IllegalArgumentException("Description cannot have more than 15 characters");

        this.description = description;


        if (collectingMethod.trim().length() > 20)
            throw new IllegalArgumentException("Collecting method cannot have more than 20 characters");

        this.collectingMethod = collectingMethod;

        if (code.trim().length() != 5)
            throw new IllegalArgumentException("Code must have 5 alphanumeric characters");

        this.code = code;

        this.listPC = listPC;
    }

}
