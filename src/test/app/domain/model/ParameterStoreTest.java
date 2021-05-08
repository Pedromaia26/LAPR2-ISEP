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

        Company c = new Company("Many Labs");
        boolean flag = c.getParameterStore().validateParameter(p1);
        boolean flag2 = c.getParameterStore().validateParameter(p2);

        Assert.assertTrue(flag);
        Assert.assertFalse(flag2);
    }

    @Test
    public void saveParameter() {
    }

    @Test
    public void multiplicacao() {
        int a = 3;
        int b = 2;
        int resultado = 6;
        int resultado2 = ParameterStore.multiplicacao(a,b);
        Assert.assertEquals(resultado, resultado2);
    }
}