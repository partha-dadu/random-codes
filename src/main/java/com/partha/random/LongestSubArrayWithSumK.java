package com.partha.random;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {

    /**
     * [1,2,3,1,1,1,1,3,3]
     * k=3
     * ans=3 [1,1,1]
     * **/

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,1,1,1,1,3,3};
        int k = 6;
        LongestSubArrayWithSumK longestSubArrayWithSumK = new LongestSubArrayWithSumK();
        System.out.println(longestSubArrayWithSumK.lengthOfSubArraySumK(nums,k));

        int[] numsNegativeZeroes = {1,2,3,-3,1,1,1,0,1,4,2};
        System.out.println("HashMap Negative approach -> "+ longestSubArrayWithSumK.findMaxLengthSumK(numsNegativeZeroes,k));
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

    public int findMaxLengthSumK(int[] nums, int k) {
        int sum=0;
        int maxLength=-1;
        Map<Integer, Integer> map = new HashMap<>();
        int i =0;
        while( i < nums.length){
            sum = sum + nums[i];
            map.putIfAbsent(sum, i);
            if(sum == k){
                maxLength = Math.max(maxLength, i+1);
            }else if(map.containsKey(sum-k)){
                int startIndex = map.get(sum-k);
                maxLength = Math.max(maxLength, i-startIndex);
            }
            i++;
        }
        return maxLength;
    }

}
