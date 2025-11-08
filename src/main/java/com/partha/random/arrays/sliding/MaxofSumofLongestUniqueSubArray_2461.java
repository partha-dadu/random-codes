package com.partha.random.arrays.sliding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxofSumofLongestUniqueSubArray_2461 {

    public static void main(String[] args) {
        MaxofSumofLongestUniqueSubArray_2461 sol = new MaxofSumofLongestUniqueSubArray_2461();
        int[] arr = new int[]{9,9,9,1,2,3};
        sol.maximumSubarraySum(arr, 3);
    }

    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> set = new HashMap<>();
        int l=0, r=k-1;
        long sum = 0;
        long maxSum = 0;
        for(int i =0; i <= r; i++){
            set.put(nums[i], set.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }
        if(set.keySet().size() == k){
            maxSum = Math.max(maxSum, sum);
        }

        while(r < nums.length-1){
            sum -= nums[l];
            if (set.get(new Integer(nums[l])) == 1){
                set.remove(new Integer(nums[l]));
            }else{
                set.put(new Integer(nums[l]), set.get(new Integer(nums[l])) - 1);
            }
            l++;

            r++;
            set.put(new Integer(nums[r]), set.getOrDefault(new Integer(nums[r]), 0) + 1);
            sum += nums[r];

            if(set.keySet().size() == k){
                maxSum = Math.max(maxSum, sum);
            }

        }
        return maxSum;

    }
}
