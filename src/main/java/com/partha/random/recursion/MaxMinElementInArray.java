package com.partha.random.recursion;

public class MaxMinElementInArray {

    public static void main(String[] args) {
        MaxMinElementInArray maxElementInArray = new MaxMinElementInArray();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(maxElementInArray.findMax(nums, 0));
        System.out.println(maxElementInArray.findMin(nums, 0));
    }

    public int findMax(int[] nums, int index) {
        if(index == nums.length){
            return Integer.MIN_VALUE;
        }
        return Math.max(nums[index], findMax(nums, index+1));
    }

    public int findMin(int[] nums, int index) {
        if(index == nums.length){
            return Integer.MAX_VALUE;
        }
        return Math.min(nums[index], findMin(nums, index+1));
    }
}
