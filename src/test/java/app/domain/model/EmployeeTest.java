package app.domain.model;

import app.domain.model.Company;
import app.domain.model.Employee;
import auth.domain.model.Email;
import auth.domain.model.UserRole;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void getUserRole() {
        UserRole usrole = new UserRole("ADM", "adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        UserRole userRole = emp.getUserRole();

        Assert.assertEquals(userRole, usrole);
    }

    @Test
    public void getEmployeeId() {

        UserRole usrole = new UserRole("ADM", "adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String employeeId = emp.getEmployeeId();

        Assert.assertEquals(employeeId, "P00001");
    }

    @Test
    public void getName() {
        UserRole usrole = new UserRole("ADM", "adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String name = emp.getName();

        Assert.assertEquals(name, "Pedro");
    }

    @Test
    public void getAdress() {
        UserRole usrole = new UserRole("ADM", "adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String address = emp.getAdress();

        Assert.assertEquals(address, "Porto");
    }

    @Test
    public void getPhoneNumber() {
        UserRole usrole = new UserRole("ADM", "adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        long phoneNumer = emp.getPhoneNumber();

        Assert.assertEquals(phoneNumer, 91291291212L);
    }

    @Test
    public void getEmail() {
        UserRole usrole = new UserRole("ADM", "adm");
        Email e = new Email("pedro@gmail.com");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, e, 1234);
        Company c = new Company("Many Labs");
        Email email = emp.getEmail();

        Assert.assertEquals(email, e);
    }

    @Test
    public void getSocCode() {
        UserRole usrole = new UserRole("ADM", "adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        int socCode = emp.getSocCode();

        Assert.assertEquals(socCode, 1234);
    }

    @Test
    public void testToString() {
        UserRole usrole = new UserRole("ADM", "adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        String a = emp.toString();

        Assert.assertEquals("Employee{userRole=ADM - adm, employeeId='P00001', name='Pedro', adress='Porto', phoneNumber=91291291212, email=pedro@gmail.com, socCode=1234}", a);
    }
}