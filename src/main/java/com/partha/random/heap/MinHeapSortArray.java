package com.partha.random.heap;

public class MinHeapSortArray {

    public static void main(String[] args) {
        int[] minHeapTest = {3,6,5,0,8,0,2,0,1,0,9};
        MinHeapSortArray minHeapSortArray = new MinHeapSortArray();
        int[] result = minHeapSortArray.minHeapSortArray(minHeapTest);
        int i = 0;
        while (i < result.length){
            System.out.println(result[i]);
            i++;
        }
    }
    public int[] minHeapSortArray(int[] nums){
        BuildMinHeap buildMinHeap = new BuildMinHeap();
        buildMinHeap.buildMinHeap(nums,0, nums.length);
        int[] result = new int[nums.length];
        for(int i=0; i < nums.length; i++){
            result[i] = nums[0];
            nums[0] = nums[nums.length-1-i];
            buildMinHeap.buildMinHeap(nums,0,nums.length-i-2);
        }
        return result;
    }
}
