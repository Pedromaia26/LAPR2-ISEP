package app.domain.model;

import app.controller.App;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTest {

    @Test
    public void getSample() {
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

        c.getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste=new app.domain.model.Test("1234567890",1234123412L,labOrder);


        c.getTestStore().addToList(nteste);


        Sample sample = new Sample(c);
        nteste.addSample(sample);


        List<Sample> samples = new ArrayList<>();

        samples.add(sample);

        Assert.assertEquals(samples,nteste.getSample());
    }

    @Test
    public void validateSample() {
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

        c.getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste=new app.domain.model.Test("1234567890",1234123412L,labOrder);


        c.getTestStore().addToList(nteste);


        Sample sample = new Sample(c);


        Sample sample1= null;

        boolean test1= nteste.validateSample(sample,c);
        nteste.addSample(sample);
        boolean test2= nteste.validateSample(sample,c);

        boolean test3= nteste.validateSample(sample1,c);



        assertTrue(test1);
        assertFalse(test2);
        assertFalse(test3);
    }

    @Test
    public void addSample() {
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

        c.getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste=new app.domain.model.Test("1234567890",1234123412L,labOrder);


        c.getTestStore().addToList(nteste);


        Sample sample = new Sample(c);

        boolean test1= nteste.addSample(sample);


        Sample sample1= null;

        boolean test2= nteste.validateSample(sample1,c);

        assertTrue(test1);
        assertFalse(test2);


    }

    @Test
    public void recordNewSample() {
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

        c.getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste=new app.domain.model.Test("1234567890",1234123412L,labOrder);


        c.getTestStore().addToList(nteste);


        Sample sample = new Sample(c);

        nteste.addSample(sample);


        SampleDTO sampleDTO= new SampleDTO("1234567890");

        app.domain.model.Test test = c.getTestStore().getTestByCode(sampleDTO.getOrderid());
        Sample test2= test.RecordNewSample(App.getInstance().getCompany());
        Sample test3= test.RecordNewSample(c);

        assertEquals(sample,test2);
        assertNotEquals(sample, test3);

        test.addTestResult("01981", 10D);
    }
}