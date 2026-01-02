package com.partha.random.heap;

import java.util.ArrayList;

public class BuildMaxHeapDynamic {

    public void heapSort(ArrayList<Integer> arr){
        int internalNodes = arr.size()/2 -1;
        for(int i = internalNodes; i >= 0; i--){
            heapify(arr, i, arr.size());
        }
        for(int end = arr.size()-1; end > 0; end--){
            int temp = arr.get(0);
            arr.set(0, arr.get(end));
            arr.set(end, temp);
            heapify(arr, 0, end);
        }
    }

    private void heapify(ArrayList<Integer> arr, int start, int end){
        if(start >= end || arr.size() <= 1){
            return;
        }
        int largest = start;
        int leftChild = 2*start + 1;
        int rightChild = 2*start + 2;
        if(leftChild < end && arr.get(leftChild) > arr.get(largest)){
            largest = leftChild;
        }
        if(rightChild < end && arr.get(rightChild) > arr.get(largest)){
            largest = rightChild;
        }
        if(largest != start){
            swap(arr, largest, start);
            heapify(arr, largest, end);
        }
    }

    private void swap(ArrayList<Integer> arr, int source, int dest){
        int temp = arr.get(source);
        arr.set(source, arr.get(dest));
        arr.set(dest, temp);
    }
}
