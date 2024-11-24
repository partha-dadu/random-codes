package com.partha.random;

public class MaxConsecutiveOnes_485 {


    /**
     * Input: nums = [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
     * */

    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        MaxConsecutiveOnes_485 maxConsecutiveOnes485  = new MaxConsecutiveOnes_485();
        int result = maxConsecutiveOnes485.findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }
    public int findMaxConsecutiveOnes(int[] nums) {

        int i =0;
        int count=0;
        int result = 0;
        while(i < nums.length){
            if(nums[i] == 1){
                count++;
                result = Math.max(count,result);
            }else{
                count = 0;
            }
            i++;
        }


        return result;
    }
}
