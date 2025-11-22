package com.partha.random.arrays.sliding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindTwoStringsClose_1657 {

    public static void main(String[] args) {
        FindTwoStringsClose_1657 sol = new FindTwoStringsClose_1657();
        String str = "cabbba";
        String str1 = "abbccc";
        System.out.println(sol.closeStrings(str,str1));
    }

    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        int[] word1hash = new int[26];
        int[] word2hash = new int[26];
        Arrays.fill(word1hash, 0);
        Arrays.fill(word2hash, 0);
        List<Integer> word1set = new ArrayList<>();
        List<Integer> word2set = new ArrayList<>();

        for(int i = 0; i < word1.length(); i++){
            word1hash[word1.charAt(i) - 'a']++;
            word2hash[word2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < word1hash.length; i++){
            if((word1hash[i] == 0 && word2hash[i] != 0) ||
                    word2hash[i] == 0 && word1hash[i] != 0){
                return false;
            }
            if(word1hash[i] > 0){
                word1set.add(word1hash[i]);
            }
            if(word2hash[i] > 0){
                word2set.add(word2hash[i]);
            }
        }
        Collections.sort(word1set);
        Collections.sort(word2set);


        return word1set.equals(word2set);
    }
}
