package com.partha.random.heap;


public class HeapSortArray {

    public static void main(String[] args) {
        int[] sortTest = {3,6,5,0,8,2,1,9,9,9,9};
        HeapSortArray heapSortArray = new HeapSortArray();
        int[] result = heapSortArray.heapSort(sortTest);
        int i = 0;
        while (i < result.length){
            System.out.println(result[i]);
            i++;
        }
    }
    public int[] heapSort(int[] nums){
        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        BuildHeapify buildHeapify = new BuildHeapify();
        buildHeapify.buildHeap(nums, 0, nums.length);

        int[] result = new int[nums.length];

        for (int i=0; i < nums.length; i++){
            result[i] = nums[0];
            nums[0] = nums[nums.length - i -1];
            buildHeapify.buildHeap(nums, 0, nums.length-i-2);
        }
return result;
    }
}
