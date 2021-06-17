package app.adapter;

import app.domain.model.MaxSum;
import com.isep.mdis.Sum;

public class MaxSumAdapter1 implements MaxSum {

    @Override
    public int[] maxSum(int [] array){

        return Sum.Max(array);
    }

}
