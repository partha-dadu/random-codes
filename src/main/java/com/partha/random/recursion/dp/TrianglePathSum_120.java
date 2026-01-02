package com.partha.random.recursion.dp;

import java.util.Arrays;
import java.util.List;

public class TrianglePathSum_120 {

        public int minimumTotal(List<List<Integer>> triangle) {
            int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
            for(int[] dpRow : dp){
                Arrays.fill(dpRow, Integer.MAX_VALUE);
            }
            return findMinPathSum(triangle, 0,0, dp);
        }

    private int findMinPathSum(List<List<Integer>> triangle, int row, int col, int[][] dp){
        int outerSize = triangle.size();
        if(row >= outerSize){
            return Integer.MAX_VALUE/2; // Not needed
        }

        int innerSize = triangle.get(row).size();
        if(col >= innerSize){
            return Integer.MAX_VALUE/2; // Not needed this is not a grid, so no need to traverse the other option just stop
        }
        if(row == outerSize -1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }
        int sameIndex = triangle.get(row).get(col) + findMinPathSum(triangle, row+1, col, dp);
        int nextIndex = triangle.get(row).get(col) + findMinPathSum(triangle, row+1, col+1, dp);
        dp[row][col] =  Math.min(sameIndex, nextIndex);
        return dp[row][col];
    }
}
