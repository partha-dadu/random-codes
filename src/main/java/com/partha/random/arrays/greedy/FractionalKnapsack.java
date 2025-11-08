package com.partha.random.arrays.greedy;

import java.util.Arrays;

public class FractionalKnapsack {

    public static void main(String[] args) {
        FractionalKnapsack knap = new FractionalKnapsack();
        int[] val = {8, 2, 10, 1, 9, 7, 2, 6, 4, 9};
        int[] wt = {10 ,1, 7, 7, 5, 1, 8, 6, 8, 7};
        double result = knap.fractionalKnapsack(val, wt, 21);
        System.out.println(result);
        int[][] leetInput = {{5,10},{2,5},{4,7},{3,9}};
        int resultLeet = knap.maximumUnits(leetInput, 10);
        System.out.println(resultLeet);
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        ValueToWeight[] arr = new ValueToWeight[val.length];
        for(int i=0;i<wt.length;i++){
            arr[i] = new ValueToWeight(val[i],wt[i]);

        }
        Arrays.sort(arr, (a, b) -> Double.compare(b.fraction , a.fraction));
        double currentWeightNeeded = capacity;
        int index = 0;
        double totalValue = 0;
        while(currentWeightNeeded > 0 && index < arr.length){
            if(currentWeightNeeded >= arr[index].weight){
                currentWeightNeeded -= arr[index].weight;
                totalValue += arr[index].value;
                index++;
            }else {
                totalValue += arr[index].fraction * currentWeightNeeded;
                currentWeightNeeded = 0;
                index++;
            }
        }

        return totalValue;
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        ValueToWeight[] arr = new ValueToWeight[boxTypes.length];
        for(int i = 0; i < boxTypes.length; i++){
            arr[i] = new ValueToWeight(boxTypes[i][1],boxTypes[i][0]);
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(b.value, a.value));
        int currentBoxNeeded = truckSize;
        int totalUnits = 0;
        int index = 0;
        while(currentBoxNeeded > 0 && index < arr.length){
            if(currentBoxNeeded >= arr[index].weight){
                currentBoxNeeded -= arr[index].weight;
                totalUnits += arr[index].totalValue;
                index++;
            }else{
                totalUnits += arr[index].value * currentBoxNeeded;
                currentBoxNeeded = 0;
                index++;
            }
        }
        return totalUnits;
    }

    class ValueToWeight{
        int value;
        int weight;
        double fraction;
        int totalValue;

        ValueToWeight(int value, int weight){
            this.value = value;
            this.weight = weight;
            this.fraction = value / (double)weight;
            this.totalValue = value * weight;
        }
    }
}
