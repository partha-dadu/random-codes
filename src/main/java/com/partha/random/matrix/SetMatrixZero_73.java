package com.partha.random.matrix;

public class SetMatrixZero_73 {

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,1},{1,0,1,1},{1,1,0,1},{0,1,1,1}};
        SetMatrixZero_73 setMatrixZero73 = new SetMatrixZero_73();
        setMatrixZero73.setMatrixZeroOptimal_practice(matrix);
        for(int[] row : matrix){
            for(int element : row){
                System.out.print(element + " \t");
            }
            System.out.println();

        }
    }

    public void setMatrixZero(int[][] matrix){

        for(int i = 0; i < matrix.length; i++){

            for(int j = 0; j < matrix[i].length;j++){

                if(matrix[i][j] == 0){
                    markRow(matrix,i);
                    markColumn(matrix,j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){

            for(int j = 0; j < matrix[i].length;j++){

                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void markRow(int[][] matrix, int row){
        for(int r = 0; r < matrix.length; r++){
            if(r == row){
                for (int j = 0 ; j < matrix[r].length; j++){
                    if(matrix[r][j] != 0){
                        matrix[r][j] = -1;
                    }
                }
            }
        }
    }
    public void markColumn(int[][] matrix, int column){
        for(int r = 0; r < matrix.length; r++){
                for (int j = 0 ; j < matrix[r].length; j++){
                    if(j == column) {
                        if (matrix[r][j] != 0) {
                            matrix[r][j] = -1;
                        }
                    }
                }
        }
    }

    public void setMatrixZeroBetter(int[][] matrix){
        int[] mRows = new int[matrix.length];
        int[] nColumns = new int[matrix[0].length];
        for(int i=0; i < matrix.length; i++){

            for (int j=0; j < matrix[i].length;j++){

                if(matrix[i][j] == 0){
                    mRows[i] = 1;
                    nColumns[j]=1;
                }
            }
        }

        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[i].length; j++){
                if(mRows[i] == 1 || nColumns[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setMatrixZeroOptimal(int[][] matrix){
        int col0=1;
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j< matrix[i].length; j++){
                if(j == 0 && matrix[i][j] == 0){
                    col0 = 0;
                    matrix[i][0] = 0;
                }else if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i =1; i< matrix.length; i++){
            for(int j=1; j < matrix[i].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j]=0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int i=0; i< matrix[0].length; i++) matrix[0][i] =0;
        }
        if(col0 == 0){
            for(int i =0; i < matrix.length; i++) matrix[i][0] = 0;
        }
    }

    public void setMatrixZeroBetter_practice(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int[] mRows = new int[matrix.length];
        int[] nColumns = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    mRows[row] = -1;
                    nColumns[col] = -1;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(mRows[row] == -1 || nColumns[col] == -1){
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public void setMatrixZeroOptimal_practice(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int row0 = 1;
        for(int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    if(row == 0){
                        row0 = 0;
                    }else{
                        matrix[0][col] = 0;
                        matrix[row][0] = 0;
                    }
                }
            }
        }

        for(int row = 1; row < matrix.length; row++){
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int i = 0 ; i < matrix.length ; i ++){
                matrix[i][0] = 0;
            }
        }

        if(row0 == 0){
            for(int i = 0 ; i < matrix[0].length ; i ++){
                matrix[0][i] = 0;
            }
        }
    }
}
