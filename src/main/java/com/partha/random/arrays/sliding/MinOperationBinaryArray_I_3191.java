package com.partha.random.arrays.sliding;

public class MinOperationBinaryArray_I_3191 {

    public static void main(String[] args) {
        MinOperationBinaryArray_I_3191 obj = new MinOperationBinaryArray_I_3191();
        int[] arr = {0,1,1,1,0,0};
        obj.minOperations(arr);
    }

    public int minOperations(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length < 3)
            return -1;
        int l = 0;
        int toTraverse = nums.length-3;
        int operationCount = 0;

        while(l < toTraverse ){
            if(nums[l] == 0){
                nums[l] = toggleBinary(nums[l]);
                nums[l+1] = toggleBinary(nums[l+1]);
                nums[l+2] = toggleBinary(nums[l+2]);
                operationCount++;
            }
            l++;
        }

        while(l < nums.length){
            if(nums[l] == 0)
                return -1;
            l++;
        }

        return operationCount;
    }

    private int toggleBinary(int val){
        if(val == 1)
            return 0;
        else
            return 1;
    }
}
