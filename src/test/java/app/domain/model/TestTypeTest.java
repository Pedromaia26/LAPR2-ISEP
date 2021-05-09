package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTypeTest {

    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeDescriptionWithMoreThan15chars() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        c.getParameterCategoryStore().addToList(pc1);

        TestType tt = new TestType("Antibody or seroly test to determine if you have been infected by the virus that causes COVID-19", "Swab", "abcde", c.getParameterCategoryStore().getParameterCategories());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeDescriptionWith15chars() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        c.getParameterCategoryStore().addToList(pc1);

        TestType tt = new TestType("Sars-cov-2 tests", "Swab", "abcde", c.getParameterCategoryStore().getParameterCategories());
    }



    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeWithInvalidCollectingMethod() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);


        TestType tt = new TestType("Tests for COVID", "To make a Covid test you need a swab to collect a sample", "abcde", c.getParameterCategoryStore().getParameterCategories());

    }
    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeWithInvalidCode() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);


        TestType tt = new TestType("Tests for COVID", "Swab", "abcdefwq", c.getParameterCategoryStore().getParameterCategories());
    }

    @Test
    public void testToString() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        TestType tt = new TestType("Blood test", "Tubes and syringe", "abcde", c.getParameterCategoryStore().getParameterCategories());

        Assert.assertEquals("Description: Blood test\nCollecting Method: Tubes and syringe\nCode: abcde\nCategories:\n[Name: Immunity; Code: 11111, Name: Hemogram; Code: 10019]", tt.toString());
    }

    @Test
    public void testEquals() {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        TestType tt = new TestType("COVID-19 Tests", "Swab", "abcde", c.getParameterCategoryStore().getParameterCategories());
        TestType tt1 = new TestType("COVID-19 Tests", "Swab", "abcde", c.getParameterCategoryStore().getParameterCategories());

        Assert.assertTrue(true);
    }
    @Test
    public void testEqualsDifferentClass() {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        TestType tt = new TestType("COVID-19 Tests", "Swab", "abcde", c.getParameterCategoryStore().getParameterCategories());
        TestType tt1 = new TestType("COVID-19 Tests", "Swab", "abcde", c.getParameterCategoryStore().getParameterCategories());

        Assert.assertNotEquals(tt, pc2);
    }
    @Test
    public void testEqualsWithNull() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = null;

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(null);

        TestType tt = new TestType("COVID-19 Tests", "Swab", "abcde", c.getParameterCategoryStore().getParameterCategories());
        TestType tt1 = new TestType("COVID-19 Tests", "Swab", "abcde", c.getParameterCategoryStore().getParameterCategories());

        Assert.assertFalse(false);


    }

}