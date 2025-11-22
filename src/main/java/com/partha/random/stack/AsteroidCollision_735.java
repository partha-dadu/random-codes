package com.partha.random.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision_735 {

    public static void main(String[] args) {
        AsteroidCollision_735 a = new AsteroidCollision_735();
        int[] arr = {3,5,-6,2,-1,4};
        a.asteroidCollision(arr);
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < asteroids.length; i++){
            if(st.isEmpty()){
                st.push(asteroids[i]);
            }else{
                if((asteroids[i] < 0 && st.peek() >0) || (asteroids[i] >0 && st.peek() < 0)){
                    boolean collision = false;
                    while(!st.isEmpty() && Math.abs(asteroids[i]) > Math.abs(st.peek())){


                        st.pop();

                    }
                    if (!st.isEmpty() && Math.abs(asteroids[i]) == Math.abs(st.peek())) {
                        st.pop();
                        continue;
                    }

                    if(!st.isEmpty() && st.peek() < 0 && asteroids[i] < 0){
                        st.push(asteroids[i]);
                    }
                    if(!st.isEmpty() && st.peek() >0 && asteroids[i] >0){
                        st.push(asteroids[i]);
                    }
                    if(st.isEmpty()){
                        st.push(asteroids[i]);
                    }



                }else{
                    st.push(asteroids[i]);
                }
            }
        }
        return Arrays.stream(st.toArray(new Integer[0])).mapToInt(i -> i).toArray();
    }
}
