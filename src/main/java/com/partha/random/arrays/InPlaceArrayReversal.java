package com.partha.random.arrays;

import java.util.ArrayList;
import java.util.List;

public class InPlaceArrayReversal {

    public static void main(String[] args) {
        InPlaceArrayReversal inPlaceArrayReversal = new InPlaceArrayReversal();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        inPlaceArrayReversal.reverseArray(arr);
        inPlaceArrayReversal.reverseArray(arr, 0,  arr.length-1);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        inPlaceArrayReversal.reverseListAfterNth(list, 3);
        list.forEach(System.out::println);
    }
    public void reverseArray(int[] nums){
        int mid = nums.length/2;
        int length = nums.length;
        for(int i = 0; i <= mid; i++){
            if(!(length % 2 == 0 && i == mid)) {
                int temp = nums[i];
                nums[i] = nums[length - i - 1];
                nums[length - i - 1] = temp;
            }
        }
    }

    public void reverseArray(int[] nums, int start, int end){
        if(!(start < nums.length && end < nums.length)){
            return;
        }
        while(start <= end){
            int temp =  nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public void reverseListAfterNth(ArrayList<Integer> nums, int m){
        int size = nums.size();
        int start = m + 1;
        int end = size-1;

        while(start <= end){
            int temp = nums.get(start);
            nums.add(start, nums.get(end));
            nums.add(end, temp);
            start++;
            end--;
        }
    }
}
