package com.partha.random.recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllSubSequenceOfArray {
    public static void main(String[] args) {
        FindAllSubSequenceOfArray findAllSubSequenceOfArray = new FindAllSubSequenceOfArray();
        int[] arr = {3,1,2};
        List<Integer> result = new ArrayList<>();
        findAllSubSequenceOfArray.printAllSubSequenceOfArray(arr, 0, result);
    }

    public void printAllSubSequenceOfArray(int[] arr, int index, List<Integer> result) {

        if(index == arr.length) {
            System.out.println();
            Arrays.asList(result).forEach(each -> System.out.print(each + " "));
            return;
        }

        result.add(arr[index]);
        printAllSubSequenceOfArray(arr, index + 1, result);
        result.remove((Integer) arr[index]);
        printAllSubSequenceOfArray(arr, index + 1, result);
    }
}
