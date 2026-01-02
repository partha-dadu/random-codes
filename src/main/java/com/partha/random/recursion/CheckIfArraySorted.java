package com.partha.random.recursion;

public class CheckIfArraySorted {

    public static void main(String[] args) {
        CheckIfArraySorted checkIfArraySorted = new CheckIfArraySorted();
        int[] nums = {1,2,3,4,5,6};
        System.out.println(checkIfArraySorted.checkIfArraySortedCaller(nums));
        System.out.println(checkIfArraySorted.checkIfArraySortedRecursive(nums,0));
    }

    public boolean checkIfArraySortedCaller(int[] array){
        return checkIfArraySortedRecursiveIteration(array, 1);
    }

    public boolean checkIfArraySortedRecursiveIteration(int[] array, int index){
        if(index == array.length){
            return true;
        }
        if(array[index -1] > array[index]){
            return false;
        }else{
            return checkIfArraySortedRecursiveIteration(array, index+1);
        }
    }
    
    public boolean checkIfArraySortedRecursive(int[] array, int index){
        if(index == array.length-1){
            return true;
        }
        return array[index] <= array[index + 1] && checkIfArraySortedRecursive(array, index+1);
        
    }
}
