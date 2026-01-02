package com.partha.random.recursion;

public class FindFirstOccurance {

    public static void main(String[] args) {
        FindFirstOccurance f = new FindFirstOccurance();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(f.firstOccuranceRecursiveIteration(nums, 14, 0));
    }


    public int firstOccuranceRecursiveIteration(int[] array, int value, int index){
        if(index == array.length){
            return -1;
        }
        if(array[index] == value){
            return index;
        }
        return firstOccuranceRecursiveIteration(array, value, index+1);
    }

    public int firstOccuranceRecursively(int[] array, int value, int index){
        if(index == array.length){
            return -1;
        }
        int recursiveResult = firstOccuranceRecursively(array, value, index+1);
        if(array[index] == value){
            return index;
        }
        return recursiveResult;
    }
}
