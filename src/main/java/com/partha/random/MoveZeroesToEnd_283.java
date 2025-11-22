package com.partha.random;

public class MoveZeroesToEnd_283 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroesToEnd_283 moveZeroesToEnd283 = new MoveZeroesToEnd_283();
        moveZeroesToEnd283.moveZeroesPractice(nums);
        int i = 0;
        while(i < nums.length){
            System.out.println(nums[i]);
            i++;
        }
    }
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=-1;
        while(i < nums.length){
            if(j == -1 && nums[i] == 0){
                j = i;
            }
            if(nums[i] != 0 && j != -1){
                nums[j]=nums[i];
                nums[i]=0;
                j++;
            }
            i++;
        }
    }

    public void moveZeroesPractice(int[] nums) {
        int i =-1;
        int j=0;
        while (j < nums.length){
            if(nums[j] == 0 && i == -1){
                i = j;
            }
            if(nums[j] != 0 && i != -1){
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
            j++;
        }
    }
}
