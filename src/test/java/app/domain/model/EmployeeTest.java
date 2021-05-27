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
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String userRole = emp.getUserRole();

        Assert.assertEquals(userRole, usrole.getDesignation());
    }

    @Test
    public void getEmployeeId() {

        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String employeeId = emp.getEmployeeId();

        Assert.assertEquals(employeeId, "P00001");
    }

    @Test
    public void getName() {
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String name = emp.getName();

        Assert.assertEquals(name, "Pedro");
    }

    @Test
    public void getAdress() {
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        String address = emp.getAdress();

        Assert.assertEquals(address, "Porto");
    }

    @Test
    public void getPhoneNumber() {
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        long phoneNumer = emp.getPhoneNumber();

        Assert.assertEquals(phoneNumer, 91291291212L);
    }

    @Test
    public void getEmail() {
        OrgRole usrole = new OrgRole("adm");
        Email e = new Email("pedro@gmail.com");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, e, 1234);
        Company c = new Company("Many Labs");
        Email email = emp.getEmail();

        Assert.assertEquals(email, e);
    }

    @Test
    public void getSocCode() {
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        int socCode = emp.getSocCode();

        Assert.assertEquals(socCode, 1234);
    }

    @Test(expected = IllegalArgumentException.class)
    public void EmployeeCheckNameRules() {
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "NameNameNameNameNameNameNameNameName", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);

    }

    @Test(expected = IllegalArgumentException.class)
    public void EmployeeCheckAddressRules() {
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "", 91291291212L, new Email("pedro@gmail.com"), 1234);

    }

    @Test(expected = IllegalArgumentException.class)
    public void EmployeeCheckPhoneNumberRules() {
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 9129129121L, new Email("pedro@gmail.com"), 1234);

    }

    @Test(expected = IllegalArgumentException.class)
    public void EmployeeCheckSocCodeRules() {
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 12345);

    }

    @Test
    public void testToString() {
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        String a = emp.toString();

        Assert.assertEquals("Employee{userRole=adm, employeeId='P00001', name='Pedro', adress='Porto', phoneNumber=91291291212, email=pedro@gmail.com, socCode=1234}", a);
    }

    @Test
    public void testEquals() {
        OrgRole usrole = new OrgRole("adm");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Employee emp1 = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Employee emp2 = new Employee(usrole, "P00002", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Employee emp3 = new Employee(usrole, "P00001", "Pedros", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Employee emp4 = new Employee(usrole, "P00001", "Pedro", "Portos", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Employee emp5 = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291213L, new Email("pedro@gmail.com"), 1234);
        Employee emp6 = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedross@gmail.com"), 1234);
        Employee emp7 = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1243);
        Employee emp8 = new Employee(usrole, "P00002", "Pedros", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Employee emp9 = new Employee(usrole, "P00002", "Pedros", "Portos", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Employee emp10 = new Employee(usrole, "P00002", "Pedros", "Portos", 91291291213L, new Email("pedro@gmail.com"), 1234);
        Employee emp11 = new Employee(usrole, "P00002", "Pedros", "Portos", 91291291213L, new Email("pedross@gmail.com"), 1234);
        Employee emp12 = new Employee(usrole, "P00002", "Pedros", "Portos", 91291291213L, new Email("pedross@gmail.com"), 1243);

        Employee emp13 = null;

        Assert.assertNotEquals(emp,emp2);
        Assert.assertNotEquals(emp,emp3);
        Assert.assertNotEquals(emp,emp4);
        Assert.assertNotEquals(emp,emp5);
        Assert.assertNotEquals(emp,emp6);
        Assert.assertNotEquals(emp,emp7);
        Assert.assertNotEquals(emp,emp8);
        Assert.assertEquals(emp,emp1);
        Assert.assertNotEquals(emp,emp9);
        Assert.assertNotEquals(emp,emp10);
        Assert.assertEquals(emp,emp);
        Assert.assertNotEquals(emp,emp11);
        Assert.assertNotEquals(emp,emp12);
        Assert.assertNotEquals(emp,emp13);
    }
}