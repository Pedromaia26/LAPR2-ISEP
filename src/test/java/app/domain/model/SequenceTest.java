package app.domain.model;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import static org.junit.Assert.*;

public class SequenceTest {

    @Test
    public void testToString() throws ParseException {

        Sequence sequence= new Sequence(new Date(2021-1900,5,21),5);
        



        assertEquals("Sequence{date=21/06/2021, number=5}",sequence.toString());

    }

    @Test
    public void getDate() throws ParseException {
        Sequence sequence= new Sequence(new Date(2021-1900,5,21),5);

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");


        assertEquals("21/06/2021",DateFor.format(sequence.getDate()));
    }

    @Test
    public void getNumber() throws ParseException {
        Sequence sequence= new Sequence(new Date(2021-1900,5,21),5);

        assertEquals(5,sequence.getNumber());
    }
}