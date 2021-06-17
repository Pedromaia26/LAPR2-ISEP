package app.domain.mappers.dto;

import app.domain.model.Company;
import app.mappers.dto.EmployeeDto;
import auth.domain.model.Email;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

public class EmployeeDtoTest {

    @Test
    public void getUserRole() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,"123123123");
        Company c = new Company("Many Labs");
        String userRole = emp.getUserRole();

        Assert.assertEquals(userRole, "adm");
    }

    @Test
    public void getEmployeeId() throws IllegalAccessException, InstantiationException, ClassNotFoundException, BarcodeException, ParseException, OutputException, IOException {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,"12312312");
        Company c = new Company("Many Labs");
        String employeeId = emp.getId(c);

        Assert.assertEquals(employeeId, "P00001");
    }

    @Test
    public void getName() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,"231231231");
        Company c = new Company("Many Labs");
        String name = emp.getNameDto();

        Assert.assertEquals(name, "Pedro");
    }

    @Test
    public void getAdress() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,"23131231");
        Company c = new Company("Many Labs");
        String address = emp.getAdressDto();

        Assert.assertEquals(address, "Porto");
    }

    @Test
    public void getPhoneNumber() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,"2131231");
        Company c = new Company("Many Labs");
        long phoneNumer = emp.getPhoneNumberDto();

        Assert.assertEquals(phoneNumer, 91291291212L);
    }

    @Test
    public void getEmail() {
        Email e = new Email("pedro@gmail.com");
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, e, 1234,"3123133");
        Company c = new Company("Many Labs");
        Email email = emp.getEmailDto();

        Assert.assertEquals(email, e);
    }

    @Test
    public void getSocCode() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,"2313123");
        Company c = new Company("Many Labs");
        int socCode = emp.getSocCodeDto();

        Assert.assertEquals(socCode, 1234);
    }

    @Test
    public void getDocIndexNumber() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,"231312",123456);
        Company c = new Company("Many Labs");
        int socCode = emp.getDocIndexNumberDto();

        Assert.assertEquals(socCode, 123456);
    }

    @Test
    public void testToString() {
        EmployeeDto emp = new EmployeeDto("adm", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,"3213213123");
        String excepted = "EmployeeDto{orgRole='adm', id='null', name='Pedro', address='Porto', phoneNumber=91291291212, email=pedro@gmail.com, socCode=1234, docIndexNumber=0}";

        Assert.assertEquals(excepted, emp.toString());
    }
}