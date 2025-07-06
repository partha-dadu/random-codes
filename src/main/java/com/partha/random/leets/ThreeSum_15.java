package com.partha.random.leets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public static void main(String[] args) {
        ThreeSum_15 threeSum = new ThreeSum_15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum.threeSum(nums);
        System.out.println(Arrays.toString(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        selectionSort(nums);

        for(int i = 0; i < nums.length-2; i++){
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                int currSum = nums[i] + nums[j] + nums[k];
                if(currSum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                }
                else if(currSum < 0){
                    j++;
                    while(j < k && nums[j] == nums[j-1]){j++;}
                }else {
                    k -- ;
                    while (j < k && nums[k] == nums[k+1]){k--;}
                }
            }
        }
        return result;
    }

    private void selectionSort(int[] nums){
        for(int i = 0; i < nums.length -1; i++){
            int min = i;
            for(int j = i+1 ; j < nums.length; j++){
                if(nums[j] < nums[min] ){
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }
}
