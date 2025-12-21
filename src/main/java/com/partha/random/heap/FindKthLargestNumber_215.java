package com.partha.random.heap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class FindKthLargestNumber_215 {
    public static void main(String[] args) {
        FindKthLargestNumber_215 f = new FindKthLargestNumber_215();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k = 3;
        f.findKthLargest(arr, k);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int each : nums){
            if(pq.size() > 0 && each < pq.peek()){
                if(pq.size() == k){
                    pq.poll();
                }
                pq.add(each);
            }
        }
        return pq.peek();
    }
}
