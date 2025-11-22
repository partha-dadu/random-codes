package com.partha.random.arrays.sliding;

import java.util.PriorityQueue;

public class SlidingWindowMax_239 {

    public static void main(String[] args) {
        SlidingWindowMax_239 slidingWindowMax = new SlidingWindowMax_239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        slidingWindowMax.maxSlidingWindow(nums, k);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(3);
        pq.offer(4);
        pq.offer(3);
        System.out.println(pq);
        int val = pq.poll();
        pq.remove(val);
        System.out.println(pq);

        String str = "abcdfgsgfsdfgd";
        System.out.println(str.substring(0,3));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<EachObject> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.value,a.value));
        int[] result = new int[nums.length - (k-1)];
        EachObject[] arr = new EachObject[nums.length];
        for(int i = 0; i < nums.length; i++){
            EachObject each = new EachObject(nums[i], i);
            arr[i] = each;
        }
        int l = 0;
        int r = 0;
        int index = 0;
        while(r < k){
            pq.add(arr[r]);
            r++;
        }
        result[index] = pq.peek().value;
        index++;
        pq.remove(arr[l]);
        l++;
        while(r < nums.length){
            pq.add(arr[r]);
            result[index] = pq.peek().value;
            index++;
            pq.remove(arr[l]);
            l++;
            r++;



        }
        return result;
    }
}

class EachObject{
    int value;
    int index;

    public EachObject(int value, int index){
        this.value = value;
        this.index = index;
    }
}
