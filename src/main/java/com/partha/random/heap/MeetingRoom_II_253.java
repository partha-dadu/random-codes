package com.partha.random.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom_II_253 {

    public static void main(String[] args) {
        MeetingRoom_II_253 m = new MeetingRoom_II_253();
        int[] start = {1 ,10, 7};
        int[] end = {4,15,10};
        m.minMeetingRooms(start, end);
    }

    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        int maxheapSize = 0;
        Each[] eachlist = new Each[start.length];
        PriorityQueue<Each> pq = new PriorityQueue<>((a, b) -> {if(a.end == b.end) return Integer.compare(a.start, b.start);
        else return Integer.compare(a.end, b.end);
        });
        for(int i = 0; i < start.length; i++){
            eachlist[i] = new Each(start[i], end[i]);
        }
        Arrays.sort(eachlist, (a,b) -> Integer.compare(a.start, b.start));
        for(Each each : eachlist){
            if(!pq.isEmpty()){
                if(pq.peek().end <= each.start){
                    pq.poll();
                }
            }
            pq.add(each);
            maxheapSize = Math.max(maxheapSize, pq.size());
        }
        return maxheapSize;
    }

    class Each{
        public int start;
        public int end;

        public Each(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
