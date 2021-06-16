package app.domain.model;

import com.isep.mdis.Sum;

public class MaxSumAdapter1 implements MaxSum{

    @Override
    public int[] maxSum(int [] array){

        return Sum.Max(array);
    }

}
