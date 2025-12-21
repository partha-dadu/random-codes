package com.partha.random.arrays.binarysearch;

public class FindNumberOfRotation_GFG {

    public static void main(String[] args) {
        FindNumberOfRotation_GFG obj = new FindNumberOfRotation_GFG();
        int[] arr = {5,1,2,3,4};
        System.out.println(obj.findKRotation(arr));
    }

    public int findKRotation(int arr[]) {
        // Code here
        if(arr.length == 1){
            return 0;
        }
        int l = 0;
        int r = arr.length-1;
        int ans = Integer.MAX_VALUE;
        int index = 0;
        while(l <= r){
            int mid = (l+r)/2;
            if(arr[l] == arr[mid] && arr[mid] == arr[r]){
                if(arr[l] < ans){
                    index = l;
                }
                l = l+1;
                r= r-1;
                ans = Math.min(ans, arr[mid]);
                continue;
            }
            if(arr[l] <= arr[mid]){
                if(arr[l] < ans){
                    index = l;
                }
                ans = Math.min(ans, arr[l]);
                l = mid+1;
            }else if(arr[mid] <= arr[r]){
                if(arr[mid] < ans){
                    index = mid;
                }
                ans = Math.min(ans, arr[mid]);
                r = mid-1;
            }
        }
        return index;
    }
}
