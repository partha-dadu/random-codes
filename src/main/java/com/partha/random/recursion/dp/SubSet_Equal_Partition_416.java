package com.partha.random.recursion.dp;

import java.util.Arrays;

public class SubSet_Equal_Partition_416 {

    /**
     * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,5,11,5]
     * Output: true
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     * Example 2:
     *
     * Input: nums = [1,2,3,5]
     * Output: false
     * Explanation: The array cannot be partitioned into equal sum subsets.
     * **/

    public static void main(String[] args) {
        SubSet_Equal_Partition_416 obj = new SubSet_Equal_Partition_416();
        int[] nums = {1,5,11,5};
        boolean result = obj.canPartition(nums);
//        System.out.println("Result "+result);
//        nums = new int[]{1,2,3,5};
//        result = obj.canPartition(nums);
//        System.out.println("Result "+result);
        nums = new int[]{3,3,3,4,5};
        result = obj.canPartition(nums);
        System.out.println("Result "+result);
        nums = new int[]{1,2,3,4,5};
    }

    public boolean canPartition(int[] nums) {
        if(nums.length ==1){
            return false;
        }
        int sum = 0;
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum%2 == 1){
            return false;
        }

        int targetSum = sum / 2;
        int[][] dp = new int[nums.length][targetSum+1];
        for(int[] each: dp){
            Arrays.fill(each, -1);
        }
        return checkTargetPossible(nums, 0, targetSum, dp);
    }


    public boolean checkTargetPossible(int[] nums, int index, int target, int[][] dp ){
        if(target == 0){
            return true;
        }

        if(index == (nums.length-1)){
            if(target == nums[nums.length-1]){
                return true;
            }else{
                return false;
            }
        }

        if(dp[index][target] != -1){
            return 1 == dp[index][target];
        }

        boolean notTake = checkTargetPossible(nums, index+1, target,dp);
        boolean take = false;
        if(target >= nums[index]){
            take = checkTargetPossible(nums, index+1, target-nums[index],dp);
        }
        if (take | notTake)
            dp[index][target] = 1;
        else
            dp[index][target] = 0;
        return 1 == dp[index][target];
    }
}
