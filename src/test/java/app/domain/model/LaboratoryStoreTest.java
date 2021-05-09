package app.domain.model;

import app.domain.model.Company;
import app.domain.model.TestType;
import app.domain.model.Laboratory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LaboratoryStoreTest {

    @Test
    public void createLaboratory() {
        Company c = new Company("Many Labs");

        ParameterCategory pc1= new ParameterCategory("Hemogram",  "11111");


        List<ParameterCategory> listPC = new ArrayList<>();
        c.getParameterCategoryStore().addToList(pc1);
        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");

        listPC.add(pc);

        TestType tt = new TestType("Hemogram", "Swab", "12313", listPC);
        TestType tt1 = new TestType("Immunity", "Tube", "12314", listPC);

        c.getTestTypeStore().addToList(tt);
        c.getTestTypeStore().addToList(tt1);

        List<TestType> listTT = new ArrayList<>();

        TestType tt01 = c.getTestTypeStore().getTestTypeByCode("12313");
        TestType tt02 = c.getTestTypeStore().getTestTypeByCode("12314");

        listTT.add(tt01);
        listTT.add(tt02);

        List<TestType> listTT2 = new ArrayList<>();
        TestType tt03 = c.getTestTypeStore().getTestTypeByCode("12313");
        TestType tt04 = c.getTestTypeStore().getTestTypeByCode("12314");

        listTT2.add(tt03);
        listTT2.add(tt04);

        Laboratory l = new Laboratory("AAMLF", "BloodLab", "Lisbon", 93323546212L, 1234567890L, listTT);
        Laboratory l1 = c.getLaboratoryStore().createLaboratory("AAMLF", "BloodLab", "Lisbon", 93323546212L, 1234567890L, listTT2);

        Assert.assertEquals(tt, tt1);
    }
}