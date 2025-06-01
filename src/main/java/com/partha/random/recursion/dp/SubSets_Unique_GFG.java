package com.partha.random.recursion.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SubSets_Unique_GFG {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,3,3,4};
        SubSets_Unique_GFG obj = new SubSets_Unique_GFG();
        obj.findUniqueSubSets_Sum_K(nums, 0, 7, new Stack<Integer>());
    }

    public void findUniqueSubSets_Sum_K(int[] nums, int index, int target, Stack<Integer> cache){
        if(target == 0){
            System.out.println(cache.toString());
            return;
        }
        if(index == nums.length-1 && target == nums[index]){
            cache.add(nums[index]);
            System.out.println(cache.toString());
            return;
        }
        if(index == nums.length){
            return;
        }

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            if( nums[i] <= target) {
                cache.add(nums[i]);
                findUniqueSubSets_Sum_K(nums, i + 1, target - nums[i], cache);
//                cache.remove(cache.size() - 1);
                cache.pop();
            }
        }
    }

}
