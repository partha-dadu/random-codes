package com.partha.random.recursion.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingStairs {


    /**
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     * **/


    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        List<List<Integer>> result = new ArrayList<>();
        int target = 5;
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        int count = climbingStairs.climbStairs(0,target, new ArrayList<>(), result, dp);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
        System.out.println("Total Combinations: "+count);

        int newResult = climbingStairs.climbStairs(0, target,dp);
        System.out.println("Result Practice "+newResult);
    }

    public int climbingStairsFresh(int n, int index, int[] dp){
        if(index >= n){
            return 1;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        dp[index] = climbingStairsFresh(n, index+1, dp)+climbingStairsFresh(n, index+2,dp);
        return dp[index];
    }

    public int climbStairs(int index,int target, List<Integer> currentCombination, List<List<Integer>> result, int[] dp) {
        if(index == target){
            result.add(new ArrayList<>(currentCombination));
            return 1;
        }
        if(index > target){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }

        currentCombination.add(index);
        int left = climbStairs(index+1,target,currentCombination,result, dp);
        currentCombination.remove(currentCombination.size()-1);
        int right = climbStairs(index+2,target,currentCombination,result, dp);
        dp[index] = left+right;
        return left+right;
    }

    public int climbStairs(int stepNumber, int target, int[] dp){
        if(stepNumber == target){
            return 1;
        }
        if(stepNumber > target){
            return 0;
        }
        if(dp[stepNumber] != -1){
            return dp[stepNumber];
        }
        int singleStep = climbStairs(stepNumber+1, target,dp);
        int doubleStep = climbStairs(stepNumber+2, target,dp);
        dp[stepNumber] = singleStep + doubleStep;
        return dp[stepNumber];
    }
}
