package com.partha.random.arrays.sliding;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater rainWater = new TrappingRainWater();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int result = rainWater.trap(height);
    }

    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxL = 0;
        int maxR = 0;
        int waterTrap = 0;

        while(l < r){
            maxL = Math.max(height[l], maxL);
            maxR = Math.max(height[r], maxR);

            if(maxL < maxR){
                int min = Math.max(maxL, height[l]);
                int waterRetainl = min - height[l];
                if(waterRetainl > 0){
                    waterTrap += waterRetainl;
                }
                l++;
            }else{
                int min = Math.max(height[r], maxR);
                int waterRetainr = min - height[r];

                if(waterRetainr > 0){
                    waterTrap += waterRetainr;
                }
                r--;

            }
        }
        return waterTrap;
    }
}
