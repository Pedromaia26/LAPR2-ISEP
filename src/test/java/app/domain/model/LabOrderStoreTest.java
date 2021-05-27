package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LabOrderStoreTest {

    @Test
    public void addToList() {
        Company c= new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd","asd","12345",listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder= new LabOrder(testesss,param);

        boolean test1= c.getLabOrderStore().addToList(labOrder);


        assertTrue(test1);


    }

    @Test
    public void addToListNull() {
        Company c= new Company("ManyLabs");
        LabOrder labOrder1= null;
        boolean test2= c.getLabOrderStore().addToList(labOrder1);
        assertFalse(test2);
    }


    @Test
    public void validateLB() {
        Company c= new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd","asd","12345",listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder= new LabOrder(testesss,param);

        boolean test1= c.getLabOrderStore().validateLB(labOrder);




        assertTrue(test1);


    }

    @Test
    public void validateLBNull() {
        Company c= new Company("ManyLabs");

        LabOrder labOrder1= null;

        boolean test3= c.getLabOrderStore().validateLB(labOrder1);
        assertFalse(test3);
    }

    @Test
    public void validateLBAlreadyOnList() {
        Company c= new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd","asd","12345",listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder= new LabOrder(testesss,param);

        c.getLabOrderStore().validateLB(labOrder);
        c.getLabOrderStore().addToList(labOrder);
        boolean test2= c.getLabOrderStore().validateLB(labOrder);

        assertFalse(test2);
    }


}