package app.domain.model;

import org.junit.Assert;
import org.junit.Test;


public class ParameterCategoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void createParameterCategoryWithInvalidCode(){
        ParameterCategory pc = new ParameterCategory("Hemogram", "0912345");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createParameterCategoryNameWithMoreThan10CharsInvalidName(){
        ParameterCategory pc = new ParameterCategory("Hemogram/Blood Count", "12345");
    }

    @Test
    public void createParameterCategoryNameWith10Chars() {
        ParameterCategory pc = new ParameterCategory("COVID Test", "12345");
    }


    @Test
    public void getCode() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "0a98h");
        String a = pc.getCode();

        Assert.assertEquals("0a98h", a);
    }

    @Test
    public void getName() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "0a98h");
        String name = pc.getName();

        Assert.assertEquals("Hemogram", name);
    }

    @Test
    public void setName() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "ap190");

        pc.setName("Antibodies");
        String name = pc.getName();

        Assert.assertEquals ("Antibodies", name);
    }

    @Test
    public void setCode() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "ap190");

        pc.setCode("09kkl");
        String code = pc.getCode();

        Assert.assertEquals ("09kkl", code);

    }

    @Test
    public void testToString() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "ap190");
        String a = pc.toString();

        Assert.assertEquals("Name: Hemogram; Code: ap190", a);
    }

    @Test
    public void testEquals() {
        ParameterCategory pc = new ParameterCategory("BloodC", "okjn7");
        ParameterCategory pc1 = new ParameterCategory("BloodC", "okjn7");
        ParameterCategory pc2 = new ParameterCategory("Blood", "okjn7");
        ParameterCategory pc3 = new ParameterCategory("BloodC", "11111");
        ParameterCategory pc4 = new ParameterCategory("Blood", "22111");


        Assert.assertEquals(pc, pc1);
        Assert.assertNotEquals(pc,pc2);
        Assert.assertNotEquals(pc1, pc3);
        Assert.assertNotEquals(pc,pc4);

    }

    @Test
    public void testEqualsDifferentClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Company c = new Company("Many Labs");
        ParameterCategory pc = new ParameterCategory("BloodC", "okjn7");
        c.getParameterCategoryStore().saveParameterCategory(pc);

        TestType tt = new TestType("Covid-19 test", "Swab", "katm1", c.getParameterCategoryStore().getParameterCategories());

        Assert.assertNotEquals(pc, tt);
    }

    @Test
    public void testEqualsNull() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "okjn7");
        ParameterCategory pc1 = null;

        Assert.assertNotEquals(pc, pc1);
    }

}