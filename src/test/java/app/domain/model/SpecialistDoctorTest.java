package app.domain.model;

import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialistDoctorTest {

    @Test
    public void getDocIndexNumber() {
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, 123456);
        Company c = new Company("Many Labs");
        int docIndexNumber = emp.getDocIndexNumber();

        Assert.assertEquals(docIndexNumber, 123456);
    }

    @Test
    public void testToString() {
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, 123456);
        Company c = new Company("Many Labs");
        String sd = "SpecialistDoctor{docIndexNumber=123456}";

        Assert.assertEquals(sd, emp.toString());
    }

    @Test
    public void testEquals() {
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, 123456);
        SpecialistDoctor emp2 = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, 123456);

        Assert.assertEquals(emp2, emp);
    }

    @Test
    public void testEqualsDifferent() {
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, 123456);
        SpecialistDoctor emp2 = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, 123457);

        Assert.assertNotEquals(emp2, emp);
    }
}