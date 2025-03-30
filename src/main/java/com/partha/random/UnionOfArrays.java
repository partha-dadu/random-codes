package com.partha.random;

import java.util.Arrays;

public class UnionOfArrays {

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
        Arrays.asList(first);
        UnionOfArrays unionOfArrays = new UnionOfArrays();
        int[] result = (unionOfArrays.unionOfArrays(first,second));
        int i = 0;
        while (i < result.length){
            System.out.println(result[i]);
            i++;
        }
    }

    int[] unionOfArrays(int[] first, int[] second){
        int i=0;
        int j=0;
        int count=0;
        int[] result = new int[first.length + second.length];
        while (i < first.length && j < second.length){
            if(first[i] <= second[j]){
                if(count == 0 || result[count-1] != first[i]) {
                    result[count] = first[i];
                    count++;
                }
                i++;
            }else{
                if(count == 0 || result[count-1] != second[j]) {
                    result[count] = second[j];
                    count++;
                }
                j++;
            }

        }

        while (i < first.length){
            if(count == 0 || result[count-1] != first[i]) {
                result[count] = first[i];
                count++;
            }
            i++;
        }

        while (j < second.length){
            if(count == 0 || result[count-1] != second[j]) {
                result[count] = second[j];
                count++;
            }
            j++;
        }

        return result;
    }
}
