package com.partha.random.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CountSubSequencesWithSumK {
    public static void main(String[] args) {
        CountSubSequencesWithSumK cs = new CountSubSequencesWithSumK();
        int[] arr = {1,2,1,3,5};
        List<Integer> result = new ArrayList<>();
        System.out.println("Count of subsequence "+cs.countSubSequenceSumK(arr, 0, 5, result));
    }

    public int countSubSequenceSumK(int[] arr, int index, int target, List<Integer> result) {
        if(index == arr.length){
            if(result.stream().reduce(0, (a, b) -> a + b ) == target){
                System.out.println();
                result.forEach(e -> System.out.print(" "+e));
                System.out.println();
                return 1;
            }
            return 0;
        }
        result.add(arr[index]);
        int left = countSubSequenceSumK(arr, index+1, target, result);
        result.remove((Integer)arr[index]);
        int right = countSubSequenceSumK(arr, index+1, target, result);
        return left + right;
    }
}
