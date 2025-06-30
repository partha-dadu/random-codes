package com.partha.random.recursion.dp;

import java.util.Arrays;

public class SubSetSum_K {

    public static void main(String[] args) {
        SubSetSum_K obj = new SubSetSum_K();
        int[] nums = {1,5,11,5};
        int target = 6;
        int[][] dp = new int[nums.length][target+1];
        for(int[] each: dp){
            Arrays.fill(each, -1);
        }
//        boolean result = obj.subSetSumK(nums, target, 0, dp);
        boolean result = obj.subSetSumKTabulation(nums, target);
        System.out.println("Result "+result);
        nums = new int[]{1,2,3,5};
        target = 10;
//        result = obj.subSetSumK(nums, target, 0, dp);
//        System.out.println("Result "+result);
//        nums = new int[]{3,3,3,4,5};
//        target = 10;
//        result = obj.subSetSumK(nums, target, 0, dp);
//        System.out.println("Result "+result);
//        nums = new int[]{1,2,3,4,5};
    }

    public boolean subSetSumK(int[] nums, int target, int index, int[][] dp){
        if(target == 0){
            return true;
        }
        if(index == nums.length-1){
            if(target == nums[index]){
                return true;
            }else{
                return false;
            }
        }

        if(dp[index][target] != -1){
            return dp[index][target] == 1;
        }
        boolean notTake = subSetSumK(nums, target, index+1, dp);
        boolean take = false;
        if(target >= nums[index]){
            take = subSetSumK(nums, target-nums[index], index+1, dp);
        }
          if(take | notTake)
              dp[index][target] = 1;
          else
              dp[index][target] = 0;
          return dp[index][target] == 1;
    }

    public boolean subSetSumKTabulation(int[] nums, int k){
        boolean[][] dp = new boolean[nums.length][k+1];
        for(boolean[] each: dp){
            Arrays.fill(each, false);
        }
        dp[0][nums[0]] = true;
        for(int i =0; i < nums.length; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i < nums.length; i++){
            for(int target = 1; target <= k; target++){
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(nums[i] <= target){
                    take = dp[i-1][target-nums[i]];
                }
                dp[i][target] = notTake | take;
            }
        }
        // Not that intuitive , so incomplete
        return dp[nums.length-1][k];
    }
}
