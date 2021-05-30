package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTest {

    @Test
    public void getSample() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException {
        Company c = new Company("ManyLabs");
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

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

        app.domain.model.Test nteste = new app.domain.model.Test(c,client, 1234123412L, labOrder);


        c.getTestStore().addToList(nteste);


        Sample sample = new Sample(c);
        nteste.addSample(sample);


        List<Sample> samples = new ArrayList<>();

        samples.add(sample);

        Assert.assertEquals(samples, nteste.getSample());
    }

    @Test
    public void validateSample() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException {
        Company c = new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd", "asd", "12345", listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder = new LabOrder(testesss, param);

        c.getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste = new app.domain.model.Test(c, client, 1234123412L, labOrder);


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
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd", "asd", "12345", listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder = new LabOrder(testesss, param);

        c.getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste = new app.domain.model.Test(c, client, 1234123412L, labOrder);


        c.getTestStore().addToList(nteste);

        Sample sample1 = null;
        boolean test3 = nteste.validateSample(sample1, c);

        assertFalse(test3);

    }

    @Test
    public void validateSampleAlreadyAdd() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException {

        Company c = new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd", "asd", "12345", listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder = new LabOrder(testesss, param);

        c.getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste = new app.domain.model.Test(c, client, 1234123412L, labOrder);


        c.getTestStore().addToList(nteste);

        Sample sample = new Sample(c);

        nteste.validateSample(sample, c);
        nteste.addSample(sample);
        boolean test2 = nteste.validateSample(sample, c);


        assertFalse(test2);

    }

    @Test
    public void addSample() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException {
        Company c = new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd", "asd", "12345", listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder = new LabOrder(testesss, param);

        c.getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste = new app.domain.model.Test(c, client, 1234123412L, labOrder);


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
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd", "asd", "12345", listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder = new LabOrder(testesss, param);

        c.getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste = new app.domain.model.Test(c, client, 1234123412L, labOrder);


        c.getTestStore().addToList(nteste);

        Sample sample1 = null;

        boolean test2 = nteste.validateSample(sample1, c);

        assertFalse(test2);

    }




    @Test
    public void recordNewSample() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException {
        Company c= new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        c.getParameterCategoryStore().addToList(pc1);
        c.getParameterCategoryStore().addToList(pc2);
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd","asd","12345",listPC);

        c.getTestTypeStore().addToList(testesss);

        LabOrder labOrder= new LabOrder(testesss,param);

        c.getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste=new app.domain.model.Test(c, client,1234123412L,labOrder);


        c.getTestStore().addToList(nteste);


        Sample sample = new Sample(c);

        nteste.addSample(sample);


        SampleDTO sampleDTO= new SampleDTO("000000000001");

        app.domain.model.Test test = c.getTestStore().getTestByCode(sampleDTO.getOrderid());
        Sample test2= test.RecordNewSample(App.getInstance().getCompany());


        assertEquals(sample.getBarcode().getBarcodeNumber(),test2.getBarcode().getBarcodeNumber());

    }

    @Test
    public void recordNewSampleEqual() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException {
        Company c= new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
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

        app.domain.model.Test nteste=new app.domain.model.Test(c, client,1234123412L,labOrder);


        c.getTestStore().addToList(nteste);


        Sample sample = new Sample(c);

        nteste.addSample(sample);


        SampleDTO sampleDTO= new SampleDTO("000000000001");

        app.domain.model.Test test = c.getTestStore().getTestByCode(sampleDTO.getOrderid());
        Sample test2= test.RecordNewSample(c);


        assertNotEquals(sample,test2);


    }

    @Test
    public void recordNewSampleNull() throws BarcodeException, IllegalAccessException, InstantiationException, ClassNotFoundException, OutputException {
        Company c= new Company("ManyLabs");

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);
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

        app.domain.model.Test nteste=new app.domain.model.Test(c, client,1234123412L,labOrder);


        c.getTestStore().addToList(nteste);


        Sample sample = null;

        nteste.addSample(sample);


        SampleDTO sampleDTO= new SampleDTO("000000000001");

        app.domain.model.Test test = c.getTestStore().getTestByCode(sampleDTO.getOrderid());
        Sample test2= test.RecordNewSample(c);


        assertNotEquals(sample,test2);


    }

    /*@Test (expected = IllegalArgumentException.class)
    public void createTestCodeWithMoreThan10Chars() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");

        List<ParameterCategory> listPC = new ArrayList<>();

        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);


        ParameterCategory pCat = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("09090");

        listPC.add(pCat);

        TestType tt = new TestType("Covid-19", "swab", "12345", listPC);

        Parameter p = new Parameter("998la", "hemogl", "hemoglobin values",pCat);

        App.getInstance().getCompany().getParameterStore().addParameter(p);
        List <Parameter> listOfPar = App.getInstance().getCompany().getParameterStore().getParameterList();
        LabOrder lO = new LabOrder(tt,listOfPar);

        app.domain.model.Test t = new app.domain.model.Test("abcde123456", 1234567890, lO);
    }*/

    /*@Test (expected = IllegalArgumentException.class)
    public void createTestCodeWithLessThan10Chars() throws ClassNotFoundException, InstantiationException, IllegalAccessException {


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

        app.domain.model.Test t = new app.domain.model.Test("abcde", 1234567890, lO);

    }*/

    @Test
    public void creatTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Company c = new Company("Many Labs");
        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        Client client = new Client(1234567890123456L,1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

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

        app.domain.model.Test t = new app.domain.model.Test(c, client, 1234567890, lO);
    }

    /*@Test (expected = IllegalArgumentException.class)
    public void createTestNHSCodeWithLessThan10Chars() throws ClassNotFoundException, InstantiationException, IllegalAccessException {


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

        app.domain.model.Test t = new app.domain.model.Test("abcdefghjk", 1234567, lO);

    }*/
}