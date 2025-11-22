package com.partha.random.arrays.sliding;

import java.util.Arrays;

public class PermutationOfString_567 {

    public static void main(String[] args) {
        PermutationOfString_567 obj = new PermutationOfString_567();
        obj.checkInclusion("ab","eidbaooo");
    }

    public boolean checkInclusion(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        String checker = String.valueOf(chars);
        char[] second = s2.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while(r < second.length){
            String subs = s2.substring(l, r+1);
            char[] each =  subs.toCharArray();
            Arrays.sort(each);
            if(checker.equals(String.valueOf(each))){
                return true;
            }
            l++;
            r++;
        }
        return false;
    }
}
