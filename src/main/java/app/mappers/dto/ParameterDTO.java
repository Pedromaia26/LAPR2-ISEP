package app.mappers.dto;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;

import java.util.List;

public class ParameterDTO {

    /**
     String that contains the parameterDto code.
     */
    private String code;
    /**
     String that contains the parameterDto short name.
     */
    private String shortName;
    /**
     String that contains the parameterDto description.
     */
    private String description;
    /**
     Object ParameterCategory corresponding to the category that categorizes the parameterDto
     */
    private ParameterCategory category;

    public String getCodeDTO() {
        return code;
    }

    public String getShortName() {
        return shortName;
    }

    /**
     * Returns the textual description of a ParameterDto.
     * @return characteristics of a parameterDto.
     */
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
