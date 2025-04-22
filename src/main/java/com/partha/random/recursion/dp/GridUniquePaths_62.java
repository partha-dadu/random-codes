package com.partha.random.recursion.dp;

public class GridUniquePaths_62 {

    /**
     * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
     *
     * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     *
     * Example 1:
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation:
     * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down
     * 2. Right -> Down -> Right
     * 3. Down -> Right -> Right
     * Example 2:
     * Input: m = 7, n = 3
     * Output: 28
     *
     *
     * **/

    public static void main(String[] args) {
        GridUniquePaths_62 obj = new GridUniquePaths_62();
        int result = obj.findUniquePathsTabulation(3, 3);
        System.out.println("Result "+result);
    }

    public int findUniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return findUniquePaths(m, n, 0, 0, dp);
    }

    public int findUniquePaths(int m, int n, int row, int col, int[][] dp) {
        if(row == m-1 && col == n-1){
            return 1;
        }
        if(row >= m || col >= n){
            return 0;
        }
        if(dp[row][col] != 0){
            return dp[row][col];
        }
        int result = findUniquePaths(m, n, row+1, col, dp) + findUniquePaths(m, n, row, col+1, dp);
        dp[row][col] = result;
        return result;

    }

    public int findUniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    dp[0][0] = 1;
                }else {
                    int down = 0;
                    int right = 0;
                    if (i > 0) {
                        down = dp[i - 1][j];
                    }
                    if (j > 0) {
                        right = dp[i][j - 1];
                    }
                    dp[i][j] = down + right;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int findUniquePathsGenerated(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                System.out.println("dp["+i+"]["+j+"] = "+dp[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
