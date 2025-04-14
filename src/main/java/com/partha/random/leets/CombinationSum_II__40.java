package com.partha.random.leets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II__40 {

    /**
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
     *
     * Each number in candidates may only be used once in the combination.
     *
     * Note: The solution set must not contain duplicate combinations.
     *
     *
     *
     * Example 1:
     *
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * */

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Arrays.sort(candidates);
        List<Integer> currentCombination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        CombinationSum_II__40 combinationSum2 = new CombinationSum_II__40();
        combinationSum2.findCombinationSum2(candidates, 0, target, currentCombination, result);
        for(List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public void findCombinationSum2(int[] candidates, int index, int target, List<Integer> currentCombination, List<List<Integer>> result){
        int currentSum = currentCombination.stream().reduce(0, (a, b) -> (a+b));
        if(currentSum == target){
            result.add(new ArrayList<>(currentCombination));
        }

        for(int start = index; start < candidates.length; start++){
            if(start > index && candidates[start] == candidates[start-1]){
                continue;
            }
            if(candidates[start] > (target-currentSum)){
                break;
            }
            currentCombination.add(candidates[start]);
            findCombinationSum2(candidates, start+1, target, currentCombination, result);
            currentCombination.remove((Integer) candidates[start]);
        }
    }


    public List<List<Integer>> combinationSum2_optimal(int[] candidates, int target){
        selectionSort(candidates); // DSA-based sorting
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }


    private void backtrack(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue; // skip duplicates

            if (candidates[i] > target) break; // pruning optimization

            current.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }

    private void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
