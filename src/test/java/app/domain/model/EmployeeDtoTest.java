package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.UserRole;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDtoTest {

    @Test
    public void getUserRole() {
        UserRole usrole = new UserRole("ADM", "adm");
        EmployeeDto emp = new EmployeeDto(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        UserRole userRole = emp.getUserRole();

        Assert.assertEquals(userRole, usrole);
    }

    @Test
    public void getEmployeeId() {
        UserRole usrole = new UserRole("ADM", "adm");
        EmployeeDto emp = new EmployeeDto(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String employeeId = emp.getEmployeeId();

        Assert.assertEquals(employeeId, "P00001");
    }

    @Test
    public void getName() {
        UserRole usrole = new UserRole("ADM", "adm");
        EmployeeDto emp = new EmployeeDto(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String name = emp.getName();

        Assert.assertEquals(name, "Pedro");
    }

    @Test
    public void getAdress() {
        UserRole usrole = new UserRole("ADM", "adm");
        EmployeeDto emp = new EmployeeDto(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String address = emp.getAdress();

        Assert.assertEquals(address, "Porto");
    }

    @Test
    public void getPhoneNumber() {
        UserRole usrole = new UserRole("ADM", "adm");
        EmployeeDto emp = new EmployeeDto(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        long phoneNumer = emp.getPhoneNumber();

        Assert.assertEquals(phoneNumer, 91291291212L);
    }

    @Test
    public void getEmail() {
        UserRole usrole = new UserRole("ADM", "adm");
        Email e = new Email("pedro@gmail.com");
        EmployeeDto emp = new EmployeeDto(usrole, "P00001", "Pedro", "Porto", 91291291212L, e, 1234);
        Company c = new Company("Many Labs");
        Email email = emp.getEmail();

        Assert.assertEquals(email, e);
    }

    @Test
    public void getSocCode() {
        UserRole usrole = new UserRole("ADM", "adm");
        EmployeeDto emp = new EmployeeDto(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        int socCode = emp.getSocCode();

        Assert.assertEquals(socCode, 1234);
    }

    @Test
    public void getDocIndexNumber() {
        UserRole usrole = new UserRole("ADM", "adm");
        EmployeeDto emp = new EmployeeDto(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,123456);
        Company c = new Company("Many Labs");
        int socCode = emp.getDocIndexNumber();

        Assert.assertEquals(socCode, 123456);
    }
}