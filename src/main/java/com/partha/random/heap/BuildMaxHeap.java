package com.partha.random.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuildMaxHeap {

    public static void main(String[] args) {
        BuildMaxHeap heap = new BuildMaxHeap();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(7);
        list.add(6);

        heap.buildMaxHeapArray(list, 0, list.size());

    }

    public ArrayList<Integer> buildMaxHeapArray(ArrayList<Integer> arr, int start, int end){
        int internalNodes = arr.size()/2 -1;
        int[] nums = arr.stream().mapToInt(Integer::intValue).toArray();
        for(int i = internalNodes; i >= 0; i--){
            heapify(nums,i,arr.size());
        }

        return IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
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
