package app.domain.model.mappers;

import app.domain.model.Test;
import app.domain.model.dto.TestDTO;

import java.util.ArrayList;
import java.util.List;

public class TestMapper {

    private List<TestDTO> listTestDto;

    /**
     * Transforms a list of objects of type Test into a list of objects of type TestDTO
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
}
