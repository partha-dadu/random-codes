package com.partha.random.recursion.dp;

import java.util.Arrays;

public class HouseRobber_II_213 {

    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,2]
     * Output: 3
     * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
     * Example 2:
     *
     * Input: nums = [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     * Example 3:
     *
     * Input: nums = [1,2,3]
     * Output: 3
     * **/

    public static void main(String[] args) {
        HouseRobber_II_213 obj = new HouseRobber_II_213();
        int[]  nums = {1,2,3,1};
        int[] firstIncluded = new int[nums.length-1];
        int[] lastIncluded = new int[nums.length-1];
        for(int i = 0; i < lastIncluded.length; i++){
                lastIncluded[i] = nums[i+1];
                firstIncluded[i] = nums[i];
        }
        int left = obj.rob(firstIncluded);
        int right = obj.rob(lastIncluded);
        int result = Math.max(left, right);
        if(nums.length >= 2) {
            result = Math.max(left, right);
        }else if(nums.length == 1){
            result = nums[0];
        }
        System.out.println("Result "+result);
    }


    public int rob(int[] nums){
        if(nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int pick = nums[i];
            if(i > 1){
                pick += dp[i - 2];
            }
            int nonPick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[nums.length - 1];
    }
}
