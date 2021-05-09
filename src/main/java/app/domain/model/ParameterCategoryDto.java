package app.domain.model;

public class ParameterCategoryDto {

    private String code;
    private String name;


    public ParameterCategoryDto(ParameterCategory category){
        this.code = category.getCode();
        this.name = category.getName();
    }

    @Override
    public String toString() {
        return String.format("--------------------------\nCode: %s\nName: %s\n--------------------------\n",code, name);
    }
}
