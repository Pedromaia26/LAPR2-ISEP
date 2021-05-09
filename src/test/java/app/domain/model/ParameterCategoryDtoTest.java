package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterCategoryDtoTest {

    @Test
    public void testToString() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "12345");
        ParameterCategoryDto pcDto = new ParameterCategoryDto(pc);

        String expected = String.format("--------------------------\nCode: 12345\nName: Hemogram\n--------------------------\n");
        String actual = pcDto.toString();
        String notExpected = "notExpected";

        Assert.assertEquals(expected, actual);
        Assert.assertNotEquals(notExpected, actual);
    }

    @Test
    public void getCode() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "12345");
        ParameterCategoryDto pcDto = new ParameterCategoryDto(pc);

        String expected = "12345";
        String notExpected = "12222";
        String actual = pcDto.getCode();

        Assert.assertEquals(expected, actual);
        Assert.assertNotEquals(notExpected, actual);
    }

    @Test
    public void getName() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "12345");
        ParameterCategoryDto pcDto = new ParameterCategoryDto(pc);

        String expected = "Hemogram";
        String notExpected = "Hemagrom";
        String actual = pcDto.getName();

        Assert.assertEquals(expected, actual);
        Assert.assertNotEquals(notExpected, actual);
    }
}