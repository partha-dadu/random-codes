package com.partha.random.arrays.binarysearch;

public class FindNthRoot_GFG {

    public static void main(String[] args) {
        FindNthRoot_GFG f = new FindNthRoot_GFG();
        System.out.println(f.findNthElement(1,2));
        System.out.println(Math.ceil((double) 312884470/312884469));
    }

    public int findNthElement(int n, int m){

        int l= 0;
        int r = m;
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int pow = myPow(mid,n);
            if(pow == m){
                return mid;
            }
            if(pow > m){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
    return ans;
    }

    private int myPow(int x, int y){
        long res = 1;
        while(y > 0){
            if(y%2 == 1){
                res = res * x;
                y = y -1;
            }else{
                x = x * x;
                y = y/2;
            }
        }
        return (int)res;
    }
}
