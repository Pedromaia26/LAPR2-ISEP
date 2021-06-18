package app.domain.model;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BarcodeCreateTest {

    @Test
    public void testEquals() throws InstantiationException, IllegalAccessException, ClassNotFoundException, BarcodeException, OutputException, IOException, ParseException {
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

        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);


        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder= new LabOrder(testesss,param);

        c.getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l);


        c.getTestStore().addToList(nteste);


        Sample s = new Sample(c);
        nteste.addSample(s);
        Sample s1 = new Sample(c2);
        nteste.addSample(s1);

        BarcodeCreate barcodeCreate= s.getBarcode();

        BarcodeCreate barcodeCreate1 = s1.getBarcode();



        Assert.assertEquals(barcodeCreate.getBarcodeNumber(),barcodeCreate1.getBarcodeNumber());

    }

    @Test
    public void testEqualsNull() throws InstantiationException, IllegalAccessException, ClassNotFoundException, BarcodeException, OutputException, IOException, ParseException {
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
        Sample s1 = null;
        nteste.addSample(s1);

        BarcodeCreate barcodeCreate= s.getBarcode();

        BarcodeCreate barcodeCreate1 = null;



        Assert.assertNotEquals(barcodeCreate,barcodeCreate1);

    }


    @Test
    public void testEqualsDifferentClasses() throws InstantiationException, IllegalAccessException, ClassNotFoundException, BarcodeException, OutputException, IOException, ParseException {
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
        Sample s1 = new Sample(c2);
        nteste.addSample(s1);

        BarcodeCreate barcodeCreate= s.getBarcode();




        Assert.assertNotEquals(barcodeCreate,client);

    }


    @Test
    public void testEqualsNotEqual() throws InstantiationException, IllegalAccessException, ClassNotFoundException, BarcodeException, OutputException, IOException, ParseException {
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

        BarcodeCreate barcodeCreate= s.getBarcode();

        BarcodeCreate barcodeCreate1 = s1.getBarcode();



        Assert.assertNotEquals(barcodeCreate,barcodeCreate1);

    }


    @Test
    public void testEqualsSameClass() throws InstantiationException, IllegalAccessException, ClassNotFoundException, BarcodeException, OutputException, IOException, ParseException {
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
        Sample s1 = new Sample(c2);
        nteste.addSample(s1);

        BarcodeCreate barcodeCreate= s.getBarcode();





        Assert.assertEquals(barcodeCreate,barcodeCreate);

    }

    @Test
    public void getBarcode() throws ClassNotFoundException, InstantiationException, IllegalAccessException, OutputException, BarcodeException, IOException, ParseException {
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
        Sample s1 = new Sample(c2);
        nteste.addSample(s1);

        BarcodeCreate barcodeCreate= s.getBarcode();

        Assert.assertEquals(s.getBarcode().getBarcode(),barcodeCreate.getBarcode());
    }

    @Test
    public void getBarcodeNumber() throws ClassNotFoundException, InstantiationException, IllegalAccessException, OutputException, BarcodeException, IOException, ParseException {
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
        Sample s1 = new Sample(c2);
        nteste.addSample(s1);

        BarcodeCreate barcodeCreate= s.getBarcode();

        Assert.assertEquals("00000000001",barcodeCreate.getBarcodeNumber());
    }

    @Test
    public void testToString() throws OutputException, BarcodeException, IOException, ParseException, ClassNotFoundException, IllegalAccessException, InstantiationException {
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
        Sample s1 = new Sample(c2);
        nteste.addSample(s1);

        BarcodeCreate barcodeCreate= s.getBarcode();


        assertEquals("BarcodeCreate{barcode="+barcodeCreate.getBarcode()+", barcodeNumber='"+barcodeCreate.getBarcodeNumber()+"'}",barcodeCreate.toString());
    }
}