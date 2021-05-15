package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class LabOrderMapper {

    private List<TestDTO> listLabOrderDto;

    /**
     * Transforms a list of objects of type ParameterCategory into a list of objects of type ParameterCategoryDto
     * @param listParameterCategory The list to be transformed
     * @return The transformed list
     */
    public List<TestDTO> toDto(List<Test> listParameterCategory) {
        listLabOrderDto= new ArrayList<>();
        for (Test cat : listParameterCategory) {

            listLabOrderDto.add(new TestDTO(cat));
        }
        return listLabOrderDto;
    }
}
