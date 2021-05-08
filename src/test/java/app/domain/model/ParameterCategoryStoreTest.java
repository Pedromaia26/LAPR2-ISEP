package app.domain.model;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
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

        Assert.assertEquals(pc1, pca);
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

        Assert.assertEquals(pc1, pca);
    }

    @Test
    public void getParameterCategories() {
    }
}