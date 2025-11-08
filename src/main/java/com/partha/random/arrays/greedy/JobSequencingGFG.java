package com.partha.random.arrays.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class JobSequencingGFG {

    public static void main(String[] args) {
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};
        JobSequencingGFG job = new JobSequencingGFG();
        job.jobSequencing(deadline, profit);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        Job[] jobs = new Job[deadline.length];
        int[] deadlines = new int[deadline.length+1];
        int profitCount = 0;
        int jobCount =0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.fill(deadlines, -1);
        for(int i=0; i < deadline.length; i++){
            Job job = new Job(i,deadline[i], profit[i]);
            jobs[i] = job;
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));
        for(Job each : jobs){
            int checkIndex = each.deadline;
            while(checkIndex > 0){
                if(deadlines[checkIndex] == -1){
                    profitCount += each.profit;
                    jobCount++;
                    deadlines[checkIndex] = 1;
                    break;
                }else{
                    checkIndex--;
                }
            }
        }
        result.add(jobCount);
        result.add(profitCount);
        return result;
    }

    class Job{
        int index;
        int deadline;
        int profit;
        Job(int index, int deadline, int profit){
            this.index = index;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
}
