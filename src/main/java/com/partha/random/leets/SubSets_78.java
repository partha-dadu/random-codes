package com.partha.random.leets;

import java.util.ArrayList;
import java.util.List;

public class SubSets_78 {

    /**
     * Given an integer array nums of unique elements, return all possible subsets (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *
     * **/

    public static void main(String[] args) {
        SubSets_78 obj = new SubSets_78();
        int[] candidates = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        obj.findSubSets(candidates, 0, new ArrayList<Integer>(), result);
        for(List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public void findSubSets(int[] arr,int index, List<Integer> currentCombinations, List<List<Integer>> result) {
        if(index >= arr.length){
            result.add(new ArrayList<>(currentCombinations));
            return;
        }
        currentCombinations.add(arr[index]);
        findSubSets(arr, index+1, currentCombinations, result);
        currentCombinations.remove((Integer) arr[index]);
        findSubSets(arr, index+1, currentCombinations, result);
    }
}
