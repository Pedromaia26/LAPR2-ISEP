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

        assertEquals(p1,p2);
        assertNotEquals(p1,p3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testcheckCodeRules() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("1111111", "test", "this is a test", pc1);
        Parameter p2 = new Parameter("", "test", "this is a test", pc1);
    }
}