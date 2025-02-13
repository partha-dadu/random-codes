package com.partha.random;

public class SortArrayContaining3DifferentElements_75 {

    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     *
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     *
     * You must solve this problem without using the library's sort function.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * **/

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortArrayContaining3DifferentElements_75 sortArrayContaining3DifferentElements75 = new SortArrayContaining3DifferentElements_75();
        sortArrayContaining3DifferentElements75.sortColors(nums);
        int i=0;
        while (i < nums.length){
            System.out.println(nums[i]);
            i++;
        }
    }
    public void sortColors(int[] nums) {
        int i=0;
        int j=0;
        int k =nums.length-1;

        while (j <= k){
            if(nums[j] == 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }else if(nums[j] == 1){
                j++;
            }else{
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                k--;
            }
        }

    }
}
