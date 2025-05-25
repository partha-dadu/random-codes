package com.partha.random.leets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets_II__90 {

    /**
     * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,2]
     * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     *
     * **/

    public static void main(String[] args) {
        SubSets_II__90 obj = new SubSets_II__90();
        int[] candidates = {1,2,2};
        selectionSort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        obj.findSubSets_II(candidates, 0, new ArrayList<>(), result);
        for(List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public void findSubSets_II(int[] arr, int index, List<Integer> currentCombination, List<List<Integer>> result) {
        result.add(new ArrayList<>(currentCombination));
        for(int i = index; i< arr.length; i++) {
            if(i > index && arr[i] == arr[i-1]) {
                continue;
            }
            currentCombination.add(arr[i]);
            findSubSets_II(arr, i+1, currentCombination, result);
            currentCombination.remove((Integer) arr[i]);
        }
    }

    static void selectionSort(int[] arr){
        if(arr == null || arr.length == 0) {
            return;
        }
        for(int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
