package app.domain.model;

import app.controller.App;
import app.mappers.dto.SampleDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TestTest {

    @Test
    public void getSample() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c = new Company("ManyLabs");
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
        TestType testesss = new TestType("asd", "asd", "12345", listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder = new LabOrder(testesss, param);

        c.getLabOrderStore().addToList(labOrder);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test nteste = new app.domain.model.Test(c,client, "123412341200", labOrder,l);


        c.getTestStore().addToList(nteste);


        Sample sample = new Sample(c);
        nteste.addSample(sample);


        List<Sample> samples = new ArrayList<>();

        samples.add(sample);

        Assert.assertEquals(samples, nteste.getSample());
    }

    @Test
    public void validateSample() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c = new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd", "asd", "12345", listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder = new LabOrder(testesss, param);

        c.getLabOrderStore().addToList(labOrder);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test nteste = new app.domain.model.Test(c, client, "123412341200", labOrder,l);


        c.getTestStore().addToList(nteste);


        Sample sample = new Sample(c);


        boolean test1 = nteste.validateSample(sample, c);


        assertTrue(test1);


    }

    @Test
    public void validateSampleNull() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Company c = new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd", "asd", "12345", listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder = new LabOrder(testesss, param);

        c.getLabOrderStore().addToList(labOrder);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test nteste = new app.domain.model.Test(c, client, "123412341200", labOrder,l);


        c.getTestStore().addToList(nteste);

        Sample sample1 = null;
        boolean test3 = nteste.validateSample(sample1, c);

        assertFalse(test3);

    }

    @Test
    public void validateSampleAlreadyAdd() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {

        Company c = new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd", "asd", "12345", listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder = new LabOrder(testesss, param);

        c.getLabOrderStore().addToList(labOrder);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test nteste = new app.domain.model.Test(c, client, "123412341200", labOrder,l);


        c.getTestStore().addToList(nteste);

        Sample sample = new Sample(c);

        nteste.validateSample(sample, c);
        nteste.addSample(sample);
        boolean test2 = nteste.validateSample(sample, c);


        assertFalse(test2);

    }

    @Test
    public void addSample() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c = new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd", "asd", "12345", listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder = new LabOrder(testesss, param);

        c.getLabOrderStore().addToList(labOrder);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test nteste = new app.domain.model.Test(c, client, "123412341200", labOrder,l);


        c.getTestStore().addToList(nteste);


        Sample sample = new Sample(c);

        boolean test1 = nteste.addSample(sample);

        assertTrue(test1);


    }

    @Test
    public void addSampleNull() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Company c = new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd", "asd", "12345", listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder = new LabOrder(testesss, param);

        c.getLabOrderStore().addToList(labOrder);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(testesss);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test nteste = new app.domain.model.Test(c, client, "123412341200", labOrder,l);


        c.getTestStore().addToList(nteste);

        Sample sample1 = null;

        boolean test2 = nteste.validateSample(sample1, c);

        assertFalse(test2);

    }




    @Test
    public void recordNewSample() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c= new Company("ManyLabs");
        Company c1= new Company("ManyLabs");


        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

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


        Sample sample = new Sample(c);

        nteste.addSample(sample);


        SampleDTO sampleDTO= new SampleDTO("000000000001");

        app.domain.model.Test test = c.getTestStore().getTestByCode(sampleDTO.getOrderid());
        Sample test2= test.RecordNewSample(c1);


        assertEquals(sample.getBarcode().getBarcodeNumber(),test2.getBarcode().getBarcodeNumber());

    }

    @Test
    public void recordNewSampleEqual() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c= new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
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


        Sample sample = new Sample(c);

        nteste.addSample(sample);


        SampleDTO sampleDTO= new SampleDTO("000000000001");

        app.domain.model.Test test = c.getTestStore().getTestByCode(sampleDTO.getOrderid());
        Sample test2= test.RecordNewSample(c);


        assertNotEquals(sample,test2);


    }

    @Test
    public void recordNewSampleNull() throws BarcodeException, IllegalAccessException, InstantiationException, ClassNotFoundException, OutputException, IOException, ParseException {
        Company c= new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");
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


        Sample sample = null;

        nteste.addSample(sample);


        SampleDTO sampleDTO= new SampleDTO("000000000001");

        app.domain.model.Test test = c.getTestStore().getTestByCode(sampleDTO.getOrderid());
        Sample test2= test.RecordNewSample(c);


        assertNotEquals(sample,test2);


    }


    @Test
    public void creatTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, OutputException, ParseException, BarcodeException {

        Company c = new Company("Many Labs");
        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        List<ParameterCategory> listPC = new ArrayList<>();

        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        App.getInstance().getCompany().getParameterStore().addParameter(p);
        List <Parameter> listOfPar = App.getInstance().getCompany().getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test t = new app.domain.model.Test(c, client, "123412341200", lO,l);
    }


    @Test (expected = IllegalArgumentException.class)
    public void createTestNHSCodeWithLessThan12Chars() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, OutputException, ParseException, BarcodeException {

        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        App.getInstance().getCompany().getParameterStore().addParameter(p);
        List <Parameter> listOfPar = App.getInstance().getCompany().getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test t = new app.domain.model.Test(c,client, "1234123410", lO,l);

    }

    @Test (expected = IllegalArgumentException.class)
    public void createTestNHSCodeWithMoreThan12Chars() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, OutputException, ParseException, BarcodeException {

        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        App.getInstance().getCompany().getParameterStore().addParameter(p);
        List <Parameter> listOfPar = App.getInstance().getCompany().getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test t = new app.domain.model.Test(c,client, "123412341200212", lO,l);

    }

    @Test (expected = IllegalArgumentException.class)
    public void createTestTINCodeWithLessThan10Chars() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, OutputException, ParseException, BarcodeException {

        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",123456789L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        App.getInstance().getCompany().getParameterStore().addParameter(p);
        List <Parameter> listOfPar = App.getInstance().getCompany().getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);

        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test t = new app.domain.model.Test(c,client, "123412341200", lO,l);

    }
    @Test (expected = IllegalArgumentException.class)
    public void createTestTINCodeWithMoreThan10Chars() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, OutputException, ParseException, BarcodeException {

        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",12345678901L,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        App.getInstance().getCompany().getParameterStore().addParameter(p);
        List <Parameter> listOfPar = App.getInstance().getCompany().getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);

        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test t = new app.domain.model.Test(c,client, "123412341200", lO,l);

    }

    @Test
    public void testValidateTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, ParseException, BarcodeException, OutputException {
        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890,"12/12/2012","Male",1234567890,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        App.getInstance().getCompany().getParameterStore().addParameter(p);
        List <Parameter> listOfPar = App.getInstance().getCompany().getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test test = new app.domain.model.Test(c,client, "123412341200", lO,l);

        test.validateTest();
        Date expect = test.getValidationDate();

        Date actual = test.getValidationDate();

        Assert.assertEquals(expect,actual);
    }

    @Test
    public void testGetDateEquals() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, OutputException, ParseException, BarcodeException {
        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890,"12/12/2012","Male",1234567890,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        App.getInstance().getCompany().getParameterStore().addParameter(p);
        List <Parameter> listOfPar = App.getInstance().getCompany().getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test test = new app.domain.model.Test(c,client, "123412341200", lO,l);
        Date expected = new Date();

        Date actual = test.getDate();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testGetDateNotEquals() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, OutputException, ParseException, BarcodeException {
        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890,"12/12/2012","Male",1234567890,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        App.getInstance().getCompany().getParameterStore().addParameter(p);
        List <Parameter> listOfPar = App.getInstance().getCompany().getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test test = new app.domain.model.Test(c,client, "123412341200", lO,l);
        Date expected = new Date(15987);

        Date actual = test.getDate();

        Assert.assertNotEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkResultRules() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, OutputException, ParseException, BarcodeException {

        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890,"12/12/2012","Male",1234567890,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("IgGAN", "a-bodies", "antibodies",pCat);

        App.getInstance().getCompany().getParameterStore().addParameter(p);
        List <Parameter> listOfPar = App.getInstance().getCompany().getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test test = new app.domain.model.Test(c,client, "123412341200", lO,l);

        test.addTestParameterResult("00000000001", p.getCode(), -15d, "Index (S/C) value");

    }

    @Test
    public void getNhsCode() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890,"12/12/2012","Male",1234567890,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        c.getParameterCategoryStore().addToList(pc);
        c.getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        c.getParameterStore().addParameter(p);
        List <Parameter> listOfPar = c.getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test test = new app.domain.model.Test(c,client, "123412341200", lO,l);

        assertEquals("123412341200",test.getNhsCode());
    }

    @Test
    public void getLabOrder() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890,"12/12/2012","Male",1234567890,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        c.getParameterCategoryStore().addToList(pc);
        c.getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        c.getParameterStore().addParameter(p);
        List <Parameter> listOfPar = c.getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test test = new app.domain.model.Test(c,client, "123412341200", lO,l);

        assertEquals(lO,test.getLabOrder());
    }

    @Test
    public void getTestParameter() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890,"12/12/2012","Male",1234567890,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        c.getParameterCategoryStore().addToList(pc);
        c.getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        c.getParameterStore().addParameter(p);
        List <Parameter> listOfPar = c.getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test test = new app.domain.model.Test(c,client, "123412341200", lO,l);

        List<TestParameter> testParameterList = new ArrayList<>();

        for (Parameter parameter: lO.getParameters()){
            testParameterList.add(new TestParameter(parameter));
        }




        assertEquals(testParameterList,test.getTestParameter());
    }

    @Test
    public void getReport() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890,"12/12/2012","Male",1234567890,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        c.getParameterCategoryStore().addToList(pc);
        c.getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        c.getParameterStore().addParameter(p);
        List <Parameter> listOfPar = c.getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test test = new app.domain.model.Test(c,client, "123412341200", lO,l);


        test.addReport("asdasdadsada");

        assertEquals(test.getReport(),test.getReport());



    }

    @Test
    public void getTestParameterFor() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890,"12/12/2012","Male",1234567890,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        c.getParameterCategoryStore().addToList(pc);
        c.getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        c.getParameterStore().addParameter(p);
        List <Parameter> listOfPar = c.getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test test = new app.domain.model.Test(c,client, "123412341200", lO,l);

        TestParameter testParameter = test.getTestParameterFor("998la");

        assertEquals(test.getTestParameterFor("998la"),testParameter);



    }

    @Test
    public void testToString() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Company c = new Company("Many Labs");

        Client client = new Client("1234567890123456",1234567890,"12/12/2012","Male",1234567890,"asd@gmail.com","Moirane",44123456789L,"asdasda");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        c.getParameterCategoryStore().addToList(pc);
        c.getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "a-bodies", "antibodies",pCat);

        c.getParameterStore().addParameter(p);
        List <Parameter> listOfPar = c.getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);
        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        app.domain.model.Test test = new app.domain.model.Test(c,client, "123412341200", lO,l);


        assertEquals("Test:Code:"+test.getCode()+test.getLabOrder()+", sample="+test.getSample(), test.toString());
    }
    @Test
    public void saveTest() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {

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



        boolean test1=c.getTestStore().saveTest(nteste);

        assertTrue(test1);

    }

    @Test
    public void saveTestNull() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {

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


        app.domain.model.Test nteste=null;



        boolean test1=c.getTestStore().saveTest(nteste);

        assertFalse(test1);

    }

    @Test
    public void saveTestAlreadyOnList() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {

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

        boolean test1=c.getTestStore().saveTest(nteste);

        assertFalse(test1);

    }
}