package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SampleTest {

    @Test
    public void createBarcode() {
        Sample s = new Sample();

        String a= s.createBarcode();

        assertEquals("00000000001",a);
    }

    @Test
    public void testToString() {
        Sample s = new Sample();

        String a = s.toString();

        assertEquals("barcode number='00000000001'",a);

    }

    @Test
    public void getBarcode() {
        /*ParameterCategory pc = new ParameterCategory("hemogram", "09090");

        Parameter p = new Parameter("01981", "aa", "blood", pc);
        List<Parameter> param = new ArrayList<>();

        param.add(p);

        ParameterCategory pc1 = new ParameterCategory("Immunity", "11111");
        ParameterCategory pc2 = new ParameterCategory("Hemogram", "10019");
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc1);
        App.getInstance().getCompany().getParameterCategoryStore().addToList(pc2);

        List<ParameterCategory> listPC = new ArrayList<>();
        ParameterCategory pca = App.getInstance().getCompany().getParameterCategoryStore().getParameterCategoryByCode("10019");

        listPC.add(pca);
        TestType testesss = new TestType("asd","asd","12345",listPC);

        App.getInstance().getCompany().getTestTypeStore().addToList(testesss);

        LabOrder labOrder= new LabOrder(testesss,param);

        App.getInstance().getCompany().getLabOrderStore().addToList(labOrder);

        app.domain.model.Test nteste=new app.domain.model.Test("1234567890",1234123412L,labOrder);

*/
        Sample s = new Sample();






        assertEquals("00000000001",s.getBarcode());
    }
}