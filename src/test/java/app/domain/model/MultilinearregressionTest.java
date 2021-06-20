package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MultilinearregressionTest {

    @Test
    public void matrixXXT() {
    }

    @Test
    public void invert() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double[][] arr1 = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] expected = {{-1.9999999999999998, 1.0}, {1.4999999999999998, -0.49999999999999994}};
        double[][] actual = regression.invert(arr1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void invertNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double[][] arr1 = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] expected = {{-2.0, 1.0}, {1.4999999999999998, -0.49999999999999994}};
        double[][] actual = regression.invert(arr1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void gaussian() {
    }

    @Test
    public void sqr() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.sqr();
        double expected = 60.983857103562;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void sqrNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.sqr();
        double expected = 74.65464654;
        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test
    public void sqe() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.sqe();
        double expected = 0.8911428964379979;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void sqeNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.sqe();
        double expected = 0.31465465;
        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test
    public void rQuadrado() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.r2();
        double expected = 0.9855976905626183;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void rQuadradoNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.r2();
        double expected = 0.235544;
        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test
    public void rQuadradoAjustado() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.r2Adjusted();
        double expected = 0.9798367667876655;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void rQuadradoAjustadoNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.r2Adjusted();
        double expected = 0.9876454;
        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test
    public void standardDeviation() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.standardDeviation();
        double expected = 0.17822857928759958;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void standardDeviationNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.standardDeviation();
        double expected = 0.9456654654;
        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test
    public void obs() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.obs(0.95);
        double expected = 0.525;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void obsNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.obs(0.95);
        double expected = 0.956;
        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test
    public void tStudent() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.tStudent(0.95);
        double expected = 0.06591485539302046;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void tStudentNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.tStudent(0.95);
        double expected = 0.965555;
        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test
    public void testToString() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        String actual = regression.toString();
        String expected = "The regression model fitted using data from the interval: \n" +
                "y = 0,83 + 0,96x1 + -0,25x2";
        assertEquals(expected.toString().replace(",", "."), actual.toString().replace(",", "."));
    }

    @Test
    public void testToStringNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        String actual = regression.toString();
        String expected = "The regression modell fitted using data from the interval: \n" +
                "y = 0,83 + 0,98x1 + -0,25x2";
        assertNotEquals(expected.toString().replace(",", "."), actual.toString().replace(",", "."));
    }

    @Test
    public void multiplyTwoArraysBi() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double[][] arr1 = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] arr2 = {{6.0, 7.0}, {2.0, 6.0}};
        double[][] expected = {{10.0, 19.0}, {26.0, 45.0}};
        double[][] actual = regression.multiplyTwoArraysBi(arr1, arr2);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void multiplyTwoArraysBiNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double[][] arr1 = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] arr2 = {{6.0, 7.0}, {2.0, 6.0}};
        double[][] expected = {{20.0, 19.0}, {26.0, 45.0}};
        double[][] actual = regression.multiplyTwoArraysBi(arr1, arr2);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void multiplyBiArrayWithArray() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double[][] arr1 = {{1.0, 2.0}, {3.0, 4.0}};
        double[] arr2 = {1.0, 2.0};
        double[] expected = {5.0, 11.0};
        double[] actual = regression.multiplyBiArrayWithArray(arr1, arr2);

        Assert.assertArrayEquals(new double[][]{actual}, new double[][]{expected});

    }

    @Test
    public void multiplyBiArrayWithArrayNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double[][] arr1 = {{1.0, 2.0}, {3.0, 4.0}};
        double[] arr2 = {1.0, 2.0};
        double[] expected = {10.0, 11.0};
        double[] actual = regression.multiplyBiArrayWithArray(arr1, arr2);

        Assert.assertNotEquals(new double[][]{actual}, new double[][]{expected});

    }


    @Test
    public void confidenceInterval() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        List<String> actual = regression.confidenceInterval(arrayX1,arrayX2, arrayY, 0.95);
        List<String> expected = new ArrayList<>();
        expected.add("3,6756 - 6,0125\n");
        expected.add("8,6357 - 11,6123\n");
        expected.add("1,1911 - 3,6792\n");
        expected.add("2,3125 - 4,7193\n");
        expected.add("2,0119 - 4,5250\n");
        expected.add("1,2964 - 3,6392\n");
        expected.add("-1,2223 - 1,4055\n");
        expected.add("0,9487 - 3,5574\n");
        assertEquals(expected.toString().replace(",", "."), actual.toString().replace(",", "."));
    }

    @Test
    public void confidenceIntervalNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        List<String> actual = regression.confidenceInterval(arrayX1,arrayX2, arrayY, 0.95);
        List<String> expected = new ArrayList<>();
        expected.add("3,6756 - 6,0125\n");
        expected.add("8,6357 - 11,6123\n");
        expected.add("1,1911 - 3,6792\n");
        expected.add("2,8525 - 4,7193\n");
        expected.add("2,0119 - 4,5250\n");
        expected.add("1,2964 - 3,6392\n");
        expected.add("-1,2223 - 1,4055\n");
        expected.add("0,9487 - 3,5574\n");
        assertNotEquals(expected.toString().replace(",", "."), actual.toString().replace(",", "."));
    }

    @Test
    public void mqr() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.mqr();
        double expected = 30.491928551781;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void mqrNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.mqr();
        double expected = 50.8645;
        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test
    public void mqe() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.mqe();
        double expected = 0.17822857928759958;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void mqeNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.mqe();
        double expected = 0.895;
        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test
    public void testStatsF() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.testStatsF();
        double expected = 171.08327224321036;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void testStatsFNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.testStatsF();
        double expected = 71.083;
        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test
    public void fDistribution() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.fDistribution(0.95);
        double expected = 0.05182311207284776;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void fDistributionNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.fDistribution(0.95);
        double expected = 0.5412;
        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test
    public void decision() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        String actual = regression.decision(0.95);
        String expected = "Reject H0\nThe regression model is significant.";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void decisionNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        String actual = regression.decision(0.95);
        String expected = "\"No reject H0\\nThe regression model is not significant.\"";
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void decisionReject() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 888.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        String actual = regression.decision(0.2);
        String expected = "No reject H0\nThe regression model is not significant.";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void decisionRejectNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 888.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        String actual = regression.decision(0.001);
        String expected = "Reject H0\nThe regression model is significant.";
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void decisionHypothesisTests() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 888.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        String actual = regression.decisionHypothesisTests(0.95, 1);
        String expected = "No reject H0";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void decisionHypothesisTestsReject() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        String actual = regression.decisionHypothesisTests(0.95, 1);
        String expected = "Reject H0";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void decisionHypothesisTestsRejectNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 888.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        String actual = regression.decisionHypothesisTests(0.95, 1);
        String expected = "Reject H0";
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void decisionHypothesisTestsNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        String actual = regression.decisionHypothesisTests(0.95, 1);
        String expected = "No reject H0";
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void tb() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.Tb(1);
        double expected = 5.721462760250377;
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void tbNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double actual = regression.Tb(1);
        double expected = 7.0;
        Assert.assertNotEquals(expected, actual, 0);
    }

    @Test
    public void getDegreesOfFreedom() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        int expected = 5;
        int actual = regression.getDegreesOfFreedom();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDegreesOfFreedomNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        int expected = 6;
        int actual = regression.getDegreesOfFreedom();
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void predict() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double x1 = 1;
        double x2 = 2;
        double actual = regression.predict(x1, x2);
        double expected = 1.2960390592765776;

        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void predictNotEquals() {
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
        double x1 = 1;
        double x2 = 2;
        double actual = regression.predict(x1, x2);
        double expected = 2.0;

        Assert.assertNotEquals(actual, expected, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArray(){
        double[] arrayX1 = {6.0, 11.0, 4.0, 5.0, 5.0, 3.0, 0.0, 2.0, 8.0};
        double[] arrayX2 = {7.0, 5.0, 9.0, 8.5, 9.5, 5.0, 3.0, 2.0};
        double[] arrayY = {5.0, 10.0, 2.0, 4.0, 3.0, 3.0, 0.0, 2.0};
        Multilinearregression regression = new Multilinearregression(arrayX1, arrayX2, arrayY);
    }
}