package com.partha.random.leets;

import java.util.Arrays;
import java.util.List;

public class CountVowelsStringRange_2559 {

    public static void main(String[] args) {
        CountVowelsStringRange_2559 leetCode = new CountVowelsStringRange_2559();
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] ranges = {{0,2},{1,4},{1,1}};
        leetCode.vowelStrings(words, ranges);
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] cache = new int[words.length];
        Arrays.fill(cache, 0);
        int[] res = new int[queries.length];
        int vowelStr = 0;
        List<Character> list = Arrays.asList('a','e','i','o','u');
        for(int i = 0; i < words.length; i++){
            if(list.contains(words[i].charAt(0)) && list.contains(words[i].charAt(words[i].length()-1))){
                vowelStr++;

            }
            cache[i] = vowelStr;
        }
        for(int i =0; i < queries.length; i++){
            int[] each = queries[i];
            int startIndex = each[0];
            int endIndex = each[1];
            int temp = cache[endIndex] - cache[startIndex];
            if(startIndex > 0 && cache[startIndex] > cache[startIndex-1]){
                temp++;
            }


            res[i] = temp;
        }
        return res;
    }
}
