package com.partha.random.arrays.binarysearch;

public class KthMissingInteger_1539 {

    public static void main(String[] args) {
        KthMissingInteger_1539 k = new KthMissingInteger_1539();
        int[] arr = {2};
        k.findKthPositive(arr, 1);
    }

    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            int missing = arr[mid]- (mid+1);
            if(missing >= k){
                r = mid -1;
            }else{
                l = mid +1;
            }
        }
        return (r+k+1);
    }
}
