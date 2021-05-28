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
    public void createLaboratory() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Company c = new Company("Many Labs");

        ParameterCategory pc1 = new ParameterCategory("Hemogram",  "11111");

        c.getParameterCategoryStore().addToList(pc1);

        List<ParameterCategory> listPC = new ArrayList<>();

        ParameterCategory pc = c.getParameterCategoryStore().getParameterCategoryByCode("11111");
        listPC.add(pc);

        TestType tt = new TestType("Hemogram", "Swab", "12313", listPC);
        TestType tt1 = new TestType("Immunity", "Tube", "12314", listPC);

        c.getTestTypeStore().addToList(tt);
        c.getTestTypeStore().addToList(tt1);


        TestType tt0 = c.getTestTypeStore().getTestTypeByCode("12314");

        List<TestType> typeTest = new ArrayList<>();
        typeTest.add(tt0);

        Laboratory lb = new Laboratory("adada", "adada", "PortoGaiaPT", 11111111111L, 9999999999L, typeTest);
        Laboratory lb2 = c.getLaboratoryStore().createLaboratory("adada", "adada","PortoGaiaPT", 11111111111L, 9999999999L, typeTest);

        Assert.assertEquals(lb, lb2);

    }
}