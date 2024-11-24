package com.partha.random;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement_II_229 {

    /***
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,3]
     * Output: [3]
     * Example 2:
     *
     * Input: nums = [1]
     * Output: [1]
     * Example 3:
     *
     * Input: nums = [1,2]
     * Output: [1,2]
     * **/
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        MajorityElement_II_229 majorityElementIi229 = new MajorityElement_II_229();
        majorityElementIi229.majorityElement(nums).stream().forEach(System.out::println);
    }

    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2=0;
        int element1=-1;
        int element2=-1;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i < nums.length; i++){
            if(count1 == 0 && nums[i] != element2){
                element1 = nums[i];
                count1++;
            }else if(count2 == 0 && nums[i] != element1){
                element2 = nums[i];
                count2++;
            }else if(element1 == nums[i]){
                count1++;
            }else if(element2 == nums[i]) {
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        int n_3 = nums.length/3;
        int ele1count =0;
        int ele2count=0;
        for(int i=0; i< nums.length;i++){
            if(nums[i]  == element1) {
                ele1count++;
            } else if (nums[i] == element2) {
                ele2count++;
            }
        }
        if(ele1count > n_3){
            result.add(element1);
        }
        if(ele2count > n_3){
            result.add(element2);
        }

        return result;
    }

}
