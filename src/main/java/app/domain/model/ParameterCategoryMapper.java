package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryMapper{

    private List<ParameterCategoryDto> listParameterCategoryDto = new ArrayList<>();


    public List<ParameterCategoryDto> toDto(List<ParameterCategory> listParameterCategory) {
        for (ParameterCategory cat : listParameterCategory) {
            listParameterCategoryDto.add(new ParameterCategoryDto(cat));
        }
        return listParameterCategoryDto;
    }
}
