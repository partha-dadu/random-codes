package com.partha.random.leets;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumK_Negatives_560 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,-3,6,-2,3,1,1};
        LongestSubArraySumK_Negatives_560 solution = new LongestSubArraySumK_Negatives_560();
        int result = solution.longestSubarray(arr, 7);
        int result2 = solution.longestSubarray2(arr, 3);
        System.out.println("mine "+result);
        System.out.println("leetcode "+result2);

    }

    public int longestSubarray(int[] nums, int k) {
      if(nums == null || nums.length == 0) {
          return 0;
      }
      int n = nums.length;
      Map<Integer, Integer> map = new HashMap<>();
      int sum = 0;
      int result = Integer.MIN_VALUE;
      for(int i = 0; i < n; i++) {
          sum += nums[i];
          if(sum == k){
              result = Math.max(result, i + 1);
          }

          int needed = k - sum;
          if(map.containsKey(needed)) {
              result = Math.max(result, i - map.get(needed) + 1);
          }
          map.putIfAbsent(sum, i);
      }
      return result;
    }

    public int longestSubarray2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); map.put(0,1);
        int sum = 0, validArrs = 0;

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];

            if (map.containsKey(sum-k))
                validArrs += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return validArrs;
    }
}
