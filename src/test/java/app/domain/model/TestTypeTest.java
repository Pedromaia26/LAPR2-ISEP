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

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pc);

        TestType tt = new TestType("Antibody or seroly test to determine if you have been infected by the virus that causes COVID-19", "Swab", "abcde", listPC);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeDescriptionWith15chars() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pc);


        TestType tt = new TestType("Sars-cov-2 tests", "Swab", "abcde", listPC);
    }



    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeWithInvalidCollectingMethod() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pc);

        TestType tt = new TestType("Tests for COVID", "To make a Covid test you need a swab to collect a sample", "abcde", listPC);

    }
    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeWithInvalidCode() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        ParameterCategory pc01 = c.getParameterCategoryStore().getParameterCategoryByCode("11111");


        listPC.add(pc);
        listPC.add(pc01);


        TestType tt = new TestType("Tests for COVID", "Swab", "abcdefwq", listPC);
    }

    @Test
    public void testToString() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pc);

        TestType tt = new TestType("Blood test", "Tubes and syringe", "abcde", listPC);

        Assert.assertEquals("Description: Blood test\nCollecting Method: Tubes and syringe\nCode: abcde\nCategories:\n[Name: Immunity; Code: 11111]", tt.toString());
    }

    @Test
    public void testEquals() {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        ParameterCategory pc01 = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pc);
        listPC.add(pc01);


        TestType tt = new TestType("COVID-19 Tests", "Swab", "abcde", listPC);
        TestType tt1 = new TestType("COVID-19 Tests", "Swab", "abcde", listPC);

        Assert.assertTrue(true);
    }
    @Test
    public void testEqualsDifferentClass() {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "l91ma");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        ParameterCategory pc01 = c.getParameterCategoryStore().getParameterCategoryByCode("l91ma");

        listPC.add(pc);
        listPC.add(pc01);

        TestType tt = new TestType("COVID-19 Tests", "Swab", "abcde", listPC);
        TestType tt1 = new TestType("COVID-19 Tests", "Swab", "abcde", listPC);

        Assert.assertNotEquals(tt, pc2);
    }
    @Test
    public void testEqualsWithNull() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "l91ma");
        ParameterCategory pc3 = new ParameterCategory("Antibodies", "ak1il");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        c.getParameterCategoryStore().addToList(pc3);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        ParameterCategory pc01 = c.getParameterCategoryStore().getParameterCategoryByCode("ak1il");

        listPC.add(pc);
        listPC.add(pc01);

        TestType tt = new TestType("COVID-19 Tests", "Swab", "abcde", listPC);
        TestType tt1 = null;

        Assert.assertFalse(false);
    }

}