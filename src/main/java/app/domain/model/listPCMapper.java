package app.domain.model;

import java.util.List;

public class listPCMapper {

    private List<ParameterCategoryStore> listPCDto;

    public List<ParameterCategoryStore> toDTO (List<ParameterCategoryStore> pcs){
        for (ParameterCategoryStore parameterCategory : pcs){
            listPCDto.add(parameterCategory);
        }
        return listPCDto;
    }
}
