package app.domain.model;

import app.domain.model.Client;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void soma() {
        int a=3;
        int b=2;

        int resultado = 5;
        int resultado2= Client.soma(a,b);

        Assert.assertEquals(resultado,resultado2);
    }

    @Test
    public void testSoma() {
    }

    @Test
    public void setPassword() {
    }

    @Test
    public void testToString() {
    }
}