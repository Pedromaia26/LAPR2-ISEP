package app.mappers;

import app.domain.model.Test;
import app.mappers.dto.TestDTO;
import app.mappers.dto.TestDtoDate;

import java.util.ArrayList;
import java.util.List;

public class TestMapper {


    /**
     * List that stores the tests of the type TestDTO.
     */
    private List<TestDTO> listTestDto;

    /**
     * list that stores the tests of the type TestDtoDate
     */
    private List<TestDtoDate> listTestDtoDate;

    /**
     * Transforms a list of objects of Test into a list of objects of type TestDTO
     * @param listTests The list to be transformed
     * @return The transformed list
     */
    public List<TestDTO> toDto(List<Test> listTests) {
        listTestDto= new ArrayList<>();
        for (Test t : listTests) {
            listTestDto.add(new TestDTO(t));
        }
        return listTestDto;
    }

    /**
     * Transforms a list of objects of Test into a list of objects of type TestDtoDate that contains only the dates
     * @param listTests The list to be transformed
     * @return The transformed list
     */
    public List<TestDtoDate> toDtoDate(List<Test> listTests){
        listTestDtoDate  = new ArrayList<>();
        for (Test test : listTests){
            listTestDtoDate.add(new TestDtoDate(test.getCode(), test.getDate(), test.getResultRegist(), test.getReport().getCreatedAt() ));
        }
        return listTestDtoDate;
    }
}
