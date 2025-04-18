package com.partha.random.recursion.dp;

import java.util.Arrays;

public class HouseRobber_I_198 {

    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     * Example 2:
     *
     * Input: nums = [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     * Total amount you can rob = 2 + 9 + 1 = 12.
     * **/

    public static void main(String[] args) {
        HouseRobber_I_198 obj = new HouseRobber_I_198();
        int[] nums = {1,2,3,1};
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int result = obj.robTabulation(nums);
        System.out.println("Result "+result);
    }

    public int rob(int[] nums, int index, int[] dp) {
        if(index >= nums.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int pick = nums[index] + rob(nums, index+2, dp);
        int notPick = 0 + rob(nums, index+1, dp);
        dp[index] = Math.max(notPick, pick);
        return dp[index];
    }

    public int robTabulation(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int pick = nums[i];
            if(i > 1) {
                pick += dp[i - 2];
            }
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(notPick, pick);
        }
        return dp[nums.length-1];
    }
}
