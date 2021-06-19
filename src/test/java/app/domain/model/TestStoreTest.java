package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TestStoreTest {

    @Test
    public void createTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
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

        app.domain.model.Test nteste2= c.getTestStore().createTest(c,client,"123412341200",labOrder,l);

        Assert.assertEquals(nteste, nteste2);






    }

    @Test
    public void testCreateTest() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {
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


        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l,"20/12/2020 20:20");

        app.domain.model.Test nteste2= c.getTestStore().createTest(c,client,"123412341200",labOrder,l,"20/12/2020 20:20");

        Assert.assertEquals(nteste, nteste2);
    }

    @Test
    public void validateTest() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {

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



        boolean test1=c.getTestStore().validateTest(nteste);

        assertTrue(test1);




    }

    @Test
    public void validateTestAlreadyonlist() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {

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



        boolean test1=c.getTestStore().validateTest(nteste);

        assertFalse(test1);






    }


    @Test
    public void validateTestNull() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        Company c= new Company("ManyLabs");

        app.domain.model.Test nteste=null;


        boolean test1=c.getTestStore().validateTest(nteste);

        assertFalse(test1);






    }

    @Test
    public void getTests() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

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

            List<app.domain.model.Test> tests= c.getTestStore().getTests();

            List<app.domain.model.Test> tests1= new ArrayList<>();

            tests1.add(nteste);

            assertEquals(tests1,tests);

    }

    @Test
    public void testGetTestByBarcode() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, ParseException, OutputException, BarcodeException {

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

        app.domain.model.Test test=c.getTestStore().getTestByBarcode("00000000001");

        assertEquals(nteste,test);


    }

    @Test
    public void getTestByCode() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
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

        app.domain.model.Test test= c.getTestStore().getTestByCode("000000000001");

        assertEquals(test,nteste);

    }

    @Test
    public void getTestsByClient() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
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

        List<app.domain.model.Test> tests=c.getTestStore().getTestsByClient(client);

        List<app.domain.model.Test> tests1=new ArrayList<>();
        tests1.add(nteste);

        assertEquals(tests1,tests);


    }

    @Test
    public void testGetTestsByClient() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
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

        List<app.domain.model.Test> tests=c.getTestStore().getTestsByClient(client.getEmail());

        List<app.domain.model.Test> tests1=new ArrayList<>();
        tests1.add(nteste);

        assertEquals(tests1,tests);
    }

    @Test
    public void contNumberofClients() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
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

        List<app.domain.model.Test> tests=c.getTestStore().getTestsByClient(client.getEmail());

       int num= c.getTestStore().contNumberofClients(tests);

       int expected =1;

       assertEquals(expected,num);



    }

    @Test
    public void contNumberofClientsWrong() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
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

        List<app.domain.model.Test> tests=c.getTestStore().getTestsByClient(client.getEmail());

        int num= c.getTestStore().contNumberofClients(tests);

        int expected =-1;

        assertNotEquals(expected,num);



    }

    @Test
    public void contNumberofTestValidated() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
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

        nteste.validateTest();

        c.getTestStore().addToList(nteste);

        List<app.domain.model.Test> tests=c.getTestStore().getTestsByClient(client.getEmail());

        int num= c.getTestStore().contNumberofTestValidated(tests);

        int expected =1;

        assertEquals(expected,num);

    }
    @Test
    public void contNumberofTestValidatedWrong() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
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

        List<app.domain.model.Test> tests=c.getTestStore().getTestsByClient(client.getEmail());

        int num= c.getTestStore().contNumberofTestValidated(tests);

        int expected =1;

        assertNotEquals(expected,num);

    }

    @Test
    public void getTestsInIntervalRegistDate() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
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

        nteste.validateTest("20/05/2021 08:30");

        c.getTestStore().addToList(nteste);


        Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/05/2021 08:00");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("21/05/2021 09:30");

        List<app.domain.model.Test> tests=c.getTestStore().getTestsInInterval(startDate,endDate);

        List<app.domain.model.Test> tests1= new ArrayList<>();

        tests1.add(nteste);

        assertEquals(tests,tests1);


    }

    @Test
    public void getTestsInIntervalRegistDateWrong() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
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

        nteste.validateTest("22/05/2021 08:30");

        c.getTestStore().addToList(nteste);


        Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/05/2021 08:00");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("21/05/2021 09:30");

        List<app.domain.model.Test> tests=c.getTestStore().getTestsInInterval(startDate,endDate);

        List<app.domain.model.Test> tests1= new ArrayList<>();

        tests1.add(nteste);

        assertNotEquals(tests,tests1);


    }

    @Test
    public void getTestsInIntervalRegistDateWrongBefore() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
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

        nteste.validateTest("18/05/2021 08:30");

        c.getTestStore().addToList(nteste);


        Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/05/2021 08:00");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("21/05/2021 09:30");

        List<app.domain.model.Test> tests=c.getTestStore().getTestsInInterval(startDate,endDate);

        List<app.domain.model.Test> tests1= new ArrayList<>();

        tests1.add(nteste);

        assertNotEquals(tests,tests1);


    }

    @Test
    public void getTestsInIntervalRegistDateequalStart() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
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

        nteste.validateTest("19/05/2021 08:00");

        c.getTestStore().addToList(nteste);


        Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/05/2021 08:00");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("21/05/2021 09:30");

        List<app.domain.model.Test> tests=c.getTestStore().getTestsInInterval(startDate,endDate);

        List<app.domain.model.Test> tests1= new ArrayList<>();

        tests1.add(nteste);

        assertEquals(tests,tests1);


    }

    @Test
    public void getTestsInIntervalRegistDateequalEnd() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
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

        nteste.validateTest("21/05/2021 09:30");

        c.getTestStore().addToList(nteste);


        Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/05/2021 08:00");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("21/05/2021 09:30");

        List<app.domain.model.Test> tests=c.getTestStore().getTestsInInterval(startDate,endDate);

        List<app.domain.model.Test> tests1= new ArrayList<>();

        tests1.add(nteste);

        assertEquals(tests,tests1);


    }

    @Test
    public void getTestsInInterval() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {

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


        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l,"20/05/2021 08:30");


        c.getTestStore().addToList(nteste);


        Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/05/2021 08:00");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("21/05/2021 09:30");

        List<app.domain.model.Test> tests=c.getTestStore().getTestsInIntervalRegistDate(startDate,endDate);

        List<app.domain.model.Test> tests1= new ArrayList<>();

        tests1.add(nteste);

        assertEquals(tests,tests1);



    }

    @Test
    public void getTestsInIntervalWrong() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {

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


        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l,"18/05/2021 08:30");


        c.getTestStore().addToList(nteste);


        Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/05/2021 08:00");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("21/05/2021 09:30");

        List<app.domain.model.Test> tests=c.getTestStore().getTestsInIntervalRegistDate(startDate,endDate);

        List<app.domain.model.Test> tests1= new ArrayList<>();

        tests1.add(nteste);

        assertNotEquals(tests,tests1);



    }

    @Test
    public void getTestsInIntervalWrongAfter() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {

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


        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l,"23/05/2021 08:30");


        c.getTestStore().addToList(nteste);


        Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/05/2021 08:00");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("21/05/2021 09:30");

        List<app.domain.model.Test> tests=c.getTestStore().getTestsInIntervalRegistDate(startDate,endDate);

        List<app.domain.model.Test> tests1= new ArrayList<>();

        tests1.add(nteste);

        assertNotEquals(tests,tests1);



    }

    @Test
    public void getTestsInIntervalequalStart() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {

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


        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l,"19/05/2021 08:00");


        c.getTestStore().addToList(nteste);


        Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/05/2021 08:00");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("21/05/2021 09:30");

        List<app.domain.model.Test> tests=c.getTestStore().getTestsInIntervalRegistDate(startDate,endDate);

        List<app.domain.model.Test> tests1= new ArrayList<>();

        tests1.add(nteste);

        assertEquals(tests,tests1);



    }

    @Test
    public void getTestsInIntervalequalEnd() throws ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {

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


        app.domain.model.Test nteste=new app.domain.model.Test(c, client,"123412341200",labOrder,l,"21/05/2021 09:30");


        c.getTestStore().addToList(nteste);


        Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("19/05/2021 08:00");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("21/05/2021 09:30");

        List<app.domain.model.Test> tests=c.getTestStore().getTestsInIntervalRegistDate(startDate,endDate);

        List<app.domain.model.Test> tests1= new ArrayList<>();

        tests1.add(nteste);

        assertEquals(tests,tests1);



    }
}