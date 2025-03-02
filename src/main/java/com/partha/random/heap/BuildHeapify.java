package com.partha.random.heap;

public class BuildHeapify {

    public static void main(String[] args) {
        int[] nums = {3,6,5,0,8,2,1,9};
        BuildHeapify buildHeapify = new BuildHeapify();
        buildHeapify.buildHeap(nums, 0 , nums.length);
        int i=0;
        while (i < nums.length){
            System.out.println(nums[i]);
            i++;
        }
    }

    public void buildHeap(int[] nums, int start, int end){
        int internalNodeBoundary = (end) / 2 - 1;
        for(int i = internalNodeBoundary; i >= 0; i--){
            heapifyArray(nums,i,end);
        }
    }

    public void heapifyArray(int[] nums, int start, int end){
        if(nums == null ){
            return;
        }
        if(nums.length == 0){
            return;
        }

            int largest = start;
            int left = 2*start+1;
            int right = 2*start+2;

            if(left <= end && nums[left] >= nums[start]){
                largest = left;
            }
            if(right <= end && nums[right] >= nums[largest]){
                largest = right;
            }
            if(largest != start) {
                int temp = nums[largest];
                nums[largest] = nums[start];
                nums[start] = temp;
                heapifyArray(nums,largest,end);
            }

    }
}
