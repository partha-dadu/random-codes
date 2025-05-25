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
        int[] nums = {3, 34, 4, 12, 5, 2, 2};
        List<Integer> stack = new ArrayList<>();
        int result = s.countSubarraySum(nums, 0, 11, stack);
        System.out.println(result);
    }

    public int countSubarraySum(int[] nums, int index, int target, List<Integer> stack) {
        if (target == 0) {
            System.out.println(stack);
            return 1;
        }
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
}
