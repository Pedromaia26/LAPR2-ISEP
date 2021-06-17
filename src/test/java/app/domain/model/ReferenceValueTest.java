package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReferenceValueTest {

    @Test
    public void getMetric() {

        ReferenceValue referenceValue=new ReferenceValue(1.0,2.0,"test");

        assertEquals("test",referenceValue.getMetric());

    }

    @Test
    public void getMinimum() {
        ReferenceValue referenceValue=new ReferenceValue(1.0,2.0,"test");

        assertEquals((Double) 1.0,referenceValue.getMinimum());
    }

    @Test
    public void getMaximum() {
        ReferenceValue referenceValue=new ReferenceValue(1.0,2.0,"test");

        assertEquals((Double) 2.0,referenceValue.getMaximum());
    }

    @Test
    public void testToString() {
        ReferenceValue referenceValue=new ReferenceValue(1.0,2.0,"test");



        assertEquals("Minimum=1.0, Maximum=2.0",referenceValue.toString());

    }
}