package com.partha.random.leets;

public class CountInversionsInArray_GFG {

    /**
     * √Given an integer array arr[] of size n, find the inversion count in the array. Two array elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
     *
     * Note: Inversion Count for an array indicates that how far (or close) the array is from being sorted. If the array is already sorted, then the inversion count is 0, but if the array is sorted in reverse order, the inversion count is maximum.
     *
     * Examples:
     *
     * Input: arr[] = {4, 3, 2, 1}
     * Output: 6
     * **/

    public static void main(String[] args) {
        CountInversionsInArray_GFG obj = new CountInversionsInArray_GFG();
        int[] arr = {5,3,2,4,1};
        int result = obj.findCountInversions(arr, 0, arr.length - 1);
        System.out.println(result);
    }

    private int findCountInversions(int[] arr, int left, int right){
        if(left == right){
            return 0;
        }
        int count = 0;
        int mid = (right + left)/2;
        count += findCountInversions(arr, left, mid);
        count += findCountInversions(arr, mid + 1, right);
        count += merge(arr, left, mid, right);
        return count;
    }

    private int merge(int[] arr, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int index = 0;
        int count = 0;
        int[] temp = new int[right - left + 1];
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[index] =  arr[i];
                i++;
                index++;
            }else{
                count = count + (mid-i)+1;
                temp[index] = arr[j];
                j++;
                index++;
            }
        }

        while(i <= mid){
            temp[index] = arr[i];
            i++;
            index++;
        }
        while(j <= right){
            temp[index] = arr[j];
            j++;
            index++;
        }
        for(int t = left; t <= right; t++){
            arr[t] = temp[t-left];
        }
        return count;
    }
}
