package com.partha.random.recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {9,7,5,4,8,1,6,3,2};
        mergeSort.mergeSort(arr);
    }

    public void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
       for(int i = 0; i<arr.length; i++){
           System.out.print(arr[i]+" ");
       }
    }

    public void mergeSort(int[] arr, int low, int high){
        if(low >= high){
            return ;
        }
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int left = low;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[index] = (arr[left]);
                left++;
                index++;
            }else{
                temp[index] = (arr[right]);
                right++;
                index++;
            }
        }
        while (left <= mid){
            temp[index] = (arr[left]);
            index++;
            left++;
        }
        while (right<=high){
            temp[index] = (arr[right]);
            index++;
            right++;
        }

        for(int i = low; i <= high; i++){
            arr[i] = temp[i - low];
        }

    }

}
