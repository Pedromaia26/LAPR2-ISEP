package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterStoreTest {

    @Test
    public void createParameter() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("11111", "test", "this is a test", pc1);

        Company c = new Company("Many Labs");
        Parameter p2 = c.getParameterStore().createParameter("11111","test", "this is a test", pc1);

        Assert.assertEquals(p1, p2);

    }

    @Test
    public void validateParameter() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("11111", "test", "this is a test", pc1);
        Parameter p2 = null;
        Parameter p3 = new Parameter("11151", "test4", "this is test", pc1);

        Company c = new Company("Many Labs");
        boolean flag = c.getParameterStore().validateParameter(p1);
        boolean flag2 = c.getParameterStore().validateParameter(p2);
        c.getParameterStore().addParameter(p1);
        c.getParameterStore().saveParameter(p1);
        c.getParameterStore().saveParameter(p2);
        c.getParameterStore().saveParameter(p3);
        boolean flag3 = c.getParameterStore().validateParameter(p1);

        Assert.assertFalse(flag3);
        Assert.assertTrue(flag);
        Assert.assertFalse(flag2);
    }

    @Test
    public void saveParameter() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("11111", "test", "this is a test", pc1);
        Parameter p2 = null;
        Parameter p3 = new Parameter("11151", "test4", "this is test", pc1);

        Company c = new Company("Many Labs");
        c.getParameterStore().validateParameter(p1);

        c.getParameterStore().addParameter(p1);
        boolean flag = c.getParameterStore().saveParameter(p1);
        boolean flag2= c.getParameterStore().saveParameter(p2);
        boolean flag3 = c.getParameterStore().saveParameter(p3);
        c.getParameterStore().validateParameter(p1);


        Assert.assertFalse(flag);
        Assert.assertFalse(flag2);
        Assert.assertTrue(flag3);
    }


    @Test
    public void getParameterByCode() {
        ParameterCategory pc1 = new ParameterCategory("test", "12345");
        Parameter p1 = new Parameter("11112", "test", "this is a test", pc1);

        Company c = new Company("Many Labs");
        Parameter p2 = c.getParameterStore().createParameter("11111","test", "this is a test", pc1);

        c.getParameterStore().addParameter(p2);

        assertEquals(p2,c.getParameterStore().getParameterByCode("11111"));

    }
}