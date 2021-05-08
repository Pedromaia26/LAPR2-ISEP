package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterCategoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void createParameterCategoryWithInvalidCode(){
        ParameterCategory pc = new ParameterCategory("Hemogram", "0912345");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createParameterCategoryWithInvalidName(){
        ParameterCategory pc = new ParameterCategory("Hemogram/Blood Count", "12345");
    }
    @Test(expected = IllegalArgumentException.class)
    public void createParameterCategoryWith10Chars() {
        ParameterCategory pc = new ParameterCategory("Blood Count", "12345");
    }


    @Test
    public void getCode() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "0a98h");
        Company c = new Company("Many Labs");
        String a = pc.getCode();

        Assert.assertEquals("0a98h", a);
    }

    @Test
    public void getName() {
        ParameterCategory pc = new ParameterCategory("Hemogram", "0a98h");
        Company c = new Company("Many Labs");
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
}