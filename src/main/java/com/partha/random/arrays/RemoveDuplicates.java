package com.partha.random.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3,3};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        List<Integer> result = removeDuplicates.removeDuplicates(Arrays.stream(input).boxed().collect(Collectors.toList()));
        result.forEach(System.out::println);
    }

    public List<Integer> removeDuplicates(List<Integer> list){
        List<Integer> result = new ArrayList<>();

        int index = 0;
        while (index < list.size()){
            result.add(list.get(index));
            while(index+1 < list.size() && list.get(index) == list.get(index+1)){
                index++;
            }
            index++;
        }
        return result;
    }

    /**
     * InPlace removal of duplicates and return the length of new Array
     * **/
    public int removeDuplicates1(int[] nums){
        int i= 0 ;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}
