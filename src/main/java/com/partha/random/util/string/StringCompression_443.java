package com.partha.random.util.string;

public class StringCompression_443 {

    public static void main(String[] args) {
        StringCompression_443 stringCompression_443 = new StringCompression_443();
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(stringCompression_443.compress(chars));
    }

    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            char curr = chars[i];
            int count = 1;
            while((i+1) < chars.length && curr == chars[i+1]){
                count++;
                i++;
            }
            sb.append(curr);
            if(count > 1){
                sb.append(count);
            }
//            i--;
        }
        return sb.toString().length();
    }
}
