package app.domain.mappers;

import app.domain.model.*;
import app.mappers.dto.EmployeeDto;
import auth.domain.model.Email;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeMapperTest {

   /* @Test
    public void toDtoE() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Company c = new Company("Many Labs");
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        c.getLaboratoryStore().saveLaboratory(l);

        Employee emp = new Employee(new OrgRole("Administrator"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, l);

        EmployeeDto emp1 = new EmployeeDto("Administrator", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, "MMOL3");


        c.getOrgRoleStore().addDefaultRoles();
        Employee emp2= c.getEmployeeStore().createEmployee(emp1,c);


        assertEquals(emp, emp2);
    }
*/



    @Test
    public void toDtoSD() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Company c = new Company("Many Labs");
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        c.getLaboratoryStore().saveLaboratory(l);
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, l,123456);
        EmployeeDto emp1 = new EmployeeDto("Specialist Doctor", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, "MMOL3",123456);

        Employee emp2= c.getEmployeeStore().createSpecialistDoctor(emp1, c);

        assertEquals(emp, emp2);
    }


}