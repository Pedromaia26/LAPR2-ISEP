package app.domain.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BruteForceAlgorithmTest {

    @Test
    public void maxSum() {

        int[] test = new int[]{1,2,-5,3,1};

        int[] result= BruteForceAlgorithm.MaxSum(test);

        int [] expected = new int[]{3,1};

        assertEquals(Arrays.toString(expected),Arrays.toString(result));
    }

    @Test
    public void maxSum2() {
        int[] test = new int[]{-1,-2,-5,-3,-1};

        int[] result= BruteForceAlgorithm.MaxSum(test);

        int [] expected = new int[]{};

        assertEquals(Arrays.toString(expected),Arrays.toString(result));
    }
}