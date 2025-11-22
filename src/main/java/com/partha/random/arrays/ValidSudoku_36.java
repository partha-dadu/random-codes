package com.partha.random.arrays;

public class ValidSudoku_36 {


    /**
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     *
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * Note:
     *
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     *
     */
    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<board.length;i++){
            int[] hashRow = new int[10];
            for(int p=0; p< 10; p++){
                hashRow[p] = 0;
            }
            int[] hashCol = new int[10];
            for(int p=0; p< 10; p++){
                hashCol[p] = 0;
            }

            for(int j=0;j<board[0].length;j++){
                //validate Row
                if(board[i][j] != '.') {
                    if(board[i][j] > '9' || board[i][j] < 0) return false;
                    else if (hashRow[board[i][j]] == 0) {
                        hashRow[board[i][j]] = 1;
                    } else if (hashRow[board[i][j]] == 1) {
                        return false;
                    }
                }
                //validate Col
                if(board[j][i] != '.') {
                    if(board[i][j] > '9' || board[i][j] < 0) return false;
                    else if (hashCol[board[i][j]] == 0) {
                        hashCol[board[i][j]] = 1;
                    } else if (hashCol[board[i][j]] == 1) {
                        return false;
                    }
                }
            }
        }

        for(int row=0;row<board.length;row+=3){
            for(int col=0;col<board[0].length;col+=3){
                int[] hashBox = new int[10];
                for(int p=0; p< 10; p++){
                    hashBox[p] = 0;
                }
                int startRow = 3 * (row/3);
                int startCol = 3 * (col/3);
                for(int i = startRow; i < startRow + 3; i++) {
                    for(int j = startCol; j < startCol + 3; j++) {
                        if(board[j][i] != '.') {
                            if (hashBox[board[i][j]] == 0) {
                                hashBox[board[i][j]] = 1;
                            } else if (hashBox[board[i][j]] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
