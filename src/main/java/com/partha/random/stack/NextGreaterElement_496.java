package com.partha.random.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_496 {

    public static void main(String[] args) {
        NextGreaterElement_496 obj = new NextGreaterElement_496();
        int[] arr = {4, 2, 1 };
        int[] arr2 = {1,3,4,2};
        System.out.println(Arrays.toString(obj.nextGreaterElement(arr, arr2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i =nums2.length-1; i >= 0; i--){
            while(!st.isEmpty() && nums2[i] > st.peek()){
                st.pop();
            }
            if(!st.isEmpty()){
                map.put(nums2[i], st.peek());
            }else{
                map.put(nums2[i], -1);

            }
            st.push(nums2[i]);
        }

        for(int i= 0; i < nums1.length; i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
