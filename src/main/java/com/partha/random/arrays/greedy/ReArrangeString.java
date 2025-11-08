package com.partha.random.arrays.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ReArrangeString {

    public static void main(String[] args) {
        ReArrangeString reArrangeString = new ReArrangeString();
        String str = "vvloo";
        reArrangeString.reorganizeStringOnline(str);
    }

    public String reorganizeString(String s) {
        int[] hashCount = new int[26];
        Arrays.fill(hashCount, 0);
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int count = hashCount[chars[i] - 'a'];
            count++;
            hashCount[chars[i] - 'a'] = count;
        }

        List<Tuple> tuples = new ArrayList<>();
        PriorityQueue<Tuple> minQ = new PriorityQueue<>((a,b) -> {if(a.count == b.count) return Character.compare(b.ch, a.ch); else return Integer.compare(a.count, b.count);});
        PriorityQueue<Tuple> maxQ = new PriorityQueue<>((a,b) -> {if(a.count == b.count) return Character.compare(a.ch, b.ch); else return Integer.compare(b.count, a.count);});
        for(int i =0; i < hashCount.length; i++){
            if(hashCount[i] > 0){
                Tuple each = new Tuple();
                each.ch = (char)('a'+i);
                each.count= hashCount[i];
                maxQ.offer(each);
                minQ.offer(each);
            }
        }

        char[] arrange = new char[chars.length];
        for(int i = 0; i< chars.length; i++){
            if(i%2 == 0){
                Tuple element = maxQ.poll();
                if(i > 0 && element.ch == arrange[i-1]){
                    return "";
                }
                arrange[i] = element.ch;
                if(element.count == 1){
                    minQ.remove(element);
                }else{
                    int each = element.count;
                    element.count = (each-1);
                    maxQ.offer(element);
                    minQ.remove(element);
                    minQ.offer(element);
                }
            }else{
                Tuple element = minQ.poll();
                if(i > 0 && element.ch == arrange[i-1]){
                    return "";
                }
                arrange[i] = element.ch;
                if(element.count == 1){
                    maxQ.remove(element);
                }else{
                    int each = element.count;
                    element.count = (each-1);
                    minQ.offer(element);
                    maxQ.remove(element);
                    maxQ.offer(element);
                }
            }

        }
        return new String(arrange);
    }

    public String reorganizeStringOnline(String s) {
        int[] hashCount = new int[26];
        Arrays.fill(hashCount, 0);
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int count = hashCount[chars[i] - 'a'];
            count++;
            hashCount[chars[i] - 'a'] = count;
        }

        int maxCount = 0, letterIndex = 0;
        for(int i = 0; i < hashCount.length; i++){
            if(hashCount[i] > maxCount){
                maxCount = hashCount[i];
                letterIndex = i;
            }
        }

        if(maxCount > (s.length() + 1) / 2){
            return "";
        }

        char[] result = new char[chars.length];
        int index = 0;
        while(maxCount > 0){
            result[index] = (char) ('a'+letterIndex) ;
            maxCount--;
            hashCount[letterIndex]--;
            index+=2;
        }

        for(int i = 0; i < hashCount.length; i++){
            while(hashCount[i] > 0){
                if(index >= result.length){
                    index =1;
                }
                result[index] = (char)('a' + i);
                hashCount[i]--;
                index += 2;
            }
        }
        return String.valueOf(result);
    }
}

class Tuple{
    char ch;
    int count;
}
