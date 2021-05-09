package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryMapper{

    /**
     * List that stores the categories of the type ParameterCategoryDto.
     */
    private List<ParameterCategoryDto> listParameterCategoryDto;

    public ParameterCategoryMapper(){
        this.listParameterCategoryDto= new ArrayList<>();
    }


    /**
     * Transforms a list of objects of type ParameterCategory into a list of objects of type ParameterCategoryDto
     * @param listParameterCategory The list to be transformed
     * @return The transformed list
     */
    public List<ParameterCategoryDto> toDto(List<ParameterCategory> listParameterCategory) {
        listParameterCategoryDto = new ArrayList<>();
        ParameterCategoryDto qq = new ParameterCategoryDto();
        for (ParameterCategory cat : listParameterCategory) {
            qq.setCode(cat.getCode());
            qq.setName(cat.getName());

            listParameterCategoryDto.add(qq);
        }
        return listParameterCategoryDto;
    }
}
