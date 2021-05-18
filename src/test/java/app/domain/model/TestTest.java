package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTest {

    @Test
    public void getTestParameterFor() {


        Company c = new Company("Many Labs");
        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc2 = new ParameterCategory("hemogram23", "09091");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        Parameter p1 = new Parameter("8ika1", "bb", "sangue", pc);
        List <Parameter> param = new ArrayList<>();

        param.add(p);
        param.add(p1);

        c.getParameterCategoryStore().saveParameterCategory(pc);
        c.getParameterCategoryStore().saveParameterCategory(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();

        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("09090");

        listPC.add(pca);

        TestType tt = new TestType("Covid", "Swab", "12309", listPC);
        TestType tt2 = new TestType("Blood", "syringe", "12389", listPC);

        List<TestType> ttList = new ArrayList<>();

        ttList.add(tt);
        ttList.add(tt2);

        LabOrder lO = new LabOrder(tt, param);

        app.domain.model.Test t = new app.domain.model.Test(lO);

        c.getTestStore().addToList(t);

        Sample s = new Sample(lO);

        c.getTestStore().saveSample(s);

        app.domain.model.Test a = c.getTestStore().getTestByBarcode(2);

        System.out.println(a);

        String expected = "Test: labOrder, sample= + sample";

        Assert.assertEquals(expected, a.toString());
    }
}