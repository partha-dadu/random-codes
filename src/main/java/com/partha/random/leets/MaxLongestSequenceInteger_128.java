package com.partha.random.leets;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MaxLongestSequenceInteger_128 implements Serializable {


    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     *
     * You must write an algorithm that runs in O(n) time.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * **/

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        MaxLongestSequenceInteger_128 maxLongestSequenceInteger128 = new MaxLongestSequenceInteger_128();
        System.out.println(maxLongestSequenceInteger128.findLongestSequence(nums));
    }
    public int findLongestSequence(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        //another iteration processing each element
        int i = 0;
        int maxlength = 1;
        while(i < nums.length){
            // check if previous item is there in the set or not
            // if not there then only a sequence can start here
            if(!set.contains(nums[i] - 1)){
                // check for the next element
                int j= 1;
                int newLength =1;
                while(set.contains(nums[i] +j)){
                    maxlength = Math.max(maxlength, newLength+j);
                    j++;
                }
            }
            i++;
        }
        return maxlength;
    }
}
