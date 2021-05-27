package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTypeTest {

    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeDescriptionWithMoreThan15chars() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        c.getParameterCategoryStore().addToList(pc1);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pc);

        TestType tt = new TestType("Antibody or seroly test to determine if you have been infected by the virus that causes COVID-19", "Swab", "abcde", listPC);
    }

    @Test
    public void createTestTypeDescriptionWith15chars() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pc);


        TestType tt = new TestType("Sars-cov-2 test", "Swab", "abcde", listPC);
    }



    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeCollectingMethodWithMoreThan20Chars() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

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

    @Test
    public void createTestTypeCollectingMethodWith20Chars() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pc);

        TestType tt = new TestType("Blood", "Swab or syringe/tube", "abcde", listPC);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeWithInvalidCode() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

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
    public void testToString() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

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
    public void testEquals() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        ParameterCategory pc3 = new ParameterCategory("Antibodies", "ma1la");


        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        c.getParameterCategoryStore().addToList(pc3);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        ParameterCategory pc01 = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pc);
        listPC.add(pc01);

        List<ParameterCategory> listPC2 = new ArrayList<>();
        ParameterCategory pc02 = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        ParameterCategory pc03 = c.getParameterCategoryStore().getParameterCategoryByCode("10019");
        ParameterCategory pc04 = c.getParameterCategoryStore().getParameterCategoryByCode("ma1la");


        listPC2.add(pc02);
        listPC2.add(pc03);
        listPC2.add(pc04);


        TestType tt = new TestType("COVID-19 Tests", "Swab", "abcde", listPC);
        TestType tt1 = new TestType("COVID-19 Tests", "Swab", "abcde", listPC);
        TestType tt2 = new TestType("COVID-19 Tests", "Swab", "yoda1", listPC);
        TestType tt3 = new TestType("COVID-19 Tests", "Blood", "yoda1", listPC);
        TestType tt4 = new TestType("COVID-19 Tests", "Blood", "yoda1", listPC2);
        TestType tt5 = new TestType("COVID-19", "Swab", "abcde", listPC);
        TestType tt6 = null;


        Assert.assertEquals(tt,tt1);
        Assert.assertNotEquals(tt1,tt2);
        Assert.assertNotEquals(tt2,tt3);
        Assert.assertNotEquals(tt3,tt4);
        Assert.assertNotEquals(tt5, tt1);
        Assert.assertNotEquals(tt, tt6);


    }
    @Test
    public void testEqualsDifferentClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
    public void testEqualsWithNull() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

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
    public void getDescription() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

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
    public void setDescription() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
    public void getCollectingMethod() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
    public void setCollectingMethod() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
    public void getCode() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
    public void setCode() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
    public void getListPC() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
    public void setListPC() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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