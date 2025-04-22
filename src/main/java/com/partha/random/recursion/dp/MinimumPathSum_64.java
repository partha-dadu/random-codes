package com.partha.random.recursion.dp;

import java.util.Arrays;

public class MinimumPathSum_64 {

    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     * Example:
     * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     * Example 2:
     *
     * Input: grid = [[1,2,3],[4,5,6]]
     * Output: 12
     *
     * **/

    public static void main(String[] args) {
        MinimumPathSum_64 obj = new MinimumPathSum_64();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int result = obj.minPathSum(grid);
        System.out.println("Result "+result);
        grid = new int[][]{{1,2,3},{4,5,6}};
        result = obj.minPathSum(grid);
        System.out.println("Result "+result);
        grid = new int[][]{{1,1,1},{1,9,1},{1,9,1}};
        result = obj.minPathSum(grid);

    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return minPathSumRecursive(grid, 0, 0, dp);
    }

    public int minPathSumRecursive(int[][] grid, int m, int n, int[][] dp){
        if(m == grid.length-1 && n == grid[0].length-1){
            return grid[m][n];
        }
        if(m >= grid.length || n >= grid[0].length){
            return 1000;
        }
        else{
             int   left = grid[m][n] + minPathSumRecursive(grid, m+1, n, dp);
             int   right = grid[m][n]  + minPathSumRecursive(grid, m, n+1, dp);
            int result = Math.min(left, right);
            dp[m][n] = result;
            return result;
        }
    }

    public int minPathSumTabulation(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
