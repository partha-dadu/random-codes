package com.partha.random.recursion;

public class CountOccurences {

    public static void main(String[] args) {
        CountOccurences countOccurences = new CountOccurences();
        int[] array = {1,2,3,4,5,6,7,8,9,10,10};
        System.out.println("Count Occurence -> "+ countOccurences.countOccurences(array, 10, 0));
    }

    public int countOccurences(int[] array, int key, int index){
        if(index == array.length){
            return 0;
        }
        int count = countOccurences(array, key, index+1);
        if(key == array[index]){
            return count + 1;
        }
        return count;
    }
}
