package com.partha.random;

public class MajorityElement_169 {

    /**
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     *
     *  Example 1:
     *
     * Input: nums = [7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5]
     * Output: 3
     * Example 2:
     *
     * Input: nums = [1,7,5,7,7,5,3,2,5,1,1,5,5,5,3,7,5,7,5,5,5,5]
     * Output: 5
     * ***/
    public static void main(String[] args) {
        int[] nums = {1,5,7,5,7,5,5,5,5,7,5,3,2,5,1,5,1,5,5,5,5,3,7,5,7,3,3,3};
        MajorityElement_169 majorityElement169 = new MajorityElement_169();
        int result = majorityElement169.majorityElement(nums);
        System.out.println(result);
    }

    public int majorityElement(int[] nums) {
        int element=-1;
        int count=0;
        for (int i=0; i<nums.length; i++){
            if(count == 0){
                count++;
                element = nums[i];
            }else if(nums[i] == element){
                count++;
            }else {
                count--;
            }
        }

        int count1 = 0;
        for (int i =0;i<nums.length;i++){
            if(nums[i] == element){
                count1++;
            }
        }
        if(count1 >= nums.length/2){
            return element;
        }else
            return -1;

    }
}
