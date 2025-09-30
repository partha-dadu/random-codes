package com.partha.random.arrays;

import java.util.Arrays;

public class RightRotateByK_Places {


    public static void main(String[] args) {
        RightRotateByK_Places r = new RightRotateByK_Places();
        int[] input = new int[]{-1,-100,3,99};
        r.rightRotateByK_Places(input, 2);
        Arrays.stream(input).forEach(System.out::println);
    }
    public void rightRotateByK_Places(int [] nums, int k){
        int len = nums.length;
        int resultRotate = k % len;
        if(resultRotate == 0){
            return;
        }
        int[] temp = new int[resultRotate];
        for(int i = len-k, j=0; i < len; i++, j++){
            temp[j] = nums[i];
        }
        for(int i= len-k-1, j = len-1; i >= 0; i--,j-- ){
            nums[j] = nums[i];
        }

        for(int i= 0 ; i < temp.length; i++){
            nums[i] = temp[i];
        }

    }
}
