package app.adapter;

import app.domain.model.BruteForceAlgorithm;
import app.domain.model.MaxSum;

public class MaxSumAdapter2 implements MaxSum {

    @Override
    public int[] maxSum(int [] array){

        return BruteForceAlgorithm.MaxSum(array);
    }
}
