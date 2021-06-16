package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestParameterTest {

    @Test
    public void getParameter() {

        ParameterCategory pc = new ParameterCategory("Hemogram", "90009");
        Parameter p = new Parameter("jkjkl", "hemogl", "hemoglobin values", pc);

        TestParameter tp = new TestParameter(p);

        String actual = tp.getParameter().getCode();

        Assert.assertEquals("jkjkl", actual);

    }


    @Test
    public void getTpr() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Client cli = new Client("1234567890123456", 1234567890, "22/10/2002", "male", 2345678909L, "aa@gmail.com", "Jonas", 91111111112L,"asdasda");
        Company c = new Company("Many Labs");

        ParameterCategory pc = new ParameterCategory("Hemogram", "90009");
        ParameterCategory pc2 = new ParameterCategory("Urine", "78710");

        List <ParameterCategory> pcList = new ArrayList<>();
        pcList.add(pc);
        pcList.add(pc2);

        Parameter p = new Parameter("IgGAN", "hemogl", "hemoglobin values", pc);
        Parameter p1 = new Parameter("azxaz", "pH", "pH values urine", pc2);

        List <Parameter> pList = new ArrayList<>();
        pList.add(p);


        TestType tt = new TestType("COVID-19", "swab", "89898", pcList);

        LabOrder lO =  new LabOrder(tt, pList);

        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test t = new app.domain.model.Test(c, cli, "123412341200", lO,l);

        ReferenceValue ref = new ReferenceValue(1.0d, 1.5d, "10e9L");

        TestParameter tp = new TestParameter(p);

        tp.addResult(1d, "10e9L", ref);

        Assert.assertEquals("10e9L", tp.getTpr().getMetric());

    }

    /*@Test
    public void getTpr() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Company c = new Company("Many Labs");

        ParameterCategory pc = new ParameterCategory("Hemogram", "90009");
        ParameterCategory pc2 = new ParameterCategory("Urine", "78710");

        List <ParameterCategory> pcList = new ArrayList<>();
        pcList.add(pc);
        pcList.add(pc2);

        Parameter p = new Parameter("IgGAN", "hemogl", "hemoglobin values", pc);
        Parameter p1 = new Parameter("azxaz", "pH", "pH values urine", pc2);

        List <Parameter> pList = new ArrayList<>();
        pList.add(p);


        TestType tt = new TestType("COVID-19", "swab", "89898", pcList);

        LabOrder lO =  new LabOrder(tt, pList);
        app.domain.model.Test t = new app.domain.model.Test(c, 1234567890, 1876543210, lO);

        t.addTestResult("IgGAN", 1D);

        TestParameter tp = new TestParameter(p);

        double actual = tp.getTpr().getValue();

        Assert.assertEquals("1", actual);

    }  */

    /*
    @Test
    public void testToString() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Company c = new Company("Many Labs");

        ParameterCategory pc = new ParameterCategory("Hemogram", "90009");
        ParameterCategory pc2 = new ParameterCategory("Urine", "78710");

        List <ParameterCategory> pcList = new ArrayList<>();
        pcList.add(pc);
        pcList.add(pc2);

        Parameter p = new Parameter("IgGAN", "hemogl", "hemoglobin values", pc);
        Parameter p1 = new Parameter("azxaz", "pH", "pH values urine", pc2);

        List <Parameter> pList = new ArrayList<>();
        pList.add(p);


        TestType tt = new TestType("COVID-19", "swab", "89898", pcList);

        LabOrder lO =  new LabOrder(tt, pList);
        app.domain.model.Test t = new app.domain.model.Test(c, 1234567890, 1876543210, lO);

        TestParameter tp = new TestParameter(p);
    }*/
}
