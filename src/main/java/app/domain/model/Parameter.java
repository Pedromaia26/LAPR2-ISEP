package app.domain.model;


import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Bruno Ribeiro
 */

public class Parameter {

    /**
     *
     */
    private String code;
    private String shortName;
    private String description;
    private ParameterCategory category;

    public Parameter(String code, String shortName, String description, ParameterCategory category){
        checkCodeRules(code);
        checkShortNameRules(shortName);
        checkDescriptionRules(description);
        this.code = code;
        this.shortName = shortName;
        this.description = description;
        this.category = category;

    }

    private void checkCodeRules(String code) {
        if (StringUtils.isBlank(code)) {
            throw new IllegalArgumentException("Code cannot be blank.");
        }
        if (!(code.length() == 5)) {
            throw new IllegalArgumentException("Code must have 5 alphanumeric characters.");
        }
    }

    private void checkShortNameRules(String shortName) {
        if (StringUtils.isBlank(shortName)) {
            throw new IllegalArgumentException("Code cannot be blank.");
        }
        if (code.length() > 8) {
            throw new IllegalArgumentException("Code must have 4 to 8 chars.");
        }
    }

    private void checkDescriptionRules(String description) {
        if (StringUtils.isBlank(description)) {
            throw new IllegalArgumentException("Code cannot be blank.");
        }
        if (!(description.length() > 20)) {
            throw new IllegalArgumentException("Description must have 20 or less characters.");
        }
    }

}
