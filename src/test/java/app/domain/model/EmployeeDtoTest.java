package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.UserRole;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDtoTest {

    @Test
    public void getUserRole() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String userRole = emp.getUserRole();

        Assert.assertEquals(userRole, "adm");
    }

    @Test
    public void getEmployeeId() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String employeeId = emp.getId();

        Assert.assertEquals(employeeId, "P00001");
    }

    @Test
    public void getName() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String name = emp.getNameDto();

        Assert.assertEquals(name, "Pedro");
    }

    @Test
    public void getAdress() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String address = emp.getAdressDto();

        Assert.assertEquals(address, "Porto");
    }

    @Test
    public void getPhoneNumber() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        long phoneNumer = emp.getPhoneNumberDto();

        Assert.assertEquals(phoneNumer, 91291291212L);
    }

    @Test
    public void getEmail() {
        Email e = new Email("pedro@gmail.com");
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, e, 1234);
        Company c = new Company("Many Labs");
        Email email = emp.getEmailDto();

        Assert.assertEquals(email, e);
    }

    @Test
    public void getSocCode() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        int socCode = emp.getSocCodeDto();

        Assert.assertEquals(socCode, 1234);
    }

    @Test
    public void getDocIndexNumber() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,123456);
        Company c = new Company("Many Labs");
        int socCode = emp.getDocIndexNumberDto();

        Assert.assertEquals(socCode, 123456);
    }
}