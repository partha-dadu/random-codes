package com.partha.random.recursion;

public class SumOfAllElements {

    public static void main(String[] args) {
        SumOfAllElements sum = new SumOfAllElements();
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Sum -> "+ sum.sumOfAllElements(nums, 0));
    }

    public int sumOfAllElements(int[] nums, int index){
        if(index == nums.length){
            return 0;
        }
        return nums[index] + sumOfAllElements(nums, index+1);
    }
}
