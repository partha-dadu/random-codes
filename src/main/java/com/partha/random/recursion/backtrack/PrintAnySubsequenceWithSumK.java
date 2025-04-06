package com.partha.random.recursion.backtrack;

import java.util.List;

public class PrintAnySubsequenceWithSumK {

    public boolean findAnySubSequenceSumK(int[] arr, int index, int target, List<Integer> result) {
        if(index == arr.length){
            if(result.stream().reduce(0, (a,b)->a+b) == target){
                System.out.println();
                result.forEach(e -> System.out.print(" "+e));
                return true;
            }
        }
        result.add(arr[index]);
        if(findAnySubSequenceSumK(arr, index+1, target, result) == true){
            return true;
        }
        result.remove(result.size()-1);
        if(findAnySubSequenceSumK(arr, index+1, target, result)  == true){
            return true;
        }
        return false;
    }
}
