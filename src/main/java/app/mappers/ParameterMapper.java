package app.mappers;

import app.domain.model.Parameter;
import app.mappers.dto.ParameterDTO;

import java.util.ArrayList;
import java.util.List;

public class ParameterMapper{

    /**
     List that stores the categories of the type ParameterCategoryDto.
    */
    private List<ParameterDTO> listParameterDto;

    public ParameterMapper(){
        this.listParameterDto= new ArrayList<>();
    }


    /** Transforms a list of objects of type ParameterCategory into a list of objects of type ParameterCategoryDto
     * @param listParameter The list to be transformed
     * @return The transformed list
     */
    public List<ParameterDTO> toDto(List<Parameter> listParameter) {
        if(listParameter.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("There are no Parameters.");
        }
        listParameterDto = new ArrayList<>();
        for (Parameter par : listParameter) {
            listParameterDto.add(new ParameterDTO(par));
        }
        return listParameterDto;
    }
}