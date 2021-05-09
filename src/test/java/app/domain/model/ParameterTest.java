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
        Parameter p9 = new Parameter("11111", "test3", "this is test", pc1);

        Assert.assertNotEquals(p1, p9);
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
        //Parameter p1 = new Parameter("1111111", "test", "this is a test", pc1);
        Parameter p2 = new Parameter(null, "test", "this is a test", pc1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckShortNameRules() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        //Parameter p1 = new Parameter("11111", "thisIsATest", "this is a test", pc1);
        Parameter p2 = new Parameter("11111", null, "this is a test", pc1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRules() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("11111", "test", "this is a test of check description", pc1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRulest() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p3 = new Parameter("11111", "test", null, pc1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckDescriptionRulesy() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p4 = new Parameter("11111", "test", "qwertyuiolpkjhgfdsazx", pc1);
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


}