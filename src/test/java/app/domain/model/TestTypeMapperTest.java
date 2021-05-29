package app.domain.model;

import app.controller.CreateParameterController;
import app.controller.TestTypeController;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTypeMapperTest {

    /* @Test
    public void toDto() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Company c = new Company("Many Labs");
        TestTypeController ttContr = new TestTypeController(c);
        ParameterCategory pc1 = new ParameterCategory("Hemogram", "12345");
        List<ParameterCategory> pcList = new ArrayList<>();
        pcList.add(pc1);

        TestType tt = new TestType("COVID-19", "swab", "adasd", pcList);

        TestTypeStore tList = new TestTypeStore();

        tList.addToList(tt);


        List<TestTypeDTO> ttDtoList = ttContr.getTestTypeDto();

        for (TestTypeDTO ttDto : ttDtoList) {
            String description = ttDto.getDescription();
            String collectingMethod = ttDto.getCollectingMethod();
            String code = ttDto.getCode();

            Assert.assertEquals(description, "COVID-19", description);
        }
    } */
}