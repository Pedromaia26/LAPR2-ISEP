package app.domain.model.mappers;

import app.domain.model.TestParameter;
import app.domain.model.dto.TestParameterDto;

import java.util.ArrayList;
import java.util.List;

public class TestParameterMapper {

    private static List<TestParameterDto> lResultParametersDto = new ArrayList<>();

    public static List<TestParameterDto> toDto(List<TestParameter> testParameterList){

            if (testParameterList.isEmpty()){
                for (TestParameter testParameter : testParameterList){
                    lResultParametersDto.add(new TestParameterDto(testParameter));
                }
            }

            return lResultParametersDto;
    }

}
