package app.domain.model;

import app.domain.model.dto.SampleDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SampleTest {

    @Test
    public void createBarcode() {
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

        Sample s = new Sample(c);

        nteste.addSample(s);

        String a= s.createBarcode(c);

        assertEquals("00000000002",a);
    }

    @Test
    public void testToString() {
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

        Sample s = new Sample(c);

        nteste.addSample(s);


        String a = s.toString();

        assertEquals("barcode number='00000000001'",a);

    }

    @Test
    public void getBarcode() {

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

        Sample s = new Sample(c);

        nteste.addSample(s);

        List<app.domain.model.Test> samples = c.getTestStore().getTests();

        for(app.domain.model.Test loDTO : samples){
            for (Sample sample : loDTO.getSample())
                System.out.println(sample.getBarcode());
        }
        assertEquals("00000000001",s.getBarcode());
    }

    @Test
    public void testEquals() {
        Company c= new Company("ManyLabs");
        Company c2= new Company("ManyLabs2");

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


        Sample s = new Sample(c);
        nteste.addSample(s);
        Sample s1 = new Sample(c);
        nteste.addSample(s1);
        Sample s2 =null;

        SampleDTO s3= new SampleDTO("asda");

        Sample s4 = new Sample(c2);

        nteste.addSample(s4);





        Assert.assertNotEquals(s,s1);

        assertNotEquals(s,s2);

        assertNotEquals(s,s3);

        assertEquals(s,s4);

        assertEquals(s,s);




    }
}