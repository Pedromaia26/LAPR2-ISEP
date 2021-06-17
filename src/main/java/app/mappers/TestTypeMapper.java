package app.mappers;

import app.domain.model.TestType;
import app.mappers.dto.TestTypeDTO;

import java.util.ArrayList;
import java.util.List;

public class TestTypeMapper{

    /**
     * List that stores the categories of the type ParameterCategoryDto.
     */
    private List<TestTypeDTO> listTestTypeDto;

    public TestTypeMapper(){
        this.listTestTypeDto= new ArrayList<>();
    }


    /** Transforms a list of objects of type ParameterCategory into a list of objects of type ParameterCategoryDto
     * @param listTestType The list to be transformed
     * @return The transformed list
     */
    public List<TestTypeDTO> toDto(List<TestType> listTestType) {
        if(listTestType.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("There are no test types.");
        }
        listTestTypeDto = new ArrayList<>();
        for (TestType tt : listTestType) {
            listTestTypeDto.add(new TestTypeDTO(tt));
        }
        return listTestTypeDto;
    }
}