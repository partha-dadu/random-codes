package com.partha.random.recursion;

public class StringReversal {

    public static void main(String[] args) {
        StringReversal stringReversal = new StringReversal();
        String test = "Hello";
        char[] chars = test.toCharArray();
        stringReversal.reverseString(chars,0);
        System.out.println("String");
        for(int i = 0; i < chars.length; i++){
            System.out.print(chars[i]+" ");
        }
        String palindromeTest = "MADAM";
        System.out.println();
        System.out.println("Is Palindrome "+ stringReversal.isPalindrome(palindromeTest,0));
    }

 public void reverseString(char[] s, int index) {
     if(index >= s.length/2){
         return;
     }
     swapIndexes(s, index, s.length-index-1);
     reverseString(s,index+1);
 }

    public boolean isPalindrome(String s, int index) {
        if(index >= s.length()/2){
            return true;
        }
        if(s.charAt(index) != s.charAt(s.length()-index-1)){
            return false;
        }
        return isPalindrome(s, index+1);
    }

 private void swapIndexes(char[] s, int index1, int index2) {
     char temp = s[index1];
     s[index1] = s[index2];
     s[index2] = temp;
 }
}
