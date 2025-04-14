package com.partha.random.leets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfString_46 {

    /***
     * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * Example 2:
     *
     * Input: nums = [0,1]
     * Output: [[0,1],[1,0]]
     *
     * **/

    public static void main(String[] args) {
        PermutationsOfString_46 permutations = new PermutationsOfString_46();
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        permutations.findPermutations(arr, result);
        for(List<Integer> list : result){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public void findPermutations(int[] nums, boolean[] hashes, List<Integer> currentCombination, List<List<Integer>> result){
        if(currentCombination.size() == nums.length){
            result.add(new ArrayList<>(currentCombination));
        }

        for(int i=0; i<nums.length; i++){
            if(!hashes[i]){
                hashes[i] = true;
                currentCombination.add(nums[i]);
                findPermutations(nums, hashes, currentCombination, result);
                currentCombination.remove(currentCombination.size()-1);
                hashes[i] = false;
            }
        }

    }


    public void findPermutations(int[] arr, List<List<Integer>> result){
        boolean[] hashes = new boolean[arr.length];
        for(int i=0; i<hashes.length; i++){
            hashes[i] = false;
        }
        findPermutations(arr, hashes, new ArrayList<>(), result);
    }

    public void findPermutationsOptimal(int[] arr, List<List<Integer>> result){
        optimalSolution(arr,0, result);
    }

    public void optimalSolution(int[] nums, int index, List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> combination = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                combination.add(nums[i]);
            }
            result.add(new ArrayList<>(combination));
        }
        for(int i=index; i<nums.length; i++){
            swap(nums, index, i);
            optimalSolution(nums, index + 1, result);
            swap(nums, index, i);
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
