package com.partha.random.recursion.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        List<List<Integer>> result = new ArrayList<>();
        int target = 5;
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        int count = climbingStairs.climbStairs(0,target, new ArrayList<>(), result,0, dp);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
        System.out.println("Total Combinations: "+count);
    }

    public int climbStairs(int index,int target, List<Integer> currentCombination, List<List<Integer>> result, int sum, int[] dp) {
        if(index == target){
            result.add(new ArrayList<>(currentCombination));
            return sum+1;
        }
        if(index > target){
            return sum+0;
        }
        if(dp[index] != -1){
            return dp[index];
        }

        currentCombination.add(index);
        int left = climbStairs(index+1,target,currentCombination,result,0, dp);
        currentCombination.remove(currentCombination.size()-1);
        int right = climbStairs(index+2,target,currentCombination,result,0, dp);
        dp[index] = left+right;
        return left+right;
    }
}
