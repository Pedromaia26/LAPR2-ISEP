package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParameterCategoryStoreTest {

    @Test
    public void getParameterCategoryByCode() {

        ParameterCategory pc1 = new ParameterCategory("Hemogram", "12345");
        ParameterCategory pc2 = new ParameterCategory("Hemogram2", "12346");
        ParameterCategory pc3 = new ParameterCategory("Hemogram3", "12357");

        List<ParameterCategory> cat = new ArrayList<>();
        cat.add(pc1);
        cat.add(pc2);
        cat.add(pc3);

        Company c = new Company("Many Labs");

        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("12345");

        Assert.assertEquals(pc1, pca);
    }

    @Test
    public void getParameterCategories() {
    }
}