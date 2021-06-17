package app.domain.mappers.dto;


import app.domain.model.*;
import app.mappers.dto.LabOrderDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LabOrderDTOTest {

    @Test
    public void testToString() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Company c= new Company("ManyLabs");

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

        LabOrderDTO labOrderDTO=new LabOrderDTO(labOrder);


        String s=labOrderDTO.toString();

        assertEquals("LabOrder: TestTypeCode= 12345, TestTypeCollectionMethod= asd, TestTypeDescription= asd, Parameters= [Short Name: aa; Code: 01981; Description: blood; Parameter Category: Name: hemogram; Code: 09090]",s);
    }
}