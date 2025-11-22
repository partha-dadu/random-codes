package com.partha.random.arrays.sliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeSumDivisibleByP_1590 {


    public static void main(String[] args) {
        MakeSumDivisibleByP_1590 m = new MakeSumDivisibleByP_1590();
        int[] arr = new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2};
        m.minSubarray(arr, 148);
    }
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int each : nums){
            sum += each;
        }
        long remainder = sum%p;
        long removeSum = remainder;
        long fullQuotient= sum/p;
        int minLength = -1;
        if(remainder == 0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        int calc1 = findMinimumWindowSumK(nums, (int)remainder);
        minLength = Math.min(calc1, minLength);
        for(int i =1; i <= fullQuotient; i++){
            int product = p * i;
            int sumToRemove = (int)(sum - product);
            int calc = findMinimumWindowSumK(nums, sumToRemove);
            list.add(calc);
            minLength = Math.min(calc, minLength);
        }

        int result = list.stream().mapToInt(Integer::intValue).filter(a -> a > 0).min().orElse(-1);
        return result;
    }

    private int findMinimumWindowSumK(int[] nums, int p){
        Map<Long, Integer> map = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        long prefixSum = 0;
        for(int i =0; i < nums.length; i++){
            prefixSum = prefixSum + nums[i];
            map.putIfAbsent(prefixSum, i);
            long lookUp = prefixSum - p;
            if(map.containsKey(lookUp)){
                minLength = Math.min(minLength, i - (map.get(lookUp)));
            }


        }

        return Integer.MAX_VALUE == minLength ? -1 : minLength;
    }
}
