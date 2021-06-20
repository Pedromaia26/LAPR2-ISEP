package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LinearRegressionTest {

    @Test
    public void intercept() {

        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.intercept();
        double expected = -0.3581081081081079;


        assertEquals(expected, actual,0);

    }

    @Test
    public void intercept2() {

        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.intercept();
        double expected = -0.3581081081081119;


        assertNotEquals(expected, actual,0);

    }

    @Test
    public void slope() {

        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.slope();
        double expected = 0.8851351351351351;

        assertEquals(expected, actual,0);

    }

    @Test
    public void slope2() {

        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.slope();
        double expected = 0.8451351351351351;

        assertNotEquals(expected, actual,0);

    }

    @Test
    public void r2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.R2();
        double expected = 0.936991536991537;

        assertEquals(actual, expected, 0);
    }

    @Test
    public void r2_2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.R2();
        double expected = 0.945991536991537;

        assertNotEquals(actual, expected, 0);
    }

    @Test
    public void r2Adjusted() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.R2Adjusted();
        double expected = 0.9264901264901265;

        assertEquals(expected, actual, 0);

    }

    @Test
    public void r2Adjusted2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.R2Adjusted();
        double expected = 0.9235901264901265;

        assertNotEquals(expected, actual, 0);

    }

    @Test
    public void interceptStdErr() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.interceptStdErr();
        double expected = 0.5089517029050438;

        assertEquals(expected, actual, 0);
    }

    @Test
    public void interceptStdErr2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.interceptStdErr();
        double expected = 0.5089517029050448;

        assertNotEquals(expected, actual, 0);
    }



    @Test
    public void slopeStdErr() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.slopeStdErr();
        double expected = 0.09370560388610231;

        assertEquals(expected, actual, 0);

    }

    @Test
    public void slopeStdErr2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.slopeStdErr();
        double expected = 0.09370560388611231;

        assertNotEquals(expected, actual, 0);

    }

    @Test
    public void predict() {

        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.predict(arrayX[3]);
        double expected = 4.0675675675675675;

        assertEquals(expected, actual, 0);


    }

    @Test
    public void predict2() {

        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.predict(arrayX[5]);
        double expected = 4.0675675675675675;

        assertNotEquals(expected, actual, 0);


    }

    @Test
    public void testToString() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        String actual = lR.toString();
        String expected = "0.89 n + -0.36  (R^2 = 0.937)";

        assertEquals(actual.replace(",", "."), expected.replace(",", "."));
    }

    @Test
    public void testToString2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        String actual = lR.toString();
        String expected = "0,79 n + -0,35  (R^2 = 0,837)";

        assertNotEquals(actual, expected);
    }

    @Test
    public void getSvar() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.getSvar();
        double expected = 0.6497747747747745;
        assertEquals(expected, actual, 0);

    }

    @Test
    public void getSvar2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.getSvar();
        double expected = 0.6497747746647745;
        assertNotEquals(expected, actual, 0);

    }


    @Test
    public void obs() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double significanceLevel = 0.05;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.obs(significanceLevel);
        double expected = 0.975;

        assertEquals(expected, actual, 0);
    }


    @Test
    public void obs2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double significanceLevel = 0.10;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.obs(significanceLevel);
        double expected = 0.975;

        assertNotEquals(expected, actual, 0);
    }
    @Test
    public void s2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.S2();
        double expected = 0.6497747747747744;

        assertEquals(expected, actual, 0);

    }

    public void s22() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.S2();
        double expected = 0.6597747747747744;

        assertNotEquals(expected, actual, 0);

    }
    @Test
    public void tb() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.Tb();
        double expected = 9.445914635062838;

        assertEquals(expected, actual, 0);
    }
    @Test
    public void tb2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.Tb();
        double expected = 9.555914635062838;

        assertNotEquals(expected, actual, 0);
    }


    @Test
    public void decision() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double significanceLevel = 0.05;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        String actual = lR.decision(significanceLevel, lR.Tb());
        String expected = "Reject HO";

        assertEquals(expected, actual);

    }

    @Test
    public void decision2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double significanceLevel = 0.05;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        String actual = lR.decision(significanceLevel, lR.Tb());
        String expected = "No Reject HO";

        assertNotEquals(expected, actual);

    }

    @Test
    public void decision3(){
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 88.0, 3.0, 3.0, 0.0, 2.0};
        double significanceLevel = 0.05;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        System.out.println(lR.decision(significanceLevel, lR.Tb()));
        String actual = lR.decision(significanceLevel, lR.Tb());
        String expected = "Reject HO";

        assertNotEquals(actual, expected);

    }
    @Test
    public void decision4() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 88.0, 3.0, 3.0, 0.0, 2.0};
        double significanceLevel = 0.05;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        String actual = lR.decision(significanceLevel, lR.Tb());
        String expected = "No reject H0";

        assertEquals(expected, actual);

    }

    @Test
    public void getssr() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.getssr();
        double expected = 57.976351351351354;

        assertEquals(expected, actual, 0);

    }

    @Test
    public void getssr2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.getssr();
        double expected = 45.976351351351354;

        assertNotEquals(expected, actual, 0);

    }

    @Test
    public void getRss() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.getRss();
        double expected = 3.898648648648647;

        assertEquals(expected, actual, 0);
    }
    @Test
    public void getRss2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.getRss();
        double expected = 3.798648648648647;

        assertNotEquals(expected, actual, 0);


    }
    @Test
    public void getDegressOfFreedom() {

        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        int actual = lR.getDegressOfFreedom();
        int expected = 6;

        assertEquals(expected, actual, 0);

    }
    @Test
    public void getDegressOfFreedom2() {

        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        int actual = lR.getDegressOfFreedom();
        int expected = 8;

        assertNotEquals(expected, actual, 0);

    }
    @Test
    public void getConfidenceIntervals() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double confidenceLevel = 0.95;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        List<String> actual = lR.confidenceInterval(arrayX, confidenceLevel);
        String a = "4.3352 - 5.5702\n";
        String b = "8.7609 - 9.9959\n";
        String c = "2.5649 - 3.7999\n";
        String d = "3.4501 - 4.6851\n";
        String e = "3.4501 - 4.6851\n";
        String f = "1.6798 - 2.9148\n";
        String g = "-0.9756 - 0.2594\n";
        String h = "0.7947 - 2.0296\n";
        List<String> expected = new ArrayList<>();
        expected.add(a);
        expected.add(b);
        expected.add(c);
        expected.add(d);
        expected.add(e);
        expected.add(f);
        expected.add(g);
        expected.add(h);

        String actual2 = lR.getConfidenceIntervals();

        assertEquals(expected.toString().replace(",", "."), actual2.replace(",", "."));






    }

    @Test
    public void getConfidenceIntervals2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double confidenceLevel = 0.95;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        List<String> actual = lR.confidenceInterval(arrayX, confidenceLevel);
        String a = "4,3352 - 5,5702\n";
        String b = "8,7609 - 9,9959\n";
        String c = "2,5649 - 3,7999\n";
        String d = "3,4501 - 4,6851\n";
        String e = "3,4501 - 4,6851\n";
        String f = "1,6798 - 2,9148\n";
        String g = "-0,9756 - 0,2594\n";
        String h = "0,7947 - 2,0296\n";
        List<String> expected = new ArrayList<>();
        expected.add(a);
        expected.add(b);
        expected.add(c);
        expected.add(d);
        expected.add(e);
        expected.add(f);
        expected.add(g);


        String actual2 = lR.getConfidenceIntervals();

        assertNotEquals(expected.toString(), actual2);

    }

    @Test
    public void getTStudent() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double confidenceLevel = 0.95;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.getTStudent(confidenceLevel);
        double expected = 1.9431802805661913;

        assertEquals(expected, actual, 0);
    }

    @Test
    public void getTStudent2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double confidenceLevel = 0.95;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.getTStudent(confidenceLevel);
        double expected = 2.9431802805661913;

        assertNotEquals(expected, actual, 0);
    }

    @Test
    public void confidenceInterval() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double confidenceLevel = 0.95;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        List<String> actual = lR.confidenceInterval(arrayX, confidenceLevel);
        String a = "4.3352 - 5.5702\n";
        String b = "8.7609 - 9.9959";
        List<String> expected = new ArrayList<>();
        expected.add(a);
        expected.add(b);
        assertEquals(expected.get(0).replace(",", "."), actual.get(0).replace(",", "."));
    }

    @Test
    public void confidenceInterval2() {
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double confidenceLevel = 0.95;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        List<String> actual = lR.confidenceInterval(arrayX, confidenceLevel);
        String a = "4,3352 - 5,5702\n";
        String b = "8,7609 - 9,9959\n";
        List<String> expected = new ArrayList<>();
        expected.add(a);
        expected.add(b);

        assertNotEquals(expected.get(0), actual.get(1));
    }

    @Test
    public void ta(){
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double confidenceLevel = 0.95;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.Ta();
        double expected = -1.0306168562850109;
        assertEquals(actual, expected, 0);
    }

    @Test
    public void taNotEquals(){
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        double confidenceLevel = 0.95;
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.Ta();
        double expected = 89.24186;
        assertNotEquals(actual, expected, 0);
    }

    @Test
    public void getFDistribution(){
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.getFDistribution(0.95);
        double expected = 0.004273760000676983;

        assertEquals(expected, actual, 0);
    }

    @Test
    public void getFDistributionNotEquals(){
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        double actual = lR.getFDistribution(0.95);
        double expected = 7.254651;

        assertNotEquals(expected, actual, 0);
    }

    @Test
    public void decisionAnova(){
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        String actual = lR.decisionAnova(0.95);
        String expected = "Reject HO\nThe regression model is significant.";

        assertEquals(actual, expected);
    }


    @Test
    public void decisionAnova2(){
        double[] arrayX = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 88.0, 3.0, 3.0, 0.0, 2.0};
        SimpleLinearRegression lR = new SimpleLinearRegression(arrayX, arrayY);
        String actual = lR.decisionAnova(0.95);
        String expected = "Reject HO";

        assertNotEquals(actual, expected);
    }
}