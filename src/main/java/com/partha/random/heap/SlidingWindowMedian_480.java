package com.partha.random.heap;

import java.util.*;

public class SlidingWindowMedian_480 {

    public static void main(String[] args) {
        SlidingWindowMedian_480 test = new SlidingWindowMedian_480();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(test.medianSlidingWindow(arr, k)));
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        Map<Integer, Integer> pruning = new HashMap<>();
        int l = 0;
        int r = 0;
        int leftSize = 0;
        int rightSize = 0;
        double[] res = new double[nums.length-k+1];
        int index = 0;
        while(r < nums.length){
            if(left.isEmpty()){
                left.add(nums[r]);
                leftSize++;
            }else if(checkAndPeek(left, pruning) >= nums[r]){
                left.add(nums[r]);
                leftSize++;
            }else{
                right.add(nums[r]);
                rightSize++;
            }
            if(leftSize > rightSize+1){
                checkAndPeek(left, pruning);
                right.add(left.poll());
                rightSize++;
                leftSize--;
            }else if(rightSize > leftSize){
                checkAndPeek(right, pruning);
                left.add(right.poll());
                leftSize++;
                rightSize--;
            }
            if(r-l+1 == k){
                if(leftSize > rightSize){
                    res[index] = checkAndPeek(left, pruning);
                }else{
                    int middle1 = checkAndPeek(left, pruning);
                    int middle2 = checkAndPeek(right, pruning);
                    double median = (middle1+middle2*1.0)/2.0;
                    res[index] = median;
                }
                index++;
                if(nums[l] <= checkAndPeek(left, pruning)){
                    leftSize--;
                }else{
                    rightSize--;
                }
                pruning.put(nums[l], pruning.getOrDefault(nums[l],0)+1);
                l++;
                cleanTop(left, pruning);
                cleanTop(right, pruning);
                if(leftSize > rightSize+1){
                    checkAndPeek(left, pruning);
                    right.add(left.poll());
                    rightSize++;
                    leftSize--;
                }else if(rightSize > leftSize){
                    checkAndPeek(right, pruning);
                    left.add(right.poll());
                    leftSize++;
                    rightSize--;
                }
            }
            r++;
        }
        return res;
    }

    private int checkAndPeek(PriorityQueue<Integer> heap, Map<Integer, Integer> pruning){
        cleanTop(heap, pruning);
        int curr = heap.peek();
        return curr;
    }

    private void cleanTop(PriorityQueue<Integer> heap, Map<Integer, Integer> pruning){
        while (!heap.isEmpty()) {
            Integer top = heap.peek();
            if (pruning.containsKey(top)) {
                int cnt = pruning.get(top);
                if (cnt == 1) pruning.remove(top);
                else pruning.put(top, cnt - 1);
                heap.poll();
            } else break;
        }
    }

    public double[] medianSlidingWindowAI(int[] nums, int k) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        Map<Integer, Integer> pruning = new HashMap<>();

        int l = 0, r = 0;
        int leftSize = 0, rightSize = 0;

        double[] res = new double[nums.length - k + 1];
        int index = 0;

        while (r < nums.length) {

            // ---------- PHASE 1: insert ----------
            if (leftSize == 0) {
                left.add(nums[r]);
                leftSize++;
            } else if (nums[r] <= checkAndPeekAI(left, pruning)) {
                left.add(nums[r]);
                leftSize++;
            } else {
                right.add(nums[r]);
                rightSize++;
            }

            // ---------- PHASE 2: rebalance ----------
            if (leftSize > rightSize + 1) {
                checkAndPeekAI(left, pruning);
                right.add(left.poll());
                leftSize--;
                rightSize++;
            } else if (rightSize > leftSize) {
                checkAndPeekAI(right, pruning);
                left.add(right.poll());
                rightSize--;
                leftSize++;
            }

            // ---------- PHASE 3–6: window formed ----------
            if (r - l + 1 == k) {

                // ---------- read median ----------
                if (leftSize > rightSize) {
                    res[index++] = checkAndPeekAI(left, pruning);
                } else {
                    double m1 = checkAndPeekAI(left, pruning);
                    double m2 = checkAndPeekAI(right, pruning);
                    res[index++] = (m1 + m2) / 2.0;
                }

                // ---------- logical removal ----------
                int out = nums[l];
                if (out <= checkAndPeekAI(left, pruning)) {
                    leftSize--;
                } else {
                    rightSize--;
                }
                pruning.put(out, pruning.getOrDefault(out, 0) + 1);
                l++;

                // ---------- cleanup ----------
                cleanTopAI(left, pruning);
                cleanTopAI(right, pruning);

                // ---------- rebalance again ----------
                if (leftSize > rightSize + 1) {
                    cleanTopAI(left, pruning);
                    right.add(left.poll());
                    leftSize--;
                    rightSize++;
                } else if (rightSize > leftSize) {
                    cleanTopAI(right, pruning);
                    left.add(right.poll());
                    rightSize--;
                    leftSize++;
                }
            }

            r++;
        }
        return res;
    }

    private int checkAndPeekAI(PriorityQueue<Integer> heap, Map<Integer, Integer> pruning) {
        cleanTopAI(heap, pruning);
        return heap.peek();
    }

    private void cleanTopAI(PriorityQueue<Integer> heap, Map<Integer, Integer> pruning) {
        while (!heap.isEmpty()) {
            Integer top = heap.peek();
            if (pruning.containsKey(top)) {
                int cnt = pruning.get(top);
                if (cnt == 1) pruning.remove(top);
                else pruning.put(top, cnt - 1);
                heap.poll();
            } else break;
        }
    }
}
