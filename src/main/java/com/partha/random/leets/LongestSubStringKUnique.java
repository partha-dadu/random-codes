package com.partha.random.leets;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringKUnique {

    public static void main(String[] args) {
        LongestSubStringKUnique solution = new LongestSubStringKUnique();
        String str = "mlg";
        int k = 1;
        solution.longestKSubstr(str, k);
    }

    public int longestKSubstr(String s, int k) {
        // code here
        if(k > s.length()){
            return -1;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = -1;
        int l = 0;
        int r = 0;
        while(r < chars.length){
            map.put(chars[r], map.getOrDefault(chars[r], 0)+1);
            if(map.size() > k){
                if(map.get(chars[l]) == 1){
                    map.remove(chars[l]);
                }else{
                    map.put(chars[l], map.get(chars[l]) -1);
                }
                l++;
            }
            if(map.size() == k){
                maxLength = Math.max(maxLength, r-l+1);
            }
            r++;
        }
        return maxLength;

    }
}
