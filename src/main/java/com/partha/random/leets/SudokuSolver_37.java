package com.partha.random.leets;

public class SudokuSolver_37 {

    public static void main(String[] args) {
        char[][] matrix = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver_37 solver = new SudokuSolver_37();
        solver.solveSudoku(matrix);
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + " \t ");
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        if(isValidBet(board, i,j, k)){
                            board[i][j] = k;
                            if(solve(board) == true){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidBet(char[][] board, int row,int col, char character){
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == character) return false;
            if(board[row][i] == character) return false;
            if(board[(row/3)*3 + i/3][(col/3)*3 + i%3] == character) return false;
        }
        return true;
    }

    public boolean isValidBetEasyIntuition(char[][] board, int row,int col, char character){
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == character) return false;
            if(board[row][i] == character) return false;
        }
        int startRow = 3 * (row/3);
        int startCol = 3 * (col/3);
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == character) return false;
            }
        }
        return true;
    }
}
