package com.partha.random.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubSequenceWithSumK {

    public static void main(String[] args) {
        FindAllSubSequenceWithSumK findAllSubSequenceWithSumK = new FindAllSubSequenceWithSumK();
        int[] arr = {1,2,1,3,5};
        List<Integer> result = new ArrayList<>();
        findAllSubSequenceWithSumK.findAllSubSequenceSumK(arr, 0,result, 4);
    }

    public void findAllSubSequenceSumK(int[] arr, int index, List<Integer> result, int target) {
        if(index == arr.length){
            if(result.stream().reduce(0, (a,b)->a+b) == target){
                System.out.println();
                result.forEach(e -> System.out.print(" "+e));
            }
            return;
        }

        result.add( arr[index]);
        findAllSubSequenceSumK(arr, index+1, result, target);
        result.remove((Integer) arr[index]);
        findAllSubSequenceSumK(arr, index+1, result, target);

    }
}
