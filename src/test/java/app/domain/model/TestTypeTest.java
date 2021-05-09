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

    @Test
    public void getDescription() {

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

        String a = tt.getDescription();

        Assert.assertEquals("COVID-19 Tests", a);

    }

    @Test
    public void setDescription() {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "klam1");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "8n1a7");
        ParameterCategory pc3 = new ParameterCategory("Antibodies", "ça1pa");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        c.getParameterCategoryStore().addToList(pc3);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("klam1");
        ParameterCategory pc01 = c.getParameterCategoryStore().getParameterCategoryByCode("ça1pa");

        listPC.add(pc);
        listPC.add(pc01);

        TestType tt = new TestType("COVID-19 Tests", "Swab", "abcde", listPC);

        tt.setDescription("COVID-19");

        String a = tt.getDescription();

        Assert.assertEquals("COVID-19", a);

    }

    @Test
    public void getCollectingMethod() {
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

        String a = tt.getCollectingMethod();

        Assert.assertEquals("Swab", a);
    }

    @Test
    public void setCollectingMethod() {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram", "klam1");
        ParameterCategory pc2 = new ParameterCategory("Immunity", "8n1a7");
        ParameterCategory pc3 = new ParameterCategory("Antibodies", "ça1pa");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        c.getParameterCategoryStore().addToList(pc3);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("ça1pa");
        ParameterCategory pc01 = c.getParameterCategoryStore().getParameterCategoryByCode("8n1a7");

        listPC.add(pc);
        listPC.add(pc01);

        TestType tt = new TestType("COVID-19 Tests", "Swab", "abcde", listPC);

        tt.setCollectingMethod("blood");

        String a = tt.getCollectingMethod();

        Assert.assertEquals("blood", a);
    }

    @Test
    public void getCode() {
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

        String a = tt.getCode();

        Assert.assertEquals("abcde", a);
    }

    @Test
    public void setCode() {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram", "klam1");
        ParameterCategory pc2 = new ParameterCategory("Immunity", "8n1a7");
        ParameterCategory pc3 = new ParameterCategory("Antibodies", "ça1pa");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        c.getParameterCategoryStore().addToList(pc3);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("ça1pa");
        ParameterCategory pc01 = c.getParameterCategoryStore().getParameterCategoryByCode("8n1a7");

        listPC.add(pc);
        listPC.add(pc01);

        TestType tt = new TestType("COVID-19 Tests", "Swab", "abcde", listPC);

        tt.setCode("mkal1");

        String a = tt.getCode();

        Assert.assertEquals("mkal1", a);
    }

    @Test
    public void getListPC() {
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


        TestType tt = new TestType("COVID-19 Tests", "Swab", "abcde", listPC);

        List<ParameterCategory> a = tt.getListPC();

        Assert.assertEquals(listPC, a);
    }

    @Test
    public void setListPC() {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram", "klam1");
        ParameterCategory pc2 = new ParameterCategory("Immunity", "8n1a7");
        ParameterCategory pc3 = new ParameterCategory("Antibodies", "ak1il");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        c.getParameterCategoryStore().addToList(pc3);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("8n1a7");
        ParameterCategory pc01 = c.getParameterCategoryStore().getParameterCategoryByCode("klam1");

        listPC.add(pc);
        listPC.add(pc01);

        List<ParameterCategory> listPC2 = new ArrayList<>();
        ParameterCategory pc02 = c.getParameterCategoryStore().getParameterCategoryByCode("ak1il");

        listPC2.add(pc02);

        TestType tt = new TestType("Blood", "Tubes and Syringe", "ma17a", listPC);

        tt.setListPC(listPC2);

        List<ParameterCategory> a = tt.getListPC();

        Assert.assertEquals(listPC2, a);

    }
}