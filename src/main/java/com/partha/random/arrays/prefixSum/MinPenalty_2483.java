package com.partha.random.arrays.prefixSum;

public class MinPenalty_2483 {

    public static void main(String[] args) {
        MinPenalty_2483 m = new MinPenalty_2483();
        String str = "YYNY";
        m.bestClosingTime(str);
    }

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] preN = new int[n+1];
        int[] sufY = new int[n+1];
        // if I close in the beginning then only N penalty
        preN[0] = 0;
        for(int i = 1; i < preN.length; i++){
            preN[i] = preN[i-1]+ customers.charAt(i-1) == 'N' ? 1 : 0;
        }

        sufY[n] = 0;
        for(int i = n-1; i >= 0 ; i--){
            sufY[i] = sufY[i+1]+ customers.charAt(i) == 'Y'? 1 : 0;
        }

        int minPenalty = Integer.MAX_VALUE;
        int early = -1;
        for(int i = 0; i < preN.length; i++){
            int penalty = preN[i] + sufY[i];
            if(minPenalty > penalty){
                minPenalty = penalty;
                early = i;
            }
        }
        return early;
    }
}
