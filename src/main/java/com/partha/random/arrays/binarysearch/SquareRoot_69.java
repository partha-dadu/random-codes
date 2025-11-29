package com.partha.random.arrays.binarysearch;

public class SquareRoot_69 {

    public static void main(String[] args) {
        SquareRoot_69 squareRoot_69 = new SquareRoot_69();
        System.out.println(squareRoot_69.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if(x <= 1){
            return x;
        }
        int l = 1;
        int r = x-1;
        int ans = 1;
        while(l <=r){
            int mid = l + (r - l)/2;

            if((long)mid * mid <= (long)x){
                ans = mid;
                l = mid +1;
            }else {
                r = mid -1;
            }
        }
        return ans;
    }
}
