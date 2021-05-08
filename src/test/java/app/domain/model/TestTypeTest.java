package app.domain.model;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTypeTest {

    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeWithInvalidDescription() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        c.getParameterCategoryStore().addToList(pc1);

        TestType tt = new TestType("Antibody or seroly test to determine if you have been infected by the virus that causes COVID-19", "Swab", "abcde", c.getParameterCategoryStore().getParameterCategories());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeWithInvalidCollectingMethod() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        List<ParameterCategory> cat = new ArrayList<>();
        cat.add(pc1);
        cat.add(pc2);


        TestType tt = new TestType("Tests for COVID", "To make a Covid test you need a swab to collect a sample", "abcde", c.getParameterCategoryStore().getParameterCategories());

    }
    @Test(expected = IllegalArgumentException.class)
    public void createTestTypeWithInvalidCode() {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");

        List<ParameterCategory> cat = new ArrayList<>();
        cat.add(pc1);
        cat.add(pc2);


        TestType tt = new TestType("Tests for COVID", "Sample", "abcdefwq", c.getParameterCategoryStore().getParameterCategories());
    }

}