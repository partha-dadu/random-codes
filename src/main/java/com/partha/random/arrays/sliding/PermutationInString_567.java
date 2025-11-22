package com.partha.random.arrays.sliding;

import java.util.Arrays;

public class PermutationInString_567 {

    public static void main(String[] args) {
        PermutationInString_567 permutation = new PermutationInString_567();
        String s1 = "adc";
        String s2 = "dcda";
        permutation.checkInclusion(s1,s2);
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] chars = new int[26];
        Arrays.fill(chars, -1);
        int count = 0;
        for(char each : s1.toCharArray()){
            if(chars[each - 'a'] == -1){
                chars[each - 'a'] = 1;
                count++;
            }
            else
                chars[each-'a']++;
        }
        int l = 0;
        int r = 0;
        while(r < s2.length()){
            if(r-l+1 > s1.length()){
                if(chars[s2.charAt(l) - 'a'] == 0){
                    count++;
                }
                chars[s2.charAt(l) - 'a']++;
                l++;
            }
            if(chars[s2.charAt(r) - 'a'] > 0){
                if(chars[s2.charAt(r) - 'a'] == 1){
                    count--;

                }
                chars[s2.charAt(r) - 'a']--;
            }
            if(r-l+1 == s1.length() && count == 0){
                return true;
            }
            r++;
        }
        return false;
    }
}
