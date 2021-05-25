package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SampleDTOTest {

    @Test
    public void getOrderid() {
        SampleDTO sampleDTO= new SampleDTO("1234567890");

        String s=sampleDTO.getOrderid();

        assertEquals("1234567890",s);
    }
}