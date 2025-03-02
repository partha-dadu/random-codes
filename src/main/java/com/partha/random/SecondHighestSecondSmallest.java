package com.partha.random;

public class SecondHighestSecondSmallest {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    public int secondHighestSecond(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -2;
        }
        int max = -1;
        int secondMax = -2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > secondMax && nums[i] > max) {
                secondMax = max;
                max = nums[i];
            }else if(nums[i] > secondMax && nums[i] < max) {
                secondMax = nums[i];
            }
        }
        return secondMax;
    }

    public int secondSmallest(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -2;
        }

        int smallest = Integer.MAX_VALUE-1;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < smallest && nums[i] < secondSmallest) {
                secondSmallest = smallest;
                smallest = nums[i];
            } else if (nums[i] < secondSmallest && nums[i] > smallest) {
                secondSmallest = nums[i];
            }
        }
        return secondSmallest;
    }

}
