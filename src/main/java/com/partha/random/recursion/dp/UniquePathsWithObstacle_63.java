package com.partha.random.recursion.dp;

import java.util.Arrays;

public class UniquePathsWithObstacle_63 {

    /**
     * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
     *
     * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
     *
     * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     *
     * Example 1:
     * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * Output: 2
     * Explanation: There is one obstacle in the middle of the 3x3 grid above.
     * There are two ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down -> Down
     * 2. Down -> Down -> Right -> Right
     * */
    public static void main(String[] args) {
        UniquePathsWithObstacle_63 obj = new UniquePathsWithObstacle_63();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int result = obj.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Result "+result);
        obstacleGrid = new int[][]{{0,1},{0,0}};
        result = obj.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Result "+result);
        obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0},{0,0,0}};
        result = obj.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Result "+ result);
    }

    public int uniquePathsWithObstaclesRecursive(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return findUniquePathsWithObstaclesFresh(obstacleGrid, m, n, 0, 0, dp);
    }

    public int findUniquePathsWithObstaclesFresh(int[][] obstacleGrid,int m, int n, int row, int col, int[][] dp) {

        if(row >= m || col >= n){
            return 0;
        }
        if(obstacleGrid[row][col] == 1){
            return 0;
        }
        if(row == m-1 && col == n-1){
            return 1;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        dp[row][col] = findUniquePathsWithObstaclesFresh(obstacleGrid, m, n, row+1, col, dp) + findUniquePathsWithObstaclesFresh(obstacleGrid, m, n, row, col+1, dp);
        return dp[row][col];
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, dp);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col, int[][] dp) {
        if(row == obstacleGrid.length-1 && col == obstacleGrid[0].length-1){
            return 1;
        }
        if(row >= obstacleGrid.length || col >= obstacleGrid[0].length){
            return 0;
        }
        if(obstacleGrid[row][col] == 1){
            return 0;
        }

        int down = uniquePathsWithObstacles(obstacleGrid, row+1, col, dp);
        int right = uniquePathsWithObstacles(obstacleGrid, row, col+1, dp);
        dp[row][col] = down + right;
        return dp[row][col];
    }

    public int uniquePathsWithObstaclesTabulation(int[][] obstacleGrid){
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else {
                    int left = 0;
                    int up = 0;
                    if(j > 0){
                        left = dp[i][j-1];
                    }
                    if(i > 0){
                        up = dp[i-1][j];
                    }
                    dp[i][j] = left + up;
                    System.out.println("dp["+i+"]["+j+"] = "+dp[i][j]);
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
