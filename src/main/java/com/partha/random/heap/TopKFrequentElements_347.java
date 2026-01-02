package com.partha.random.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequentElements_347 {

    public static void main(String[] args) {
        TopKFrequentElements_347 obj = new TopKFrequentElements_347();
        int[] arr = {1,1,1,2,2,3};
        obj.topKFrequent(arr, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int each : nums){
            map.put(each, map.getOrDefault(each, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for(Map.Entry each : map.entrySet()){
            pq.add(each);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            res[index] = pq.poll().getKey();
            index++;
        }
        return res;
    }
}
