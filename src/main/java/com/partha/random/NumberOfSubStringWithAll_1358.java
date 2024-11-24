package com.partha.random;

public class NumberOfSubStringWithAll_1358 {

    /**
     * Input: s = "abcabc"
     * Output: 10
     * Explanation: The substrings containing at least one occurrence of the characters a, b and c are :
     * "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc"
     * */

    public static void main(String[] args) {
        String str = "abcabc";
        NumberOfSubStringWithAll_1358 numberOfSubStringWithAll1358 = new NumberOfSubStringWithAll_1358();
        int result = numberOfSubStringWithAll1358.getNumberOfSubStrings(str);
        System.out.println("Result "+result);
    }

    public int getNumberOfSubStrings(String s){
        int[] lastSeen = {-1, -1, -1};// 0,1,2 represent a,b,c
        char[] array = s.toCharArray();
        int i =0;
        int count=0;
        while(i < array.length){
            switch (array[i]){
                case 'a': lastSeen[0] = i;break;
                case 'b': lastSeen[1] = i;break;
                case 'c': lastSeen[2] = i;break;
            }
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                int min = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                count = count+min+1;
            }
            i++;
        }
        return count;
    }
}
