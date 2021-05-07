package app.domain.model;

import java.util.List;

public class TestType {

    private String description;
    private String collectingMethod;
    private String code;
    private List<ParameterCategory> listPC;

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
