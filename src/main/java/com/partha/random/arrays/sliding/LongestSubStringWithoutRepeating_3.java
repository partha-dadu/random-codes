package com.partha.random.arrays.sliding;

import java.util.Arrays;

public class LongestSubStringWithoutRepeating_3 {

    public static void main(String[] args) {
        LongestSubStringWithoutRepeating_3 obj = new LongestSubStringWithoutRepeating_3();
        System.out.println(obj.lengthOfLongestSubstring("tmmzuxt"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int length = 0;
        int maxLength = Integer.MIN_VALUE;
        int[] hash = new int[256];

        char[] chars = s.toCharArray();
        Arrays.fill(hash, -1);
        int l=0, r = 0;
        while ( r < chars.length){
            if(hash[chars[r]] == -1){
                hash[chars[r]] = r;
                length = r -l + 1;
                maxLength = Math.max(maxLength, length);
            }else {
                int temp = hash[chars[r]];
                while(l <= hash[chars[r]]){
                    hash[chars[l]] = -1;
                    l++;
                }
                l = temp + 1;
                hash[chars[r]] = r;
            }
            r++;
        }
        return maxLength;
    }
}
