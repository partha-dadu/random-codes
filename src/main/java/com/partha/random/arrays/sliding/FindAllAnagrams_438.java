package com.partha.random.arrays.sliding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams_438 {

    public static void main(String[] args) {
        FindAllAnagrams_438 obj = new FindAllAnagrams_438();
        String str = "abab";
        String str1 = "ab";
        obj.findAnagrams(str, str1);
    }

    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()){
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<>();
        int l =0;
        int r = p.length();
        char[] inter = p.toCharArray();
        Arrays.sort(inter);
        String sorted = String.valueOf(inter);

        while(l+p.length() <= s.length()){
            String sub = s.substring(l, l+p.length());
            char[] chars = sub.toCharArray();
            Arrays.sort(chars);
            String each = String.valueOf(chars);
            if(each.equals(sorted)){
                list.add(l);
            }
            l++;
        }
        return list;
    }

}
