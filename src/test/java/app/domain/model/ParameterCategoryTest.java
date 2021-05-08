package java.app.domain.model;

import app.domain.model.ParameterCategory;
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


}