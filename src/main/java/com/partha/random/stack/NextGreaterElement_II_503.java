package com.partha.random.stack;

import java.util.Stack;

public class NextGreaterElement_II_503 {

    public static void main(String[] args) {
        NextGreaterElement_II_503 obj = new NextGreaterElement_II_503();
        int[] arr = {1,2,1};
        obj.nextGreaterElements(arr);
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int big = 2*n;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = big-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i%n]){
                st.pop();
            }
            if(i < n){
                if(st.isEmpty()){
                    result[i] = -1;
                }else{
                    result[i] = st.peek();
                }
            }
            st.push(nums[i%n]);
        }
        return result;
    }
}
