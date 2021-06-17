package app.mappers;

import app.domain.model.TestParameterResult;
import app.mappers.dto.TestParameterResultDTO;

import java.util.ArrayList;
import java.util.List;

public class TestParameterResultMapper {

    /**
     * Initializes a list of a TestParameterDto.
     */
    private List<TestParameterResultDTO> lResultParametersResultDto;

    /**
     * Transforms a list of objects of TestParameterResult into a list of objects of type TestParameterResultDTO.
     * @param testParameterResultList The list to be transformed.
     * @return The transformed list.
     */
    public List<TestParameterResultDTO> toDto(List<TestParameterResult> testParameterResultList){
        lResultParametersResultDto = new ArrayList<>();
        for (TestParameterResult testParameterResult : testParameterResultList){
            lResultParametersResultDto.add(new TestParameterResultDTO(testParameterResult));
        }

        return lResultParametersResultDto;
    }
}
