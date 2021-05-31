package app.domain.model;

import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SpecialistDoctorTest {

    @Test
    public void getDocIndexNumber() {
        List<TestType> testTypes =new ArrayList<>();

        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);
        Company c = new Company("Many Labs");
        int docIndexNumber = emp.getDocIndexNumber();

        Assert.assertEquals(docIndexNumber, 123456);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SpecialistDoctorCheckdocIndexNumberRules() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        SpecialistDoctor sd = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 1234567);
    }

    @Test
    public void testToString() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);
        Company c = new Company("Many Labs");
        String sd = "SpecialistDoctor{docIndexNumber=123456}";

        Assert.assertEquals(sd, emp.toString());
    }

    @Test
    public void testEquals() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);
        SpecialistDoctor emp2 = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);

        Assert.assertEquals(emp2, emp);
    }

    @Test
    public void testEqualsSameObject() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, l,123456);

        Assert.assertEquals(emp, emp);
    }

    @Test
    public void testEqualsNullObject() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);
        SpecialistDoctor emp2 = null;

        Assert.assertNotEquals(emp, emp2);
    }

    @Test
    public void testEqualsDifferentClasses() {

        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);

        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);
        Employee emp2 = new Employee(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l);

        Assert.assertNotEquals(emp, emp2);
    }

    @Test
    public void testEqualsDifferent() {
        List<TestType> testTypes =new ArrayList<>();
        Laboratory l = new Laboratory("MMOL3", "Sonar", "Manchester United Kingdom", 22222222222L, 3123123435L, testTypes);
        SpecialistDoctor emp = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234,l, 123456);
        SpecialistDoctor emp2 = new SpecialistDoctor(new OrgRole("Specialist Doctor"), "P00001", "Pedro", "Porto", 91291291212L, new Email("pedro@gmail.com"), 1234, l,123457);

        Assert.assertNotEquals(emp2, emp);
    }
}