package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestStoreTest {

    @Test
    public void getTestByBarcode() throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        Company c= new Company("ManyLabs");
        ParameterCategory pc = new ParameterCategory("hemogram", "09090");
        ParameterCategory pc2 = new ParameterCategory("hemogram23", "09091");
        Client client = new Client("1234567890123456",1234567890L,"12/12/2012","Male",1234567890L,"asd@gmail.com","Moirane",44123456789L);

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        Parameter p1 = new Parameter("8ika1", "bb", "sangue", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);
        param.add(p1);

        c.getParameterCategoryStore().saveParameterCategory(pc);
        c.getParameterCategoryStore().saveParameterCategory(pc2);

        List<Parameter> param2 = new ArrayList<>();

        param2.add(p);


        List<ParameterCategory> listPC = new ArrayList<>();

        ParameterCategory pca = c.getParameterCategoryStore().getParameterCategoryByCode("09090");
        ParameterCategory pca2 = c.getParameterCategoryStore().getParameterCategoryByCode("09091");

        listPC.add(pca);
        listPC.add(pca2);

        List<ParameterCategory> listPC2 = new ArrayList<>();

        ParameterCategory pcb = c.getParameterCategoryStore().getParameterCategoryByCode("09090");

        listPC2.add(pcb);

        TestType tt = new TestType("Covid", "Swab", "12309", listPC);
        TestType tt2 = new TestType("Blood", "syringe", "12389", listPC2);

        List<TestType> ttList = new ArrayList<>();

        ttList.add(tt);
        ttList.add(tt2);

        LabOrder lO = new LabOrder(tt, param);
        LabOrder lO1 = new LabOrder(tt2, param2);


        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, ttList);
        app.domain.model.Test t = new app.domain.model.Test(c, client,"123412341200",lO,l);
        app.domain.model.Test t2 = new app.domain.model.Test(c, client,"123412341200",lO1,l);

        c.getTestStore().addToList(t);
        c.getTestStore().addToList(t2);


        Sample s = new Sample(c);
        t.addSample(s);
        Sample s1 = new Sample(c);
        t2.addSample(s1);


        List<app.domain.model.Test> samples = c.getTestStore().getTests();

        for(app.domain.model.Test loDTO : samples){
            for (Sample sample : loDTO.getSample())
                System.out.println(loDTO);
        }

        app.domain.model.Test a = c.getTestStore().getTestByBarcode("00000000001");
        app.domain.model.Test b = c.getTestStore().getTestByBarcode("00000000002");


        String expected = "Test: labOrder, sample= + sample";

        assertEquals("Covid", t.getLabOrder().getTestType().getDescription());

       // for (Parameter parameter : a.getLabOrder().getParameters()) {
         //   System.out.println(parameter.getShortName());
        // }

       // System.out.println("---------------");

        // for (Parameter parameter : b.getLabOrder().getParameters()){
            // System.out.println(parameter.getShortName());
        // }

        // System.out.println("------------------");

        // System.out.println(a.getTestParameterFor("01981").getShortName());

        // System.out.println("-----------------");

        // System.out.println("TEM QUE DAR ERRO");

        //  System.out.println(b.getTestParameterFor("8ika1").getShortName());
    }
}