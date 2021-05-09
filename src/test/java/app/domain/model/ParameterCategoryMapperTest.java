package app.domain.model;

import app.controller.CreateParameterController;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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