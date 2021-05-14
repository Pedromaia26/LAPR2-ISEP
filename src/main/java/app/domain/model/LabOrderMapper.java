package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class LabOrderMapper {

    private List<LabOrderDTO> listLabOrderDto= new ArrayList<>();

    /**
     * Transforms a list of objects of type ParameterCategory into a list of objects of type ParameterCategoryDto
     * @param listParameterCategory The list to be transformed
     * @return The transformed list
     */
    public List<LabOrderDTO> toDto(List<LabOrder> listParameterCategory) {

        for (LabOrder cat : listParameterCategory) {
            listLabOrderDto.add(new LabOrderDTO(cat));
        }
        return listLabOrderDto;
    }
}
