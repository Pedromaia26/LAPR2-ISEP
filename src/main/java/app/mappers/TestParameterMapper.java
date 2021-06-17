package app.mappers;

import app.domain.model.TestParameter;
import app.mappers.dto.TestParameterDto;

import java.util.ArrayList;
import java.util.List;

public class TestParameterMapper {

    /**
     * Initializes a list of a TestParameterDto.
     */
    private List<TestParameterDto> lResultParametersDto;

    /**
     * Transforms a list of objects of TestParameter into a list of objects of type TestParameterDTO.
     * @param testParameterList The list to be transformed.
     * @return The transformed list.
     */
    public List<TestParameterDto> toDto(List<TestParameter> testParameterList){

        if (testParameterList.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("There are no test parameters.");
        }
        lResultParametersDto = new ArrayList<>();
        for (TestParameter testParameter : testParameterList){
            lResultParametersDto.add(new TestParameterDto(testParameter));
        }

        return lResultParametersDto;
    }

}