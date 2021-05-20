package app.domain.model;

import app.controller.App;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestParameterTest {

    @Test
    public void getTestParameterFor() {

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc2 = new ParameterCategory("hemogram23", "09091");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        Parameter p1 = new Parameter("8ika1", "bb", "sangue", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);
        param.add(p1);

        App.getInstance().getCompany().getParameterCategoryStore().saveParameterCategory(pc);
        App.getInstance().getCompany().getParameterCategoryStore().saveParameterCategory(pc2);


        List<ParameterCategory> listPC = new ArrayList<>();

        ParameterCategory pca = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("09090");
        ParameterCategory pca2 = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("09091");

        listPC.add(pca);
        listPC.add(pca2);


        TestType tt = new TestType("Covid", "Swab", "12309", listPC);
        TestType tt2 = new TestType("Blood", "syringe", "12389", listPC);

        List<TestType> ttList = new ArrayList<>();

        ttList.add(tt);
        ttList.add(tt2);

        LabOrder lO = new LabOrder(tt, param);

        app.domain.model.Test t = new app.domain.model.Test(lO);

        App.getInstance().getCompany().getTestStore().addToList(t);



        Sample s = new Sample(lO);
        App.getInstance().getCompany().getTestStore().saveSample(s);
        Sample s1 = new Sample(lO);
        App.getInstance().getCompany().getTestStore().saveSample(s1);



        app.domain.model.Test a = App.getInstance().getCompany().getTestStore().getTestByBarcode(2);


        TestParameter tp = new TestParameter(a);


        Parameter paramet = tp.getTestParameterFor("01981");

        Assert.assertEquals(paramet, p);
    }
}