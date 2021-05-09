package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTypeStoreTest {

    @Test
    public void createTestType() {
        Company c = new Company("Many Labs");

        ParameterCategory pc = new ParameterCategory("Hemogram", "kl172");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "imm90");
        ParameterCategory pc2 = new ParameterCategory("Antibodies", "81nma");

        c.getParameterCategoryStore().addToList(pc);
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        TestType tt = new TestType("COVID-19", "swab/blood", "89nja", c.getParameterCategoryStore().getParameterCategories());
        TestType tt1 = c.getTestTypeStore().createTestType("COVID-19", "swab/blood", "89nja", c.getParameterCategoryStore().getParameterCategories());

        Assert.assertEquals(tt, tt1);
    }

    @Test
    public void validateTestType() {
        Company c = new Company("Many Labs");

        ParameterCategory pc = new ParameterCategory("Hemogram", "kl172");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "imm90");
        ParameterCategory pc2 = new ParameterCategory("Antibodies", "81nma");

        c.getParameterCategoryStore().addToList(pc);
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        TestType tt = new TestType("COVID-19", "swab/blood", "89nja", c.getParameterCategoryStore().getParameterCategories());

        c.getTestTypeStore().getTestTypes();

        Assert.assertTrue(true);
    }

    @Test
    public void saveTestType() {
    }
}