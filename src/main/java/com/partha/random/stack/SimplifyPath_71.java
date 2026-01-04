package com.partha.random.stack;

import java.util.*;

public class SimplifyPath_71 {

    public static void main(String[] args) {
        SimplifyPath_71 s = new SimplifyPath_71();
        String str = "/home//..//";
        s.simplifyPath(str);
    }

    public String simplifyPath(String path) {
        String prevDir = "..";
        String forSlash = "/";
        Deque<String> dq = new ArrayDeque<String>();
        char[] chars = path.toCharArray();
        int i = 0;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(i < chars.length){
            if(i == 0 && chars[i] == '/'){
                i++;
                continue;
            }
            if(chars[i] != '/'){
                sb.append(chars[i]);
                i++;
            }else if(sb.length() == 0){
                i++;
                continue;
            }else{
                i++;
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return null;
    }
}
