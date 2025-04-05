package com.partha.random.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = { 5, 4, 3, 2, 1 };
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(array);
        System.out.println("Sorted array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                swap(array, j - 1, j);
                j--;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
