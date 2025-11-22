package com.partha.random.arrays.binarysearch;

public class SearchInRotatedArray_33 {

    public static void main(String[] args) {
        SearchInRotatedArray_33 search = new SearchInRotatedArray_33();
        int[] arr = new int[] { 4,5,6,7,0,1,2 };
        search.search(arr, 3);
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low <= high){
            mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] <= nums[high]){
                if(target >= nums[mid] && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target <= nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
        }
        return -1;
    }

}
