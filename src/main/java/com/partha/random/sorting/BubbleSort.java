package com.partha.random.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = { 5, 4, 3, 2, 1 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);
        System.out.println("Sorted array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void bubbleSort(int[] array) {
        int arraySize = array.length;
        for(int outer = arraySize - 1; outer > 0; outer--) {
            for (int i = 0; i < outer; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
