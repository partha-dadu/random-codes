package com.partha.random.leets;

import java.util.ArrayList;
import java.util.List;

public class RandomPickWeight_528 {
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] w = {3,14,1,7};
        RandomPickWeight_528 randomPickWeight528 = new RandomPickWeight_528();
        randomPickWeight528.solution(w);
        System.out.println(randomPickWeight528.pickIndex());
    }
    public void solution(int[] w) {
        int weightSum = 0;

        for(int i=0; i < w.length; i++){
            weightSum = weightSum + w[i];
        }
        for(int i =0; i < w.length; i++){
            int ratio = (int)(((w[i] * 1.0) / weightSum) * 10);
            while ( ratio != 0){
                list.add(i);
                ratio--;
            }
        }
    }

    public int pickIndex() {
        int random = (int)(Math.random() * list.size());
        return list.get(random);
    }
}
