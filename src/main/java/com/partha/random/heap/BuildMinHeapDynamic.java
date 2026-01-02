package com.partha.random.heap;

import java.util.ArrayList;
import java.util.Arrays;

public class BuildMinHeapDynamic {

    public static void main(String[] args) {
        BuildMinHeapDynamic minHeapDynamic = new BuildMinHeapDynamic();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5,8,2,3,4,1,7,6));
        minHeapDynamic.buildMinHeap(arr);
        minHeapDynamic.increaseKey(arr, 3, 15);
        minHeapDynamic.decreaseKey(arr, 3, -1);
    }

    public void buildMinHeap(ArrayList<Integer> arr){
        int internalNodes = arr.size()/2-1;
        for(int i=internalNodes;i>=0;i--){
            minHeapify(arr,i,arr.size());
        }
    }

    public void increaseKey(ArrayList<Integer> arr, int index,  int val){
        if(arr.get(index) > val){
            System.out.println("wrong operation called");
            return;
        }
        arr.set(index, val);
        minHeapify(arr,index,arr.size());
    }

    public void decreaseKey(ArrayList<Integer> arr, int index, int val){
        if(arr.get(index) < val){
            System.out.println("wrong operation called");
            return;
        }
        arr.set(index, val);
        percolateUp(arr,index);
    }

    public void percolateUp(ArrayList<Integer> arr, int index){
        while(index > 0){
            int parent = (index-1)/2;
            if(arr.get(index) <  arr.get(parent)){
                swap(arr,parent,index);
                index = parent;
            }else break;
        }
    }

    public void minHeapSort(ArrayList<Integer> arr){
        int internalNodes = arr.size()/2-1;
        for(int i=internalNodes;i>=0;i--){
            minHeapify(arr,i,arr.size());
        }
        for(int end= arr.size()-1;end>0;end--){
            int temp = arr.get(0);
            arr.set(0, arr.get(end));
            arr.set(end, temp);
            minHeapify(arr,0,end);
        }
    }

    public void minHeapify(ArrayList<Integer> arr, int start, int end) {
        if(start >= end || arr.size() <= 1){
            return;
        }
        int min = start;
        int leftChild = 2*start + 1;
        int rightChild = 2*start + 2;
        if(leftChild < end && arr.get(leftChild) < arr.get(min)){
            min = leftChild;
        }
        if(rightChild < end && arr.get(rightChild) < arr.get(min)){
            min = rightChild;
        }
        if(min != start){
            swap(arr, start, min);
            minHeapify(arr, min, end);
        }

    }

    private void swap(ArrayList<Integer> arr, int source, int dest){
        int temp = arr.get(source);
        arr.set(source, arr.get(dest));
        arr.set(dest, temp);
    }
}
