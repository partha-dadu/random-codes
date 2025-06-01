package com.partha.random.recursion.dp;

import java.util.ArrayList;
import java.util.List;

public class SubSet_Sum_K_GFG {

    /**
     * Given an array of non-negative integers, and a value sum, determine if there exists a subset of the given set with sum equal to the given sum.
     *
     * N = 6
     * nums[] = {3, 34, 4, 12, 5, 2}
     * sum = 9
     * Output: 1
     * Explanation: Here there exists a subset with sum = 9 (4+3+2 = 9)
     * **/

    public static void main(String[] args) {
        SubSet_Sum_K_GFG s = new SubSet_Sum_K_GFG();
        List<Integer> stack = new ArrayList<>();
        int[] nums = {3, 34, 4, 12, 5, 2, 2};
        int[] gfg = {0,10,0};
        int result = s.countSubarraySum(gfg, 0, 10, stack);
        boolean possible = s.isSubsetSumExist(nums, 19, 0);
        System.out.println(result);
        System.out.println(possible);
    }

    public int countSubarraySum(int[] nums, int index, int target, List<Integer> stack) {
        /*if(index == nums.length-1 && target == nums[index]) {
            return 1;
        }*/

        if(index == nums.length && target == 0) {
            return 1;
        }

//        if (target == 0) {
//            System.out.println(stack);
//            return 1;
//        }

        if (index == nums.length) {
            return 0;
        }

        int notTake = countSubarraySum(nums, index+1, target, stack);
        int take = 0;
        if ( target >= nums[index]) {
            stack.add(nums[index]);
            take = countSubarraySum(nums, index+1, target - nums[index], stack);
            stack.remove(stack.size()-1);
        }
        return take+notTake;
    }

    public boolean isSubsetSumExist(int[] nums, int target, int index){
        if(target == 0){
            return true;
        }
        if(index == nums.length-1 && target == nums[index] ){
            return true;
        }
        if(index == nums.length){
            return false;
        }

        boolean notTake = isSubsetSumExist(nums, target,  index+1);
        boolean take = false;
        if(target >= nums[index]){
            take = isSubsetSumExist(nums, target-nums[index], index+1);
        }
        return notTake || take;
    }
}
