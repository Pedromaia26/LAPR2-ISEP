package app.domain.model;

import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeStoreTest {

    /*@Test
    public void createEmployee() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l);

        Company comp= new Company("ManyLabs");

        EmployeeDto empDTO = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,"MMOL3");

        Employee emp2= comp.getEmployeeStore().createEmployee(empDTO);

        Assert.assertEquals(emp,emp2);
    }
*/
    @Test
    public void validateEmployee() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l);
        Company comp= new Company("ManyLabs");

        boolean test1= comp.getEmployeeStore().validateEmployee(emp);

        assertTrue(test1);
    }

    @Test
    public void validateEmployeeNull() {
        Employee emp= null;
        Company comp= new Company("ManyLabs");
        boolean test1= comp.getEmployeeStore().validateEmployee(emp);
        assertFalse(test1);
    }

    @Test
    public void validateEmployeeContains() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l);
        Employee emp2 = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l);
        Company comp= new Company("ManyLabs");
        comp.getEmployeeStore().validateEmployee(emp);
        comp.getEmployeeStore().addEmployee(emp);
        boolean test3 = comp.getEmployeeStore().validateEmployee(emp2);

        assertFalse(test3);
    }

    @Test
    public void addEmployee() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l);
        Company comp= new Company("ManyLabs");
        boolean test1 = comp.getEmployeeStore().addEmployee(emp);

        assertTrue(test1);
    }

    @Test
    public void addEmployeeNull() {
        Employee emp= null;
        Company comp= new Company("ManyLabs");
        boolean test1= comp.getEmployeeStore().addEmployee(emp);

        assertFalse(test1);
    }

    @Test
    public void getEmployeeList() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l);
        Company comp= new Company("ManyLabs");
        comp.getEmployeeStore().addEmployee(emp);
        List<Employee> list = new ArrayList<>();
        list.add(emp);

        Assert.assertEquals(list, comp.getEmployeeStore().getEmployeeList());
    }

    @Test
    public void getSpecialistDoctors() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("Specialist Doctor");
        SpecialistDoctor emp = new SpecialistDoctor(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);
        Company comp= new Company("ManyLabs");
        comp.getEmployeeStore().addSpecialistDoctor(emp);
        List<SpecialistDoctor> list = new ArrayList<>();

        list.add(emp);

        Assert.assertEquals(list, comp.getEmployeeStore().getSpecialistDoctors());
    }

    @Test
    public void validateSpecialistDoctor() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("Specialist Doctor");
        SpecialistDoctor emp = new SpecialistDoctor(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);
        Company comp= new Company("ManyLabs");

        boolean test1= comp.getEmployeeStore().validateSpecialistDoctor(emp);

        assertTrue(test1);
    }

    @Test
    public void validateSpecialistDoctorNull() {
        SpecialistDoctor emp = null;
        Company comp= new Company("ManyLabs");
        boolean test1 = comp.getEmployeeStore().validateSpecialistDoctor(emp);

        assertFalse(test1);
    }

    @Test
    public void validateSpecialistDoctorContains() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("Specialist Doctor");
        SpecialistDoctor emp = new SpecialistDoctor(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);
        SpecialistDoctor emp2 = new SpecialistDoctor(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);
        Company comp= new Company("ManyLabs");
        comp.getEmployeeStore().validateSpecialistDoctor(emp);
        comp.getEmployeeStore().addSpecialistDoctor(emp);
        boolean test3 = comp.getEmployeeStore().validateSpecialistDoctor(emp2);

        assertFalse(test3);
    }

    /*@Test
    public void createSpecialistDoctor() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("Specialist Doctor");
        SpecialistDoctor emp = new SpecialistDoctor(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);

        Company comp= new Company("ManyLabs");

        EmployeeDto empDTO = new EmployeeDto("Specialist Doctor", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,"MMOL3", 123456);

        SpecialistDoctor emp2= comp.getEmployeeStore().createSpecialistDoctor(empDTO);

        Assert.assertEquals(emp,emp2);
    }*/

    @Test
    public void addSpecialistDoctor() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("Specialist Doctor");
        SpecialistDoctor emp = new SpecialistDoctor(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, l,123456);
        Company comp= new Company("ManyLabs");
        boolean test1 = comp.getEmployeeStore().addSpecialistDoctor(emp);

        assertTrue(test1);
    }

    @Test
    public void addSpecialistDoctorNull() {
        SpecialistDoctor emp = null;
        Company comp= new Company("ManyLabs");
        boolean test1= comp.getEmployeeStore().addSpecialistDoctor(emp);

        assertFalse(test1);
    }

    @Test
    public void createUser() {
    }

    @Test
    public void saveEmployee() {
    }

    @Test
    public void notExists() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l);
        Company comp= new Company("ManyLabs");
        boolean test1 = comp.getEmployeeStore().exists(String.valueOf(emp.getEmail()));

        Assert.assertFalse(test1);
    }

    @Test
    public void exists() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l);
        Company comp= new Company("ManyLabs");
        comp.getEmployeeStore().addEmployee(emp);
        boolean test1 = comp.getEmployeeStore().exists(String.valueOf(emp.getEmail()));

        Assert.assertTrue(test1);
    }
}