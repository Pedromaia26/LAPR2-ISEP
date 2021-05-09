package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LaboratoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void createLaboratoryNameWithMoreThan20chars() {

        Company c = new Company("Many Labs");

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        TestType tt1 = new TestType("Immunity", "11111", "11111", listPC);
        c.getTestTypeStore().addToList(tt1);

        List<TestType> ttPC = new ArrayList<>();
        TestType tt = c.getTestTypeStore().getTestTypeByCode("11111");

        ttPC.add(tt);

        Laboratory l = new Laboratory("A4RLD", "UniversityExeterLaboratory", "Manchester", 11111111111L, 9811111111L, ttPC);
    }

    @Test
    public void createLaboratoryAdressWithMoreThan20chars() {

        Company c = new Company("Many Labs");

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        TestType tt1 = new TestType("Immunity", "Swab", "12222", listPC);
        c.getTestTypeStore().addToList(tt1);

        List<TestType> ttPC = new ArrayList<>();
        TestType tt = c.getTestTypeStore().getTestTypeByCode("11111");

        ttPC.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, ttPC);
    }



    @Test
    public void createLaboratoryIDWithMoreThan5alphanumeric() {

        Company c = new Company("Many Labs");

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        TestType tt1 = new TestType("Immunity", "Swab", "56555", listPC);
        TestType tt2 = new TestType("Blood", "Tube", "23131", listPC);
        c.getTestTypeStore().addToList(tt1);
        c.getTestTypeStore().addToList(tt2);

        List<TestType> ttPC = new ArrayList<>();
        TestType tt = c.getTestTypeStore().getTestTypeByCode("11111");

        ttPC.add(tt);

        Laboratory l = new Laboratory("44YORP", "Aqualab", "Manchester", 11111111111L, 9811111111L, ttPC);

    }

    @Test
    public void createLaboratorytinNumberWithNot10numbers() {
        Company c = new Company("Many Labs");

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        TestType tt1 = new TestType("Immunity", "Swab", "56555", listPC);
        TestType tt2 = new TestType("Blood", "Tube", "23131", listPC);
        c.getTestTypeStore().addToList(tt1);
        c.getTestTypeStore().addToList(tt2);

        List<TestType> ttPC = new ArrayList<>();
        TestType tt = c.getTestTypeStore().getTestTypeByCode("11111");

        ttPC.add(tt);

        Laboratory l = new Laboratory("ZZLMR", "Vulab", "Manchester", 93323546277L, 9930230123451L, ttPC);
    }

    @Test
    public void createLaboratoryPhoneNumberWithNot10Numbers() {

        Company c = new Company("Many Labs");

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        TestType tt1 = new TestType("Immunity", "Swab", "56555", listPC);
        TestType tt2 = new TestType("Blood", "Tube", "23131", listPC);
        c.getTestTypeStore().addToList(tt1);
        c.getTestTypeStore().addToList(tt2);

        List<TestType> ttPC = new ArrayList<>();
        TestType tt = c.getTestTypeStore().getTestTypeByCode("11111");

        ttPC.add(tt);

        Laboratory l = new Laboratory("FFGH4", "Zoolab", "London", 293019203L, 1239402930L, ttPC);
    }

    @Test
    public void testToString() {

        Company c = new Company("Many Labs");

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        TestType tt1 = new TestType("Immunity", "Swab", "56555", listPC);
        c.getTestTypeStore().addToList(tt1);

        List<TestType> ttPC = new ArrayList<>();
        TestType tt = c.getTestTypeStore().getTestTypeByCode("11111");

        ttPC.add(tt);

        Laboratory l = new Laboratory("ZOOPL", "Citylab", "Porto", 93323546212L, 1234567890L, ttPC);

        Assert.assertEquals("LaboratoryID: ZOOPL\nName: Citylab\nAddress: Porto\nPhone Number: 93323546212\nTax Identification Number: 1234567890\nTest Type(s)\n[Description: Immunity; Collecting Method: Swab; Code: 56555; Parameter Category: Sea]", l.toString());
    }
}