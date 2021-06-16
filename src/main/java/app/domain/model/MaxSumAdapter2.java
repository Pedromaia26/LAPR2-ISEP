package app.domain.model;

public class MaxSumAdapter2 implements MaxSum {

    @Override
    public int[] maxSum(int [] array){

        return BruteForceAlgorithm.MaxSum(array);
    }
}
