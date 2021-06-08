package app.domain.model;

import app.controller.RegistTestController;
import app.controller.TestTypeController;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
<<<<<<< HEAD
import java.text.ParseException;
=======
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestMapperTest {

    @Test
<<<<<<< HEAD
    public void toDto() throws ClassNotFoundException, InstantiationException, IllegalAccessException, BarcodeException, ParseException, OutputException, IOException {
=======
    public void toDto() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66

        Company c = new Company("Many Labs");
        RegistTestController tContr = new RegistTestController(c);
        ParameterCategory pc1 = new ParameterCategory("Hemogram", "12345");
        List<ParameterCategory> pcList = new ArrayList<>();
        pcList.add(pc1);
        TestType tt = new TestType("Covid-19", "swab", "12345", pcList);
        Parameter p = new Parameter("45678", "hemogl", "hemogl v", pc1);
        List<Parameter> listP = new ArrayList<>();
        Client cli = new Client("1234567890123456", 1234567890L, "22/10/2002", "male", 1234567890L, "bbb@gmail.com",  "jonas", 98765431209L);
        LabOrder l0 = new LabOrder(tt, listP);

        List<TestType> testTypes =new ArrayList<>();
        testTypes.add(tt);

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        app.domain.model.Test test = new app.domain.model.Test(c, cli, "123412341200", l0,l);

        c.getTestStore().addToList(test);


        List<app.domain.model.TestDTO> ttDtoList = tContr.getTestDto();

        for (TestDTO tDto : ttDtoList) {
            String code = tDto.getCode();
            Assert.assertEquals("123456789098l", code);
        }
    }
}