package com.partha.random.leets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    /**
     * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     *
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
     *
     * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
     *
     *
     *
     * Example 1:
     *
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     * */

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        CombinationSum_39 combinationSum39 = new CombinationSum_39();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        combinationSum39.combinationSum(candidates, target, currentCombination, result);
        for(List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target,List<Integer> currentCombination, List<List<Integer>> result) {
        Arrays.sort(candidates);
        return findCombinations(candidates, target, 0, currentCombination, result);
//        return result;
    }

    public List<List<Integer>> findCombinations(int[] candidates, int target, int index, List<Integer> currentCombination, List<List<Integer>> result) {
        int currentSum = currentCombination.stream().reduce(0, (a,b) -> a+b);

        if(index >= candidates.length) {
            if(currentSum == target) {
                result.add(new ArrayList<>(currentCombination));
            }
            return result;
        }
        if(candidates[index] <= (target-currentSum)){
            currentCombination.add(candidates[index]);
            findCombinations(candidates, target, index, currentCombination, result);
            currentCombination.remove((Integer) candidates[index]); // Backtrack
        }
            findCombinations(candidates, target, index + 1, currentCombination, result);
        return result;
    }

    public void findCombinations1(int[] candidates, int target, int index, List<Integer> currentCombination, List<List<Integer>> result) {
        int currentSum = currentCombination.stream().reduce(0, (a,b) -> a+b);
        if(currentSum > target){
            return;
        }
        if(currentSum == target) {
            result.add(new ArrayList<>(currentCombination));
        }
        if(index >= candidates.length) {
            if(currentSum == target) {
                result.add(new ArrayList<>(currentCombination));
            }
            return ;
        }
        for (int i = index; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            findCombinations1(candidates, target, i, currentCombination, result);
            currentCombination.remove((Integer) candidates[i]); // Backtrack
        }
    }
}
