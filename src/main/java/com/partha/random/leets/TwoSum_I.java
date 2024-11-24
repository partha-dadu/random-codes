package com.partha.random.leets;

import java.util.Arrays;

public class TwoSum_I {

    /**
     * Classic Two Sum problem
     * Given an array of numbers find if there exist a pair for which Sum==K
     * [2,3,8,5,9,1,4] K=17
     * **/
    public static void main(String[] args) {
//        int[] nums = {2,3,8,5,9,1,4};
        int [] nums = {3,2,4};
        TwoSum_I twoSumI = new TwoSum_I();
        int[] result = twoSumI.findTwoSum(nums,6);
        int i = 0;
        while (i < result.length){
            System.out.println(result[i]);
            i++;
        }
    }

    public int[] findTwoSum(int[] nums, int target){
        Arrays.sort(nums);
        int l =0;
        int r = nums.length-1;
        while (l < r){
            if((nums[l] + nums[r]) == target){
                return new int[]{l,r};
            }else if((nums[l] + nums[r]) > target){
                r --;
            }else{
                l++;
            }

        }
        return new int[]{};
    }
}
