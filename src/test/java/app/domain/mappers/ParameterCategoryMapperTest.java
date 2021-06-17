package app.domain.mappers;

import app.controller.CreateParameterController;
import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.mappers.dto.ParameterCategoryDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryMapperTest {

    @Test
    public void toDto() {
        Company c = new Company("Many Labs");
        CreateParameterController contr = new CreateParameterController(c);
        ParameterCategory pc1 = new ParameterCategory("Hemogram", "12345");
        List<ParameterCategory> pcList = new ArrayList<>();
        pcList.add(pc1);

        List<ParameterCategoryDto> pcDtoList = contr.getParameterCategoryDto();

        for(ParameterCategoryDto cat : pcDtoList){
            String name = cat.getName();
            String code = cat.getCode();
            Assert.assertEquals(name,"Hemogram", "12345");
        }
    }
}