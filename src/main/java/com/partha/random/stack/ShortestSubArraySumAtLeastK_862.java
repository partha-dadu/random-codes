package com.partha.random.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubArraySumAtLeastK_862 {

    public static void main(String[] args) {
        ShortestSubArraySumAtLeastK_862 s = new ShortestSubArraySumAtLeastK_862();
        int[] nums = {17,85,93,-45,-21};
        int k = 150;
        s.shortestSubarray(nums, k);
    }

    public int shortestSubarray(int[] nums, int k) {
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0] = 0;
        Deque<EachEntry> dq = new ArrayDeque<>();
        int maxLen = 1000000;
        for(int i = 0; i < nums.length; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        for(int i = 0; i < prefixSum.length; i++){
            if(dq.isEmpty()){
                dq.addLast(new EachEntry(prefixSum[i], i));
            }else{

                while(!dq.isEmpty()){
                    if(prefixSum[i] < dq.peekLast().value){
                        dq.pollLast();
                    }else{
                        break;
                    }
                }
                while(!dq.isEmpty()){
                    EachEntry first = dq.peekFirst();
                    if(prefixSum[i] - first.value >= k){
                        maxLen = Math.min(maxLen, i - first.index);
                        dq.pollFirst();
                    }else{
                        break;
                    }
                }
                dq.addLast(new EachEntry(prefixSum[i], i));
            }
        }
        return maxLen == 1000000 ? -1 : maxLen;

    }
}

class EachEntry{
    int value;
    int index;

    public EachEntry(int value, int index){
        this.value = value;
        this.index = index;
    }
}
