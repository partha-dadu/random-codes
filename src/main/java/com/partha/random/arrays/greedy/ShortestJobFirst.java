package com.partha.random.arrays.greedy;

import java.util.Arrays;

public class ShortestJobFirst {

    public static void main(String[] args) {
        ShortestJobFirst shortestJobFirst = new ShortestJobFirst();
        int[] arr = {4,3,7,1,2};
        System.out.println(shortestJobFirst.solve(arr));
    }

     int solve(int bt[]) {
        // code here
        if(bt.length == 0 || bt.length ==1){
            return 0;
        }
         Arrays.sort(bt);

        int waitingTime = 0;
        int total = 0;
        for(int i =1; i < bt.length ; i++){
            waitingTime += bt[i-1];
            total += waitingTime;
        }

        return total/bt.length;
    }
}
