package app.domain.model;

import app.mappers.dto.SampleDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SampleTest {

    @Test
    public void createBarcode() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c= new Company("ManyLabs");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

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
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l);


        c.getTestStore().addToList(nteste);

        Sample s = new Sample(c);

        nteste.addSample(s);

        String a= s.createBarcode(c);

        assertEquals("00000000002",a);
    }

    @Test
    public void testToString() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c= new Company("ManyLabs");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

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
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l);


        c.getTestStore().addToList(nteste);

        Sample s = new Sample(c);

        nteste.addSample(s);


        String a = s.toString();

        assertEquals("barcode number='00000000001'",a);

    }

    @Test
    public void getBarcode() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {

        Company c= new Company("ManyLabs");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

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
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l);


        c.getTestStore().addToList(nteste);

        Sample s = new Sample(c);

        nteste.addSample(s);

        List<app.domain.model.Test> samples = c.getTestStore().getTests();

        for(app.domain.model.Test loDTO : samples){
            for (Sample sample : loDTO.getSample())
                System.out.println(sample.getBarcode().getBarcodeNumber());
        }
        assertEquals("00000000001",s.getBarcode().getBarcodeNumber());
    }

    @Test
    public void testEquals() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c= new Company("ManyLabs");
        Company c2= new Company("ManyLabs2");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

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
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l);


        c.getTestStore().addToList(nteste);


        Sample s = new Sample(c);
        nteste.addSample(s);
        Sample s1 = new Sample(c);
        nteste.addSample(s1);



        Assert.assertNotEquals(s,s1);



    }

    @Test
    public void testEqualsNull() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c= new Company("ManyLabs");
        Company c2= new Company("ManyLabs2");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

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

        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l);


        c.getTestStore().addToList(nteste);


        Sample s = new Sample(c);

        Sample s2 =null;

        assertNotEquals(s,s2);

    }

    @Test
    public void testEqualsDifferentClasses() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c= new Company("ManyLabs");
        Company c2= new Company("ManyLabs2");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

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

        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l);


        c.getTestStore().addToList(nteste);


        Sample s = new Sample(c);

        SampleDTO s3= new SampleDTO("asda");

        assertNotEquals(s,s3);

    }


    @Test
    public void testEqualsAlreadyAdded() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c= new Company("ManyLabs");
        Company c2= new Company("ManyLabs2");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

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
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l);


        c.getTestStore().addToList(nteste);


        Sample s = new Sample(c);

        Sample s4 = new Sample(c2);

        assertEquals(s.getBarcode().getBarcodeNumber(),s4.getBarcode().getBarcodeNumber());

    }

    @Test
    public void testEqualsSameSample() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c= new Company("ManyLabs");
        Company c2= new Company("ManyLabs2");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

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
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l);


        c.getTestStore().addToList(nteste);


        Sample s = new Sample(c);



        assertEquals(s,s);

    }
}