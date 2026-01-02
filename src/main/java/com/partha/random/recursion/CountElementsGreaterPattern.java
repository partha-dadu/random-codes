package com.partha.random.recursion;

public class CountElementsGreaterPattern {

    public static void main(String[] args) {
        CountElementsGreaterPattern countElementsGreater = new CountElementsGreaterPattern();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(countElementsGreater.countElementsGreater(nums, 3, 0));
        System.out.println(countElementsGreater.findEvenCount(nums, 0));
        System.out.println(countElementsGreater.containsValue(nums,3, 0));
    }

    public int countElementsGreater(int[] nums, int target, int index) {
        if(index == nums.length){
            return 0;
        }
        int count = countElementsGreater(nums, target, index+1);
        if(nums[index] > target){
            return count+1;
        }
        return count;
    }

    public int findEvenCount(int[] nums, int index) {
        if(index == nums.length){
            return 0;
        }
        int count = findEvenCount(nums, index+1);
        if(nums[index] % 2 == 0){
            return count+1;
        }
        return count;
    }

    public boolean containsValue(int[] nums, int target, int index){
        if(index == nums.length){
            return false;
        }
        return nums[index] == target || containsValue(nums, target, index+1);
    }
}
