package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.UserRole;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeMapperTest {

    @Test
    public void toDto() {
        UserRole usrole = new UserRole("ADM", "adm");
        EmployeeDto emp1 = new EmployeeDto(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);
        Company c = new Company("Many Labs");
        Employee emp = new Employee(usrole, "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234);

        UserRole userRole = emp.getUserRole();

        Assert.assertEquals(userRole, usrole);
        Employee emp2= EmployeeStore.createEmployee(emp1);
        assertEquals(emp,emp2);
    }
}