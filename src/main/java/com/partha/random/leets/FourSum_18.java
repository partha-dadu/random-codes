package com.partha.random.leets;

import java.util.ArrayList;
import java.util.List;

public class FourSum_18 {
    /**
     * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     *
     * 0 <= a, b, c, d < n
     * a, b, c, and d are distinct.
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * You may return the answer in any order.
     * **/

    public static void main(String[] args) {
        FourSum_18 sol = new FourSum_18();
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> result = sol.fourSum(nums, -294967296);
        System.out.println(result);

    }

    public List<List<Integer>> fourSum(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        selectionSort(nums);
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1]){continue;}
            for (int j = i + 1; j < nums.length; j++) {
                if(j>i+1 && nums[j]==nums[j-1]){continue;}
                int k = j+1;
                int l = size -1;
                while (k < l){
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        result.add(list);
                        k++;l--;
                        while(k < l && nums[k] == nums[k-1]){k++;}
                        while(k < l && nums[l] == nums[l+1]){l--;}
                    }else if(sum<target){
                        k++;
                    }else {
                        l--;
                    }
                }
            }
        }
        return result;
    }

    private void selectionSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
