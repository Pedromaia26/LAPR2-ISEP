package app.domain.model;

import java.util.List;

public class TestType {

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
    public TestType (String description, String collectingMethod, String code, List<ParameterCategory> listPC) {

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
