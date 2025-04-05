package com.partha.random.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = { 5, 4, 3, 2, 1 };
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(array);
        System.out.println("Sorted array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void selectionSort(int[] array) {
        int arraySize = array.length;
        for (int outer = 0; outer < arraySize - 1; outer++) {
            int minIndex = outer;
            for (int i = outer + 1; i < arraySize; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            swap(array, outer, minIndex);
        }
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
