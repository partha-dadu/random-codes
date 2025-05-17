package com.partha.random.matrix;

public class RotateMatrix_48 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateMatrix_48 rotateMatrix48 = new RotateMatrix_48();
        rotateMatrix48.rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        // first transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j <= matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] row : matrix) {
            reverse(row);
        }

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " \t ");
            }
            System.out.println();
        }
    }

    public void reverse(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateMatrix_practice(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = row+1; col < matrix[row].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        for (int[] row : matrix) {
            reverse(row);
        }

    }
}
