package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.UserRole;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeMapperTest {
/*
    @Test
    public void toDtoE() {
        Company c = new Company("Many Labs");
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        Employee emp = new Employee(new OrgRole("adm"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, l);
        EmployeeDto emp1 = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, "MMOL3");

        Employee emp2= c.getEmployeeStore().createEmployee(emp1);
        assertEquals(emp, emp2);
    }

    */

    /*
    @Test
    public void toDtoSD() {
        Company c = new Company("Many Labs");
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, l,123456);
        EmployeeDto emp1 = new EmployeeDto("Specialist Doctor", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, "MMOL3",123456);

        Employee emp2= c.getEmployeeStore().createSpecialistDoctor(emp1);

        assertEquals(emp, emp2);
    }
    */

}