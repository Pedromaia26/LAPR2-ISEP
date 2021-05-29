package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterTest {

    @Test
    public void testEquals() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        ParameterCategory pc2 = new ParameterCategory("test2", "12345");
        Parameter p1 = new Parameter("11111", "test", "this is a test", pc1);
        Parameter p2 = new Parameter("11111", "test", "this is a test", pc1);
        Parameter p3 = new Parameter("12345", "test", "this is a test", pc1);
        Parameter p5 = new Parameter("11111", "test3", "this is a test", pc1);
        Parameter p6 = new Parameter("11111", "test", "this is test", pc1);
        Parameter p7 = new Parameter("11123", "test3", "this is a test", pc1);
        Parameter p8 = new Parameter("11135", "test", "this is test", pc1);
        Parameter p9 = new Parameter("11111", "test3", "this is test", pc1);
        Parameter p10 = new Parameter("11111", "test", "this is a test", pc2);
        Parameter p4 = null;

        Assert.assertEquals(p1,p1);
        Assert.assertEquals(p1,p2);
        Assert.assertNotEquals(p1,p3);
        Assert.assertNotEquals(p1,p4);
        Assert.assertNotEquals(p1,p5);
        Assert.assertNotEquals(p1,p6);
        Assert.assertNotEquals(p1,p7);
        Assert.assertNotEquals(p1,p8);
        Assert.assertNotEquals(p1,p9);
        Assert.assertNotEquals(p1, p10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules1() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("1111111", "test", "this is a test", pc1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules2() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p2 = new Parameter(null, "test", "this is a test", pc1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCheckShortNameRules1() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p2 = new Parameter("11111", null, "this is a test", pc1);
    }

    @Test
    public void testCheckShortNameRules2() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p2 = new Parameter("11111", "88888888", "this is a test", pc1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckShortNameRules3() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p2 = new Parameter("11111", "awrgddvtyh", "this is a test", pc1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules1() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("11111", "test", "this is a test of check description", pc1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules2() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p3 = new Parameter("11111", "test", null, pc1);
    }

    @Test
    public void testCheckDescriptionRules3() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p4 = new Parameter("11111", "test", "qwertyuiolpkjhgfdsaz", pc1);
    }

    @Test
    public void testToString() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("11111", "test", "this is a test", pc1);

        String expected = "Short Name: test; Code: 11111; Description: this is a test; Parameter Category: Name: test; Code: 12345";
        String notExpected = "asdasdsad";

        Assert.assertEquals(expected, p1.toString());
        Assert.assertNotEquals(notExpected, p1.toString());
    }

    @Test
    public void testGetCode() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String expected = "12345";
        String actual = parameter.getCode();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCodeNotEquals() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String notExpected = "00000";
        String actual = parameter.getCode();
        Assert.assertNotEquals(notExpected, actual);
    }

    @Test
    public void testSetCode() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String expected = "00000";
        parameter.setCode("00000");
        String actual = parameter.getCode();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetCodeNotEquals() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String notExpected = "12345";
        parameter.setCode("00000");
        String actual = parameter.getCode();
        Assert.assertNotEquals(notExpected, actual);
    }

    @Test
    public void testGetShortName() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String expected = "Blood";
        String actual = parameter.getShortName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetShortNameNotEquals() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String notExpected = "Covid";
        String actual = parameter.getShortName();
        Assert.assertNotEquals(notExpected, actual);
    }

    @Test
    public void testSetShortName() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String expected = "Covid";
        parameter.setShortName("Covid");
        String actual = parameter.getShortName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetShortNameNotEquals() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String notExpected = "Blood";
        parameter.setShortName("Covid");
        String actual = parameter.getShortName();
        Assert.assertNotEquals(notExpected, actual);
    }

    @Test
    public void testGetDescription() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String expected = "Blood Test";
        String actual = parameter.getDescription();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDescriptionNotEquals() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String notExpected = "Covid";
        String actual = parameter.getDescription();
        Assert.assertNotEquals(notExpected, actual);
    }

    @Test
    public void testSetDescription() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String expected = "Covid";
        parameter.setDescription("Covid");
        String actual = parameter.getDescription();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetDescriptionNotEquals() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        String notExpected = "Blood Test";
        parameter.setDescription("Covid");
        String actual = parameter.getDescription();
        Assert.assertNotEquals(notExpected, actual);
    }

    @Test
    public void testGetCategory() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        ParameterCategory cat2 = parameter.getCategory();
        Assert.assertEquals(cat, cat2);
    }

    @Test
    public void testGetCategoryNotEquals() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        ParameterCategory cat2 = new ParameterCategory("Covid","11111");
        Assert.assertNotEquals(cat, cat2);
    }

    @Test
    public void testSetCategory() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        ParameterCategory cat2 = new ParameterCategory("Covid" , "11111");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        parameter.setCategory(cat2);
        ParameterCategory actual = parameter.getCategory();
        Assert.assertEquals(cat2, actual);

    }

    @Test
    public void testSetCategoryNotEquals() {
        ParameterCategory cat = new ParameterCategory("Blood","00000");
        Parameter parameter = new Parameter("12345","Blood", "Blood Test", cat);
        ParameterCategory cat2 = new ParameterCategory("Covid" , "11111");
        parameter.setCategory(cat2);
        ParameterCategory actual = parameter.getCategory();
        Assert.assertNotEquals(actual, cat);
    }

}