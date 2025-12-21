package com.partha.random.arrays.prefixSum;

public class NumberOfSplit_2270 {

    public static void main(String[] args) {
        NumberOfSplit_2270 n = new NumberOfSplit_2270();
        int[] arr = {10,4,-8,7};
        n.waysToSplitArray(arr);
    }

    public int waysToSplitArray(int[] nums) {


        int sum = 0;
        int count = 0;
        for(int i =0; i < nums.length; i++){

            sum += nums[i];
        }
        int pSum = 0;
        for(int i = 0; i < nums.length; i++){
            pSum += nums[i];
            int partitionDiff = sum - pSum;
            if(pSum >= partitionDiff){
                count++;
            }
        }
        return count;

    }
}
