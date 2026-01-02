package com.partha.random.heap;

import java.util.*;

public class SmallestRangeCoveringKLists_632 {

    public static void main(String[] args) {
        SmallestRangeCoveringKLists_632 s = new SmallestRangeCoveringKLists_632();
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(4,10,15,24,26));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(0,9,12,20));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(5,18,22,30));
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        s.smallestRange(lists);
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<EachEntry> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        int currentMax = Integer.MIN_VALUE;
        int currentMin = Integer.MAX_VALUE;
        int[] res = new int[2];
        int resMin = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            EachEntry each = new EachEntry(nums.get(i).get(0), i, 0);
            currentMax = Math.max(currentMax, each.value);
            pq.add(each);
        }
        while(true){
            EachEntry top = pq.peek();
            currentMin = top.value;
            int currDiff = currentMax - currentMin;
            if(currDiff < resMin){
                resMin = currDiff;
                res[0] = top.value;
                res[1] = currentMax;
            }
            int advanceList = top.listId;
            int removeIndex = top.index;
            int advanceIndex = removeIndex+1;
            if(advanceIndex >= nums.get(advanceList).size()){
                break;
            }
            int currValueToInsert = nums.get(advanceList).get(advanceIndex);
            currentMax = Math.max(currentMax, currValueToInsert);
            EachEntry currEntry = new EachEntry(currValueToInsert, advanceList, advanceIndex);
            pq.poll();
            pq.add(currEntry);

        }
        return res;

    }


}

class EachEntry{
    int value;
    int listId;
    int index;

    public EachEntry(int value, int listId, int index){
        this.value = value;
        this.listId = listId;
        this.index = index;
    }
}
