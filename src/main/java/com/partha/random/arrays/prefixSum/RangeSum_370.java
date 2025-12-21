package com.partha.random.arrays.prefixSum;

import java.util.ArrayList;
import java.util.List;

public class RangeSum_370 {

    public int[] getModifiedArray(int length, int[][] updates){
        int[] res = new int[length+1];
        int[] res2 = new int[length];
        for(int[] each : updates){
            int increment = each[2];
            int start = each[0];
            int end = each[1];
            res[start] += increment;
            if(end + 1 < length) {
                res[end + 1] -= increment;
            }
        }
        int sum = 0;
        for(int i =0; i<length; i++){
            sum += res[i];
            res2[i] = sum;
            res[i] = sum;
        }
        return res2;
    }
}
