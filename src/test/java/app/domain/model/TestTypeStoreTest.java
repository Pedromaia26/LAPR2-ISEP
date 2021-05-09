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

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc01 = c.getParameterCategoryStore().getParameterCategoryByCode("kl172");
        ParameterCategory pc02 = c.getParameterCategoryStore().getParameterCategoryByCode("81nma");

        listPC.add(pc01);
        listPC.add(pc02);

        List<ParameterCategory> listPC2 = new ArrayList<>();
        ParameterCategory pc03 = c.getParameterCategoryStore().getParameterCategoryByCode("kl172");
        ParameterCategory pc04 = c.getParameterCategoryStore().getParameterCategoryByCode("81nma");

        listPC2.add(pc03);
        listPC2.add(pc04);

        TestType tt = new TestType("COVID-19", "swab/blood", "89nja", listPC);
        TestType tt1 = c.getTestTypeStore().createTestType("COVID-19", "swab/blood", "89nja", listPC2);

        Assert.assertEquals(tt, tt1);
    }

    @Test
    public void validateTestType() {
        Company c = new Company("Many Labs");

        ParameterCategory pc = new ParameterCategory("Hemogram", "kl172");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "imm90");
        ParameterCategory pc2 = new ParameterCategory("Antibodies", "81nma");

        c.getParameterCategoryStore().validateParameterCategory(pc);
        c.getParameterCategoryStore().validateParameterCategory(pc1);
        c.getParameterCategoryStore().validateParameterCategory(pc2);
        c.getParameterCategoryStore().addToList(pc);
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        c.getParameterCategoryStore().saveParameterCategory(pc1);
        c.getParameterCategoryStore().saveParameterCategory(pc2);

        List<ParameterCategory> listPCtt = new ArrayList<>();
        ParameterCategory pc01 = c.getParameterCategoryStore().getParameterCategoryByCode("kl172");
        ParameterCategory pc02 = c.getParameterCategoryStore().getParameterCategoryByCode("81nma");

        listPCtt.add(pc01);
        listPCtt.add(pc02);

        List<ParameterCategory> listPCtt2 = new ArrayList<>();
        ParameterCategory pc03 = c.getParameterCategoryStore().getParameterCategoryByCode("kl172");
        ParameterCategory pc04 = c.getParameterCategoryStore().getParameterCategoryByCode("81nma");

        listPCtt2.add(pc03);
        listPCtt2.add(pc04);

        TestType tt = new TestType("COVID-19", "swab/blood", "89nja", listPCtt);
        TestType tt1 = null;
        TestType tt2 = new TestType("COVID-19", "swab/blood", "89nja", listPCtt2);

        boolean flag1 = c.getTestTypeStore().validateTestType(tt);
        c.getTestTypeStore().addToList(tt);
        c.getTestTypeStore().saveTestType(tt);
        boolean flag2 = c.getTestTypeStore().validateTestType(tt1);
        c.getTestTypeStore().addToList(tt1);
        c.getTestTypeStore().saveTestType(tt1);
        boolean flag3 = c.getTestTypeStore().validateTestType(tt2);

        Assert.assertTrue(flag1);
        Assert.assertFalse(flag2);
        Assert.assertFalse(flag3);

    }

    @Test
    public void saveTestType() {
    }
}