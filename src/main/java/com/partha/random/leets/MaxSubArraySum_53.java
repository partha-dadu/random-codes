package com.partha.random.leets;

public class MaxSubArraySum_53 {

    /**
     * Kadane's Algo
     * Given an integer array nums, find the
     * subarray
     *  with the largest sum, and return its sum.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     *
     * **/

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArraySum_53 maxSubArraySum53 = new MaxSubArraySum_53();
        System.out.println(maxSubArraySum53.findMaxSubArraySum(nums));
    }

    public int findMaxSubArraySum(int[] nums){
        int i = 0;
        int j=0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (j < nums.length){
            sum = sum + nums[j];
            max = Math.max(max, sum);
            if(sum < 0){
                sum = 0;
                i = j;
            }

            j++;
        }
            return max;
    }
}
