package app.domain.model;

import app.controller.App;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestStoreTest {

    @Test
    public void getTestByBarcode() {
        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc2 = new ParameterCategory("hemogram23", "09091");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        Parameter p1 = new Parameter("8ika1", "bb", "sangue", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);
        param.add(p1);

        App.getInstance().getCompany().getParameterCategoryStore().saveParameterCategory(pc);
        App.getInstance().getCompany().getParameterCategoryStore().saveParameterCategory(pc2);

        List<Parameter> param2 = new ArrayList<>();

        param2.add(p);


        List<ParameterCategory> listPC = new ArrayList<>();

        ParameterCategory pca = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("09090");
        ParameterCategory pca2 = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("09091");

        listPC.add(pca);
        listPC.add(pca2);

        List<ParameterCategory> listPC2 = new ArrayList<>();

        ParameterCategory pcb = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("09090");

        listPC2.add(pcb);

        TestType tt = new TestType("Covid", "Swab", "12309", listPC);
        TestType tt2 = new TestType("Blood", "syringe", "12389", listPC2);

        List<TestType> ttList = new ArrayList<>();

        ttList.add(tt);
        ttList.add(tt2);

        LabOrder lO = new LabOrder(tt, param);
        LabOrder lO1 = new LabOrder(tt2, param2);

        app.domain.model.Test t = new app.domain.model.Test(lO);
        app.domain.model.Test t2 = new app.domain.model.Test(lO1);

        App.getInstance().getCompany().getTestStore().addToList(t);
        App.getInstance().getCompany().getTestStore().addToList(t2);


        Sample s = new Sample(lO);
        App.getInstance().getCompany().getTestStore().saveSample(s);
        Sample s1 = new Sample(lO1);
        App.getInstance().getCompany().getTestStore().saveSample(s1);


        app.domain.model.Test a = App.getInstance().getCompany().getTestStore().getTestByBarcode(1);
        app.domain.model.Test b = App.getInstance().getCompany().getTestStore().getTestByBarcode(2);


        String expected = "Test: labOrder, sample= + sample";

        assertEquals("Covid", t.getLabOrder().getTestType().getDescription());

       // for (Parameter parameter : a.getLabOrder().getParameters()) {
         //   System.out.println(parameter.getShortName());
        // }

       // System.out.println("---------------");

        // for (Parameter parameter : b.getLabOrder().getParameters()){
            // System.out.println(parameter.getShortName());
        // }

        // System.out.println("------------------");

        // System.out.println(a.getTestParameterFor("01981").getShortName());

        // System.out.println("-----------------");

        // System.out.println("TEM QUE DAR ERRO");

        //  System.out.println(b.getTestParameterFor("8ika1").getShortName());
    }
}