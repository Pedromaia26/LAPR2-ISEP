package app.domain.mappers.dto;

import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.mappers.dto.TestTypeDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTypeDTOTest {

    @Test
    public void getDescription() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ParameterCategory pc = new ParameterCategory("Hemogram", "09909");
        List<ParameterCategory> pcList = new ArrayList<>();

        pcList.add(pc);

        TestType tt = new TestType("COVID-19", "swab", "12345", pcList);
        TestTypeDTO ttDTO = new TestTypeDTO(tt);

        String expected = "COVID-19";
        String actual = ttDTO.getDescription();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getCollectingMethod() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ParameterCategory pc = new ParameterCategory("Hemogram", "09909");
        List<ParameterCategory> pcList = new ArrayList<>();

        pcList.add(pc);

        TestType tt = new TestType("COVID-19", "swab", "12345", pcList);
        TestTypeDTO ttDTO = new TestTypeDTO(tt);

        String expected = "swab";
        String actual = ttDTO.getCollectingMethod();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCode() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ParameterCategory pc = new ParameterCategory("Hemogram", "09909");
        List<ParameterCategory> pcList = new ArrayList<>();

        pcList.add(pc);

        TestType tt = new TestType("COVID-19", "swab", "12345", pcList);
        TestTypeDTO ttDTO = new TestTypeDTO(tt);

        String expected = "12345";
        String actual = ttDTO.getCode();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getListPC() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ParameterCategory pc = new ParameterCategory("Hemogram", "09909");
        List<ParameterCategory> pcList = new ArrayList<>();

        pcList.add(pc);

        TestType tt = new TestType("COVID-19", "swab", "12345", pcList);
        TestTypeDTO ttDTO = new TestTypeDTO(tt);

        String expected = "[Name: Hemogram; Code: 09909]";
        String actual = ttDTO.getListPC().toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToString() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ParameterCategory pc = new ParameterCategory("Hemogram", "09909");
        List<ParameterCategory> pcList = new ArrayList<>();

        pcList.add(pc);

        TestType tt = new TestType("COVID-19", "swab", "12345", pcList);
        TestTypeDTO ttDTO = new TestTypeDTO(tt);

        String expected = "TestTypeDTO{description='COVID-19', code='12345'}";
        String actual = ttDTO.toString();

        Assert.assertEquals(expected, actual);


    }
}