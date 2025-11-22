package com.partha.random.arrays;

import java.util.*;

public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i=0;i<strs.length;i++){
            char[] sChar = strs[i].toCharArray();
            Arrays.sort(sChar);
            String key = new String(sChar);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>(List.of(strs[i])));
            }else{
                map.get(key).add(strs[i]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> list : map.values()){
            result.add(list);
        }
        return result;
    }
    public List<List<String>> groupAnagrams_practice(String[] strs) {
        List<byte[]> list = new ArrayList<byte[]>();
        for(int i=0;i<strs.length;i++){
            byte[] each = strs[i].getBytes();
            Arrays.sort(each);
            list.add(each);
        }
        List<List<String>> result = new ArrayList<>();
        for(int j=0;j<list.size();j++){
            List<String> temp = new ArrayList<>();
            while(j+1 < list.size() && Arrays.equals(list.get(j),list.get(j+1))){
                temp.add(strs[j]);
                j++;
            }
            result.add(temp);
        }
        return result;
    }
}
