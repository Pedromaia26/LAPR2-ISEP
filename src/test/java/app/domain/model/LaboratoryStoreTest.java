package app.domain.model;

import app.domain.model.Company;
import app.domain.model.TestType;
import app.domain.model.Laboratory;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LaboratoryStoreTest {

    @Test
    public void createLaboratory() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram",  "11111");

        c.getParameterCategoryStore().addToList(pc1);

        List<ParameterCategory> listPC = new ArrayList<>();

        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        listPC.add(pc);

        TestType tt = new TestType("Hemogram", "Swab", "12313", listPC);
        TestType tt1 = new TestType("Immunity", "Tube", "12314", listPC);

        c.getTestTypeStore().addToList(tt);
        c.getTestTypeStore().addToList(tt1);


        TestType tt0 = c.getTestTypeStore().getTestTypeByCode("12314");

        List<TestType> typeTest = new ArrayList<>();
        typeTest.add(tt0);

        Laboratory lb = new Laboratory("adada", "adada", "PortoGaiaPT", 11111111111L, 9999999999L, typeTest);
        Laboratory lb2 = c.getLaboratoryStore().createLaboratory("adada", "adada","PortoGaiaPT", 11111111111L, 9999999999L, typeTest);

        Assert.assertEquals(lb, lb2);

    }

    @Test
    public void validateLaboratory() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram",  "11111");

        c.getParameterCategoryStore().addToList(pc1);

        List<ParameterCategory> listPC = new ArrayList<>();

        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        listPC.add(pc);

        TestType tt = new TestType("Hemogram", "Swab", "12313", listPC);
        TestType tt1 = new TestType("Immunity", "Tube", "12314", listPC);

        c.getTestTypeStore().addToList(tt);
        c.getTestTypeStore().addToList(tt1);


        TestType tt0 = c.getTestTypeStore().getTestTypeByCode("12314");

        List<TestType> typeTest = new ArrayList<>();
        typeTest.add(tt0);



        Laboratory l = new Laboratory("001LR", "ExeterLaboratory", "Manchester", 11111111111L, 9811111111L, c.getTestTypeStore().getTestTypes());


        Company comp= new Company("ManyLabs");

        boolean test1= comp.getLaboratoryStore().validateLaboratory(l);

        assertTrue(test1);





    }

    @Test
    public void validateLabNull() {
        Laboratory laboratory= null;
        Company comp= new Company("ManyLabs");

        boolean test2= comp.getLaboratoryStore().validateLaboratory(laboratory);
        assertFalse(test2);
    }

    @Test
    public void validateLabSameTestAlreadyOnTheList() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram",  "11111");

        c.getParameterCategoryStore().addToList(pc1);

        List<ParameterCategory> listPC = new ArrayList<>();

        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        listPC.add(pc);

        TestType tt = new TestType("Hemogram", "Swab", "12313", listPC);
        TestType tt1 = new TestType("Immunity", "Tube", "12314", listPC);

        c.getTestTypeStore().addToList(tt);
        c.getTestTypeStore().addToList(tt1);


        TestType tt0 = c.getTestTypeStore().getTestTypeByCode("12314");

        List<TestType> typeTest = new ArrayList<>();
        typeTest.add(tt0);



        Laboratory l = new Laboratory("001LR", "ExeterLaboratory", "Manchester", 11111111111L, 9811111111L, c.getTestTypeStore().getTestTypes());


        c.getLaboratoryStore().addToList(l);

        boolean test3= c.getLaboratoryStore().validateLaboratory(l);
        assertFalse(test3);
    }

    @Test
    public void validateLabSameTestequalOnTheList() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram",  "11111");

        c.getParameterCategoryStore().addToList(pc1);

        List<ParameterCategory> listPC = new ArrayList<>();

        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        listPC.add(pc);

        TestType tt = new TestType("Hemogram", "Swab", "12313", listPC);
        TestType tt1 = new TestType("Immunity", "Tube", "12314", listPC);

        c.getTestTypeStore().addToList(tt);
        c.getTestTypeStore().addToList(tt1);


        TestType tt0 = c.getTestTypeStore().getTestTypeByCode("12314");

        List<TestType> typeTest = new ArrayList<>();
        typeTest.add(tt0);



        Laboratory l = new Laboratory("001LR", "ExeterLaboratory", "Manchester", 11111111111L, 9811111111L, c.getTestTypeStore().getTestTypes());


        c.getLaboratoryStore().addToList(l);

        Laboratory l2 = new Laboratory("001LR", "ExeterLaboratory", "Manchester", 11111111111L, 9811111111L, c.getTestTypeStore().getTestTypes());


        boolean test3= c.getLaboratoryStore().validateLaboratory(l2);
        assertFalse(test3);
    }


    @Test
    public void getLaboratoryList() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram",  "11111");

        c.getParameterCategoryStore().addToList(pc1);

        List<ParameterCategory> listPC = new ArrayList<>();

        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        listPC.add(pc);

        TestType tt = new TestType("Hemogram", "Swab", "12313", listPC);
        TestType tt1 = new TestType("Immunity", "Tube", "12314", listPC);

        c.getTestTypeStore().addToList(tt);
        c.getTestTypeStore().addToList(tt1);


        TestType tt0 = c.getTestTypeStore().getTestTypeByCode("12314");

        List<TestType> typeTest = new ArrayList<>();
        typeTest.add(tt0);



        Laboratory l = new Laboratory("001LR", "ExeterLaboratory", "Manchester", 11111111111L, 9811111111L, c.getTestTypeStore().getTestTypes());


        c.getLaboratoryStore().addToList(l);

        List<Laboratory> laboratories = c.getLaboratoryStore().getLaboratoryList();

        List<Laboratory> laboratories1= new ArrayList<>();

        laboratories1.add(l);

        assertEquals(laboratories1,laboratories);
    }

    @Test
    public void getLabByLabId() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram",  "11111");

        c.getParameterCategoryStore().addToList(pc1);

        List<ParameterCategory> listPC = new ArrayList<>();

        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        listPC.add(pc);

        TestType tt = new TestType("Hemogram", "Swab", "12313", listPC);
        TestType tt1 = new TestType("Immunity", "Tube", "12314", listPC);

        c.getTestTypeStore().addToList(tt);
        c.getTestTypeStore().addToList(tt1);


        TestType tt0 = c.getTestTypeStore().getTestTypeByCode("12314");

        List<TestType> typeTest = new ArrayList<>();
        typeTest.add(tt0);



        Laboratory l = new Laboratory("001LR", "ExeterLaboratory", "Manchester", 11111111111L, 9811111111L, c.getTestTypeStore().getTestTypes());


        c.getLaboratoryStore().addToList(l);

        Laboratory laboratory=c.getLaboratoryStore().getLabByLabId("001LR");

        assertEquals(l,laboratory);

    }
}