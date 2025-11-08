package com.partha.random.arrays.greedy;

import java.util.Arrays;

public class NMeetingsInOneRoom {

    public static void main(String[] args) {
        int[] start = {25, 0, 14, 24, 18, 3, 17};
        int[] end = {29, 25, 24, 26, 25, 23, 18};
        NMeetingsInOneRoom nm = new NMeetingsInOneRoom();
        nm.maxMeetings(start, end);
    }

    public int maxMeetings(int start[], int end[]) {
        // add your code here
        Meeting[] meetings = new Meeting[start.length];
        for(int i =0; i <start.length; i++){
            Meeting meeting = new Meeting(i, start[i], end[i]);
            meetings[i] = meeting;
        }
        Arrays.sort(meetings, (a, b) -> {if(a.end == b.end) return Integer.compare(a.start, b.start);
        else return Integer.compare(a.end, b.end);
        });
        int startWindow = meetings[0].start;
        int endWindow = meetings[0].end;
        int meetingCount = 1;
        for(int i = 1; i < meetings.length; i++){
            if(meetings[i].start > endWindow){
                meetingCount++;
                endWindow = meetings[i].end;
            }
        }

        return meetingCount;

    }

    class Meeting{
        int index;
        int start;
        int end;

        Meeting(int index, int start, int end){
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}
