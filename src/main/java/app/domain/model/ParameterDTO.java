package app.domain.model;

import java.util.List;

public class ParameterDTO {

    /**
     String that contains the parameter code.
     */
    private String code;
    /**
     String that contains the parameter short name.
     */
    private String shortName;
    /**
     String that contains the parameter description.
     */
    private String description;
    /**
     Object ParameterCategory corresponding to the category that categorizes the parameter
     */
    private ParameterCategory category;

    public String getCodeDTO() {
        return code;
    }

    @Override
    public String toString() {
        return "code=" + code + ", shortName=" + shortName + ", description=" + description +
                ", category= " + category + '}';
    }

    public ParameterDTO(Parameter tt){
        this.code = tt.getCode();
        this.shortName= tt.getShortName();
        this.description = tt.getDescription();
        this.category = tt.getCategory();
    }
}
