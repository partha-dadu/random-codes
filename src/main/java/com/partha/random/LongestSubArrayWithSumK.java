package com.partha.random;

public class LongestSubArrayWithSumK {

    /**
     * [1,2,3,1,1,1,1,3,3]
     * k=3
     * ans=3 [1,1,1]
     * **/

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,0,1,1,3,3};
        int k = 6;
        LongestSubArrayWithSumK longestSubArrayWithSumK = new LongestSubArrayWithSumK();
        System.out.println(longestSubArrayWithSumK.lengthOfSubArraySumK(nums,k));
    }

    int lengthOfSubArraySumK(int[] nums, int k){
        int i = 0;
        int j= 0;
        int sum = 0;
        int length = -1;
        while(i < nums.length){
            sum = sum + nums[i];
            if(sum > k){
                sum = sum - nums[j];
                j++;
            }
            if(sum == k){
                length = Math.max(length, (i - j + 1));
            }
            i++;
        }
        return length;
    }
}
