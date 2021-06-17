package app.mappers.dto;

import app.domain.model.ParameterCategory;

public class ParameterCategoryDto {

    /**
     * String that contains the parameter category Dto code.
     */
    private String code;

    /**
     * String that contains the parameter category Dto name.
     */
    private String name;



    /**
     * Constructs an instance of ParameterCategoryDto with the same attributes as the received ParameterCategory.
     *
     * @param category The parameterCategory to be copied
     */
    public ParameterCategoryDto(ParameterCategory category){
        this.code = category.getCode();
        this.name = category.getName();
    }

    /**
     * Returns the textual description of parameter category Dto.
     * @return Characteristics of the parameter category Dto
     */
    @Override
    public String toString() {
        return String.format("--------------------------\nCode: %s\nName: %s\n--------------------------\n",code, name);
    }

    /**
     * Returns the code of the parameter category Dto.
     *
     * @return The code of the parameter category Dto
     */
    public String getCode(){
        return code;
    }

    /**
     * Returns the name of the parameter category Dto.
     *
     * @return The name of the parameter category Dto
     */
    public String getName(){
        return name;
    }

    /**
     * Change the name of the parameter category Dto.
     *
     * @param name The new name of the parameter category Dto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Change the name of the parameter category Dto.
     *
     * @param code The new code of the parameter category Dto
     */
    public void setCode(String code) {
        this.code = code;
    }
}
