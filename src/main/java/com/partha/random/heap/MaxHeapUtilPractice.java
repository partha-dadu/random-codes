package com.partha.random.heap;

import java.util.Arrays;

public class MaxHeapUtilPractice {

    public static void main(String[] args) {
        MaxHeapUtilPractice maxHeap = new MaxHeapUtilPractice();
        int[] arr = {3,1,6,5,2,4};
        maxHeap.buildMaxHeap(arr);
        int[] resultant = maxHeap.addNode(arr, 9);
        maxHeap.increaseKey(resultant, 3, 12);
        maxHeap.decreaseKey(resultant, 3, 1);

    }

    public void decreaseKey(int[] arr, int index, int val){
        if(arr[index] < val){
            System.out.println("Wrong operation called");
            return;
        }
        arr[index] = val;
        heapify(arr, index, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public void increaseKey(int[] arr, int index, int val){
        if(arr[index] > val){
            System.out.println("Wrong operation called");
            return;
        }
        arr[index] = val;
        percolateUp(arr, index);
        System.out.println(Arrays.toString(arr));

    }

    public int[] addNode(int[] nums, int val){
        int[] result = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            result[i] = nums[i];
        }
        result[nums.length] = val;
        percolateUp(result, result.length-1);
        return result;
    }

    private void percolateUp(int[] nums, int start){
        while(start > 0 ){
            int parent = (start-1) / 2;
            if(nums[start] > nums[parent]) {
                int temp = nums[start];
                nums[start] = nums[parent];
                nums[parent] = temp;
                start = parent;
            }else break;
        }
    }

    public void buildMaxHeap(int[] arr){
        int internalNodes = arr.length/2 -1;
        for(int i=internalNodes; i>=0; i--){
            heapify(arr, i, arr.length);
        }
    }

    private static void heapify(int[] arr, int start, int end){
        if(start >= end || arr.length <= 1){
            return ;
        }
        int leftChild = 2*start+1;
        int rightChild = 2*start+2;
        int large = start;
        if(leftChild < end && arr[large] < arr[leftChild]){
            large = leftChild;
        }
        if(rightChild < end && arr[large] < arr[rightChild]){
            large = rightChild;
        }

        if(large != start){
            int temp = arr[start];
            arr[start] =  arr[large];
            arr[large] = temp;
            heapify(arr, large, end);
        }
    }
}
