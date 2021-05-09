package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryMapper{

    /**
     * List that stores the categories of the type ParameterCategoryDto.
     */
    private List<ParameterCategoryDto> listParameterCategoryDto = new ArrayList<>();


    /**
     * Transforms a list of objects of type ParameterCategory into a list of objects of type ParameterCategoryDto
     * @param listParameterCategory The list to be transformed
     * @return The transformed list
     */
    public List<ParameterCategoryDto> toDto(List<ParameterCategory> listParameterCategory) {
        for (ParameterCategory cat : listParameterCategory) {
            listParameterCategoryDto.add(new ParameterCategoryDto(cat));
        }
        return listParameterCategoryDto;
    }
}
