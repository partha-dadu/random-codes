package com.partha.random.arrays.prefixSum;

class NumArray {

    public static void main(String[] args) {
        int[] arr = {-2,0,3,-5,2,-1};
        NumArray num = new NumArray(arr);
        System.out.println(num.sumRange(0,2));
    }

    int[] nums;
    int[] prefixSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        prefixSum = new int[nums.length];
        int sum = 0;
        for(int i =0; i < nums.length; i++){
            sum += nums[i];
            prefixSum[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        int leftSumExclude = left > 0 ? prefixSum[left-1] :0;
        return prefixSum[right] - leftSumExclude;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
