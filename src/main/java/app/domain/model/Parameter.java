package app.domain.model;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;


public class Parameter {

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
        if (shortName.length() > 8 ) {
            throw new IllegalArgumentException("Code must have 4 to 8 chars.");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return this.category.equals(parameter.category) && this.description.equals(parameter.description) && this.code.equals(parameter.code) && this.shortName.equals(parameter.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, shortName, description, category);
    }
}
