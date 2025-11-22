package com.partha.random.arrays.sliding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithExactKUnique {

    public static void main(String[] args) {
        LongestSubArrayWithExactKUnique l = new LongestSubArrayWithExactKUnique();
        String str = "aabacbebebe";
        l.longestKSubstr(str, 3);

    }

    public int longestKSubstr(String s, int k) {
        // code here
        if(k > s.length()){
            return -1;
        }
        int maxLength = -1;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while(r < s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if(map.keySet().size() == k){
                maxLength = Math.max(maxLength, r-l+1);
            }else if(map.size() > k){
                while(map.size() > k){
                    if(map.get(s.charAt(l)) == 1){
                        map.remove(s.charAt(l));
                    }else{
                        map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    }
                    l++;
                }
            }
            r++;
        }
        return maxLength;
    }
}
