package com.partha.random.recursion.dp;

import java.util.Arrays;

public class MinimumFallingPathSum_931 {

        public int minFallingPathSum(int[][] matrix) {
            int result = Integer.MAX_VALUE;
            int[][] dp = new int[matrix.length][matrix[0].length];
            for(int[] dpRow : dp){
                Arrays.fill(dpRow, Integer.MAX_VALUE);
            }
            for(int i =0 ; i < 1; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    result = Math.min(result, minFallingPathSum(matrix, i, j,dp));
                }
            }
            return result;
        }

        private int minFallingPathSum(int[][] matrix, int row, int col,int[][] dp){
            if(row >= matrix.length || col >= matrix[0].length || col < 0){
                return Integer.MAX_VALUE/2;
            }

            if(row == matrix.length-1){
                return matrix[row][col];
            }
            if(dp[row][col] != Integer.MAX_VALUE){
                return dp[row][col];
            }

            int leftSum = matrix[row][col] + minFallingPathSum(matrix, row+1, col-1,dp);
            int downSum = matrix[row][col] + minFallingPathSum(matrix, row+1, col,dp);
            int rightSum = matrix[row][col] + minFallingPathSum(matrix, row+1, col+1,dp);
            dp[row][col] = Math.min(leftSum, Math.min(downSum, rightSum));
            return dp[row][col];
        }
}
