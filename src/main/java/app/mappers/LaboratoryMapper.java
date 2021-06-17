package app.mappers;

import app.domain.model.Laboratory;
import app.mappers.dto.LaboratoryDTO;

import java.util.ArrayList;
import java.util.List;

public class LaboratoryMapper {
    /**
     * List that stores the categories of the type ParameterCategoryDto.
     */
    private List<LaboratoryDTO> listLaboratoryDTO;

    public LaboratoryMapper(){
        this.listLaboratoryDTO= new ArrayList<>();
    }


    /** Transforms a list of objects of type ParameterCategory into a list of objects of type ParameterCategoryDto
     * @param listLaboratory The list to be transformed
     * @return The transformed list
     */
    public List<LaboratoryDTO> toDto(List<Laboratory> listLaboratory) {
        if(listLaboratory.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("There are no Laboratories.");
        }
        listLaboratoryDTO = new ArrayList<>();
        for (Laboratory lab : listLaboratory) {
            listLaboratoryDTO.add(new LaboratoryDTO(lab));
        }
        return listLaboratoryDTO;
    }
}
