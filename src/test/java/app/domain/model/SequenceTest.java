package app.domain.model;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class SequenceTest {

    @Test
    public void testToString() throws ParseException {
        Sequence sequence= new Sequence(new Date(2021-1900,5,21),5);

        assertEquals("Sequence{date=Mon Jun 21 00:00:00 BST 2021, number=5}",sequence.toString());

    }

    @Test
    public void getDate() throws ParseException {
        Sequence sequence= new Sequence(new Date(2021-1900,5,21),5);

        assertEquals("Mon Jun 21 00:00:00 BST 2021",sequence.getDate().toString());
    }

    @Test
    public void getNumber() throws ParseException {
        Sequence sequence= new Sequence(new Date(2021-1900,5,21),5);

        assertEquals(5,sequence.getNumber());
    }
}