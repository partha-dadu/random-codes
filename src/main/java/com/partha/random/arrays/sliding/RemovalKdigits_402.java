package com.partha.random.arrays.sliding;

import java.util.Stack;

public class RemovalKdigits_402 {

    public static void main(String[] args) {
        RemovalKdigits_402 r = new RemovalKdigits_402();
        String s = "10200";
        int k = 1;
        r.removeKdigits(s, k);
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        char[] chars = num.toCharArray();
        for(int i = 0; i < chars.length; i++){
            while(!st.isEmpty() && k > 0 && st.peek() > chars[i]){
                st.pop();
                k--;
            }
            st.push(chars[i]);
        }

        while( k > 0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        if(st.isEmpty()){
            return "0";
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        String result = sb.toString().isEmpty() ? "0" : sb.toString().replaceAll("0+$", "").isEmpty() ? "0" : new StringBuilder(sb.toString().replaceAll("0+$", "")).reverse().toString();
        return result;
    }
}
