package com.partha.random.arrays;

import java.util.Arrays;

public class ValidAnagrams_242 {
    /**
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     *
     * Output: true
     *
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     *
     * Output: false
     * **/

    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        if(Arrays.equals(sChar, tChar)){
            return true;
        }
        return false;
    }
}
