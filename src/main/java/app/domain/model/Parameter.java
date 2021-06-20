package app.domain.model;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;


public class Parameter implements Serializable {

    /**
     * String that contains the parameter code.
     */
    private String code;
    /**
     * String that contains the parameter short name.
     */
    private String shortName;
    /**
     * String that contains the parameter description.
     */
    private String description;
    /**
     * Object ParameterCategory corresponding to the category that categorizes the parameter
     */
    private ParameterCategory category;

    /**
     * Constructs an instance of Parameter receiving the code, the short name, the description and the parameter category.
     *
     * @param code The parameter code
     * @param shortName The parameter short name
     * @param description The parameter description
     * @param category The parameter category
     */
    public Parameter(String code, String shortName, String description, ParameterCategory category){
        checkCodeRules(code);
        checkShortNameRules(shortName);
        checkDescriptionRules(description);
        this.code = code;
        this.shortName = shortName;
        this.description = description;
        this.category = category;

    }


    /**
     * Check the code assignment restrictions.
     *
     * @param code The code to be validated
     */
    private void checkCodeRules(String code) {
        if (StringUtils.isBlank(code)) {
            throw new IllegalArgumentException("Code cannot be blank.");
        }
        if (!(code.length() == 5)) {
            throw new IllegalArgumentException("Code must have 5 alphanumeric characters.");
        }
    }

    /**
     * Check the short name assignment restrictions.
     *
     * @param shortName The short name to be validated
     */
    private void checkShortNameRules(String shortName) {
        if (StringUtils.isBlank(shortName)) {
            throw new IllegalArgumentException("Code cannot be blank.");
        }
        if (shortName.length() > 8) {
            throw new IllegalArgumentException("Short name must have 8 or less characters.");
        }
    }

    /**
     * Check the description assignment restrictions.
     *
     * @param description The description to be validated
     */
    private void checkDescriptionRules(String description) {
        if (StringUtils.isBlank(description)) {
            throw new IllegalArgumentException("Code cannot be blank.");
        }
        if ((description.length() > 20)) {
            throw new IllegalArgumentException("Description must have 20 or less characters.");
        }
    }

    /**
     * Compares the object that evokes the method with another
     * @param o The object to compare
     * @return True if objects are equal and false if different
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return this.category.equals(parameter.category) && this.description.equals(parameter.description) && this.code.equals(parameter.code) && this.shortName.equals(parameter.shortName);
    }

    @Override
    public String toString() {
        return String.format("Short Name: %s; Code: %s; Description: %s; Parameter Category: %s",shortName, code, description, category);
    }
    /**
     * Returns the code of parameter
     * @return the code of parameter
     */
    public String getCode() {
        return code;
    }
    /**
     * set the code of parameter.
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * Returns the short name of parameter
     * @return the short name of parameter
     */
    public String getShortName() {
        return shortName;
    }
    /**
     * set the short name of parameter.
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    /**
     * Returns the description of a parameter
     * @return the description of a parameter
     */
    public String getDescription() {
        return description;
    }

    /**
     * set the description of parameter.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Returns the category of a parameter
     * @return the category of a parameter
     */
    public ParameterCategory getCategory() {
        return category;
    }

    /**
     * set the category of parameter.
     */
    public void setCategory(ParameterCategory category) {
        this.category = category;
    }
}
