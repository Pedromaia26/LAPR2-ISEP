package app.domain.model;

import java.util.Arrays;

public class BruteForceAlgorithm {
    /**
     * Returns the Max sum of a sequence.
     * @return  the Max sum of a sequence.
     */
    public static int[] MaxSum(int[] array) {


        int maxSum = Integer.MIN_VALUE;

        int begin = 0;
        int end = 0;

        for (int i = 0; i < array.length; i++) {

            int sum = 0;

            for (int j = i; j < array.length; j++) {

                sum += array[j];

                if (sum > maxSum) {
                    maxSum = sum;
                    begin = i;
                    end = j + 1;
                }

            }

        }
        int[] result = new int[end - begin];
        if (maxSum>0) {

            int c = 0;
            for (int i = begin; i < end; i++) {
                result[c] = array[i];
                c++;
            }
        }
        else return new int[0];
        System.out.println(":)");
        return result;
    }
}