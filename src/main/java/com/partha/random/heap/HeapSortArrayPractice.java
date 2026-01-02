package com.partha.random.heap;

public class HeapSortArrayPractice {

    public static void main(String[] args) {
        HeapSortArrayPractice practice = new HeapSortArrayPractice();
        int[] nums = {3,1,6,5,2,4};
        int[] result = practice.heapSort(nums);
    }

    public int[] heapSort(int[] nums){

        int internalNodes = nums.length / 2 - 1;
        for(int i = internalNodes; i >= 0; i--){
            heapify(nums, i, nums.length);
        }
        for(int end = nums.length-1; end > 0; end--){
            int temp = nums[0];
            nums[0] = nums[end];
            nums[end] = temp;
            heapify(nums, 0, end);
        }
        return nums;
    }

    public void heapify(int[] nums, int start, int end){
        if(start >= end || nums.length <= 1){
            return;
        }
        int largest = start;
        int leftChild = 2*start + 1;
        int rightChild = 2*start + 2;
        if(leftChild < end && nums[leftChild] > nums[largest]){
            largest = leftChild;
        }
        if(rightChild < end && nums[rightChild] > nums[largest]){
            largest = rightChild;
        }
        if(largest != start){
            int temp = nums[start];
            nums[start] = nums[largest];
            nums[largest] = temp;
            heapify(nums, largest, end);
        }
    }
}
