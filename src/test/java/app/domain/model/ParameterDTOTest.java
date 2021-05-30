package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParameterDTOTest {

    @Test
    public void getCode() {

        Company c = new Company("Many Labs");

        ParameterCategory pc = new ParameterCategory("Sangue", "12345");


        Parameter par = new Parameter("12345","Blood","Blood Parameter", pc);

        ParameterDTO dto = new ParameterDTO(par);

        String code = dto.getCodeDTO();

        Assert.assertEquals("12345", code);
    }

    @Test
    public void testToString() {
        Company c = new Company("Many Labs");

        ParameterCategory pc = new ParameterCategory("Sangue", "12345");

        Parameter par = new Parameter("12345","Blood","Blood Parameter", pc);
        ParameterDTO parameter = new ParameterDTO(par);
        String a = parameter.toString();

        Assert.assertEquals("code=12345, shortName=Blood, description=Blood Parameter, category= Name: Sangue; Code: 12345}", a);
    }


}