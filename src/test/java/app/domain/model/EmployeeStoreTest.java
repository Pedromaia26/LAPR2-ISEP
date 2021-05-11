package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.UserRole;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeStoreTest {

    @Test
    public void createEmployee() {
        UserRole usrole = new UserRole("ADM", "adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);

        Company comp= new Company("ManyLabs");

        EmployeeDto empDTO = new EmployeeDto(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);

        Employee emp2= comp.getEmployeeStore().createEmployee(empDTO);

        Assert.assertEquals(emp,emp2);
    }

    @Test
    public void validateEmployee() {
        UserRole usrole = new UserRole("ADM", "adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Employee emp2 = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Employee emp3= null;
        Company comp= new Company("ManyLabs");

        boolean test1= comp.getEmployeeStore().validateEmployee(emp);
        boolean test2= comp.getEmployeeStore().validateEmployee(emp3);
        comp.getEmployeeStore().addEmployee(emp);
        boolean test3= comp.getEmployeeStore().validateEmployee(emp2);

        assertTrue(test1);
        assertFalse(test2);
        assertFalse(test3);
    }

    @Test
    public void addEmployee() {
    }

    @Test
    public void getEmployeeList() {
    }

    @Test
    public void saveEmployee() {
    }

    @Test
    public void getSpecialistDoctors() {
    }

    @Test
    public void validateSpecialistDoctor() {
    }

    @Test
    public void createUser() {
    }

    @Test
    public void createSpecialistDoctor() {
    }
}