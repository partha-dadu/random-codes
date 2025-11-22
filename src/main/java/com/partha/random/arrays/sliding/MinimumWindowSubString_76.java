package com.partha.random.arrays.sliding;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString_76 {

    public static void main(String[] args) {
        MinimumWindowSubString_76 obj = new MinimumWindowSubString_76();
        String str = "ADOBECODEBANC";
        String target = "ABC";
        obj.minWindow(str, target);
    }

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int count=0;
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i =0; i < n ; i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int l = 0;
        int r=0;
        int minWindow = s.length();
        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                int val = map.get(s.charAt(r));
                if(val == 1){
                    count++;
                }
                val--;
                map.put(s.charAt(r), val);
            }else{
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)-1);
            }
            while(count == n){
                char ch = s.charAt(l);
                int freq = map.get(ch);
                if(freq == 0){
                    count--;
                }
                freq++;
                map.put(ch, freq);

                if(r-l+1 < minWindow){
                    minWindow = Math.min(minWindow, r-l+1);
                    startIndex = l;
                }
                l++;
            }
            r++;

        }
        return minWindow == s.length() ? "" : s.substring(l, r);
    }
}
