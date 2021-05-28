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

    @Override
    public String toString() {
        return "ParameterDTO{" +
                "code='" + code + "'" +
        ", shortName='" + shortName + "'" +
        '}';
    }

    public ParameterDTO(Parameter tt){
        this.code = tt.getCode();
        this.shortName= tt.getShortName();
        this.description = tt.getDescription();
        this.category = tt.getCategory();
    }
}
