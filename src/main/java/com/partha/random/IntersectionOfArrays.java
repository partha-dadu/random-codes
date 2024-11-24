package com.partha.random;

public class IntersectionOfArrays {
    /**
     * Sorted Arrays
     * [1,2,3,6,7,8,9]
     * [2,4,7,9]
     *
     * Otherwise first you sort them
     * **/
    public static void main(String[] args) {
        int[] first = {1,2,3,6,7,8,9};
        int[] second = {2,4,7,9};
        IntersectionOfArrays intersectionOfArrays = new IntersectionOfArrays();
        int i =0;
        int[] result = intersectionOfArrays.intersectionOfArraysRes(first, second);
        while (i < result.length){
            System.out.println(result[i]);
            i++;
        }
    }

    int[] intersectionOfArraysRes(int[] first, int[] second){
        int i=0;
        int j=0;
        int count=0;
        int[] result = new int[Math.min(first.length,second.length)];
        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                i++;
            }else if(first[i] > second[j]){
                j++;
            }else {
                result[count] = first[i];
                i++;
                j++;
                count++;
            }
        }
        return result;
    }
}
