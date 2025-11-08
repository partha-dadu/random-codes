package com.partha.random;

public class MaxConsecutiveOnesWithFlip {
    /**
     * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
     * Output: 6
     * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     *
     * */

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        MaxConsecutiveOnesWithFlip maxConsecutiveOnesWithFlip = new MaxConsecutiveOnesWithFlip();
        int result = maxConsecutiveOnesWithFlip.longestOnes(nums, k);
        System.out.println("result "+result);
    }

    private int longestSeq(int[] nums, int k){
        int l =0;
        int r=0;
        int maxLength = 0;
        int currentZero = 0;
        while(r< nums.length){
            if(nums[r] == 0){
                currentZero++;
            }
            if(currentZero > k){
                if(nums[l] == 0){
                    currentZero--;
                }
                l++;
            }
            if(currentZero <= k){
                int length = r-l+1;
                maxLength = Math.max(maxLength, length);
            }
            r++;
        }
        return maxLength;
    }

    public int longestOnes(int[] nums, int k) {
        int length = 0;
        int maxLength = 0;
        int zeroCount = 0;

        int l =0;
        int r = 0;
        while(r < nums.length){
            if(nums[r] == 1 && zeroCount <= k){
                length = r-l+1;
                maxLength = Math.max(maxLength, length);
            }else{
                zeroCount++;
                if(zeroCount <= k){
                    length = r-l+1;
                    maxLength = Math.max(maxLength, length);
                }else{
                    if(nums[l] == 0){
                        zeroCount--;
                        l++;
                    }else{
                        l++;
                    }
                }
            }
            r++;
        }
        return maxLength;
    }
}
