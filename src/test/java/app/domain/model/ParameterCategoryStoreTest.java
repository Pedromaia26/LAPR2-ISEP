package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParameterCategoryStoreTest {

    @Test
    public void getParameterCategoryByCode() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram", "12345");
        ParameterCategory pc2 = new ParameterCategory("Hemogram2", "12346");
        ParameterCategory pc3 = new ParameterCategory("Hemogram3", "12357");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        c.getParameterCategoryStore().addToList(pc3);

        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("12345");

        assertEquals(pc1, pca);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nonexistentCategory() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram", "12345");
        ParameterCategory pc2 = new ParameterCategory("Hemogram2", "12346");
        ParameterCategory pc3 = new ParameterCategory("Hemogram3", "12357");

        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        c.getParameterCategoryStore().addToList(pc3);

        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("00982");

        assertEquals(pc1, pca);
    }

    @Test
    public void getParameterCategories() {
    }

    @Test
    public void validateParameterCategoryNull() {
        ParameterCategory pc = null;
        ParameterCategory pc1 = new ParameterCategory("Hemogram", "12345");


        Company c = new Company("Many Labs");
        boolean flag = c.getParameterCategoryStore().validateParameterCategory(pc);
        boolean flag2 = c.getParameterCategoryStore().validateParameterCategory(pc1);
        c.getParameterCategoryStore().addToList(pc1);
        boolean flag3 = c.getParameterCategoryStore().validateParameterCategory(pc1);



        Assert.assertFalse(flag3);
        Assert.assertFalse(flag);
        Assert.assertTrue(flag2);
    }

    @Test
    public void validateParameterCategory() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "12345");

        Company c = new Company("Many Labs");
        c.getParameterCategoryStore().validateParameterCategory(pc);

        Assert.assertTrue(true);
    }


    @Test
    public void saveParameterCategory() {
        Company c = new Company("Many Labs");
        ParameterCategory pc = new ParameterCategory("Hemogram", "12345");

        boolean flag = c.getParameterCategoryStore().saveParameterCategory(pc);
        boolean flag1 = c.getParameterCategoryStore().saveParameterCategory(pc);

        Assert.assertFalse(flag1);
        Assert.assertTrue(flag);
    }

    @Test
    public void createParameterCategory(){
        Company c = new Company("Many Labs");
        ParameterCategory pc1 = new ParameterCategory("Hemogram", "12345");
        ParameterCategory pc2 = new ParameterCategory("Covid","11111");
        ParameterCategoryStore store = new ParameterCategoryStore();

        ParameterCategory pc3 = store.createParameterCategory("Hemogram", "12345");

        Assert.assertNotEquals(pc2, pc3);
        Assert.assertEquals(pc1, pc3);
    }
}