package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterTest {

    @Test
    public void testEquals() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("11111", "test", "this is a test", pc1);
        Parameter p2 = new Parameter("11111", "test", "this is a test", pc1);
        Parameter p3 = new Parameter("12345", "test3", "this is test", pc1);
        Parameter p4 = null;
        Parameter p5 = new Parameter("12345", "test", "this is a test", pc1);
        Parameter p6 = new Parameter("11111", "test3", "this is a test", pc1);
        Parameter p7 = new Parameter("11111", "test", "this is test", pc1);
        Parameter p8 = new Parameter("11135", "test", "this is test", pc1);


        Assert.assertNotEquals(p1, p8);
        Assert.assertNotEquals(p1, p7);
        Assert.assertNotEquals(p1, p5);
        Assert.assertNotEquals(p1, p6);
        Assert.assertNotEquals(p1,pc1);
        Assert.assertNotEquals(p1,p4);
        Assert.assertEquals(p1, p1);
        Assert.assertEquals(p1,p2);
        Assert.assertNotEquals(p1,p3);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckCodeRules() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("1111111", "test", "this is a test", pc1);
        Parameter p2 = new Parameter("", "test", "this is a test", pc1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckShortNameRules() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("11111", "thisIsATest", "this is a test", pc1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("11111", "test", "this is a test of check description", pc1);
    }


}