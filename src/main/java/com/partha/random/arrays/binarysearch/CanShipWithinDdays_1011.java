package com.partha.random.arrays.binarysearch;

public class CanShipWithinDdays_1011 {

    public static void main(String[] args) {
        CanShipWithinDdays_1011 leetCode = new CanShipWithinDdays_1011();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(leetCode.shipWithinDays(weights, 5));
        leetCode.canShip(weights, 5, 7);
    }

    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int each : weights){
            if(each < min){
                min = each;
            }
            if(each > max){
                max = each;
            }
            sum += each;
        }
        int l = max;
        int r = sum;
        int ans = 0;
        while(l <= r){
            int mid = (l+r)/2;
            if(canShip(weights, days, mid)){
                r = mid -1;
                ans = mid;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean canShip(int[] weights, int days, int weight){
        int currDays = 1;
        int currWeight = 0;
       for(int each : weights){
            if(currWeight+each > weight){
                currWeight = each;
                currDays++;

            }else{
                currWeight += each;
            }
        }
        return currDays <= days;
    }
}
