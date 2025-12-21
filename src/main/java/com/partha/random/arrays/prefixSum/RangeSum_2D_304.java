package com.partha.random.arrays.prefixSum;

public class RangeSum_2D_304 {
    int[][] matrix;
    int[][] prefix;

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        RangeSum_2D_304 obj = new RangeSum_2D_304(matrix);
        obj.sumRegion(1,1,2,2);
    }

    public RangeSum_2D_304(int[][] matrix) {
        this.matrix = matrix;
        this.prefix = new int[matrix.length+1][matrix[0].length+1];
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                prefix[r+1][c+1] = prefix[r][c+1] + prefix[r+1][c] + matrix[r][c] - prefix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = prefix[row2+1][col2+1] - prefix[row1][col2+1]-prefix[row2+1][col1] + prefix[row1][col1];
        return sum;
    }
}
