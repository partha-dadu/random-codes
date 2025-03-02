package com.partha.random.heap;

public class BuildMinHeap {

    public static void main(String[] args) {
        int[] minHeapArray = {3,6,5,0,8,0,2,0,1,0,9};
        BuildMinHeap buildMinHeap = new BuildMinHeap();
        buildMinHeap.buildMinHeap(minHeapArray, 0,minHeapArray.length);
        int i = 0;
        while (i < minHeapArray.length){
            System.out.println(minHeapArray[i]);
            i++;
        }
    }

    public void buildMinHeapifyArray(int[] nums, int start, int end){
        if(nums == null || nums.length == 0){
            return;
        }
        int left = 2*start+1;
        int right = 2*start+2;
        int minimum = start;
        if(left < end && nums[left] <= nums[start]){
            minimum = left;
        }
        if(right < end && nums[right] <= nums[minimum]){
            minimum = right;
        }

        if(minimum != start){
            int temp = nums[minimum];
            nums[minimum] = nums[start];
            nums[start] = temp;
            buildMinHeapifyArray(nums, minimum, end);
        }
    }

    public void buildMinHeap(int[] nums, int start, int end){
        if(nums == null || nums.length == 0){
            return;
        }
        int internalNodes = (end) / 2 -1;
        for(int i=internalNodes ; i >= 0; i--){
            buildMinHeapifyArray(nums, i, end);
        }
    }
}
