package com.partha.random.recursion.backtrack;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.QuickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void QuickSort(int[] arr, int left, int right){
        if(left < right){
            int partition = partition(arr, left, right);
            QuickSort(arr, left, partition - 1);
            QuickSort(arr, partition + 1, right);
        }

    }

    public int partition(int[] arr, int left, int right){
        int pivot = arr[left];
        int low = left;
        int high = right;
        while(low < high) {
            while (arr[low] <= pivot && low <= right) {
                low++;
            }
            while (arr[high] > pivot && high >= left-1) {
                high--;
            }

            if (low < high) {
                swap(arr, low, high);
            }
        }
        swap(arr, left, high);
        return high;

    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
