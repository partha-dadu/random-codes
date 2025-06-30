package com.partha.random.recursion.dp;

import com.partha.random.leets.FrogJump_403;

import java.util.Arrays;

public class FrogJump_I_GFG {

    /**
     * Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the first stair and wants to reach the top. From any stair i, the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair. The cost of a jump is the absolute difference in height between the two stairs. Determine the minimum total cost required for the frog to reach the top.
     *
     * Example:
     *
     * Input: heights[] = [20, 30, 40, 20]
     * Output: 20
     * Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:
     * jump from stair 0 to 1: cost = |30 - 20| = 10
     * jump from stair 1 to 3: cost = |20-30|  = 10
     * Total Cost = 10 + 10 = 20
     *
     * **/
    public static void main(String[] args) {
        FrogJump_I_GFG obj = new FrogJump_I_GFG();
        int[] stones = {17 ,6 ,12 ,10 ,3 ,13 ,17 ,20 ,8};
        int[] dp = new int[stones.length];
        Arrays.fill(dp,-1);
//        int result = obj.frogJump(stones,0,dp);
//        int result = obj.frogJumpWithDistanceK(stones,0,2,dp);
        int result = obj.frogJumpWithDistanceKTabulation(stones,0,2,dp);
        System.out.println("Result "+result);
    }

    public int frogJump(int[] stones, int index, int[] dp){
        if(index >= stones.length-1){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int differece2=Integer.MAX_VALUE;

            int left = Math.abs(stones[index] - stones[index + 1]);
            int difference1 = left + frogJump(stones, index + 1,  dp);
        if(index +2 < stones.length) {
            int right = Math.abs(stones[index] - stones[index + 2]);
            differece2 = right + frogJump(stones, index + 2,  dp);

        }
        dp[index] = Math.min(differece2,difference1);
        return dp[index];
    }

    public int frogJumpWithDistanceK(int[] stones, int index, int k, int[] dp){
        if(index >= stones.length-1){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }

        int minEnergyConsumed = Integer.MAX_VALUE;

        for(int j =1; j <= k; j++){
            if(index+j < stones.length){
                int energyConsumed = Math.abs(stones[index] - stones[index+j]);
                int result = energyConsumed + frogJumpWithDistanceK(stones, index+j, k, dp);
                minEnergyConsumed = Math.min(minEnergyConsumed, result);
            }
        }
        dp[index] = minEnergyConsumed;
        return dp[index];

    }

    public int frogJumpWithDistanceKTabulation(int[] stones, int index, int k, int[] dp){
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i =1; i < stones.length; i++){
            int minEnergyConsumed = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                if(i - j >= 0){
                    int energyConsumed = Math.abs(stones[i] - stones[i-j]);
                    int result = energyConsumed + dp[i-j];
                    minEnergyConsumed = Math.min(minEnergyConsumed, result);
                }
            }
            dp[i] = minEnergyConsumed;
        }
        return dp[stones.length-1];
    }
}
