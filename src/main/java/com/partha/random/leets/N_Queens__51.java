package com.partha.random.leets;

import java.util.ArrayList;
import java.util.List;

public class N_Queens__51 {

    /**
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
     *
     * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
     *
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
     *
     * Input: n = 4
     * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
     *
     * **/

    public static void main(String[] args) {
        N_Queens__51 solution = new N_Queens__51();
        List<List<String>> result = solution.prepareNQueensInput(4);
        for(List<String> row : result){
            System.out.println(row);
        }
    }

    public List<List<String>> prepareNQueensInput(int n){
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        recursiveNQueens(board,0,result);
        return result;
    }

    public void recursiveNQueens(char[][] board, int col, List<List<String>> result){
        if(col == board.length){
            List<String> internal = new ArrayList<>();
            for(char[] row: board){
                internal.add(new String(row));
            }
            result.add(internal);
            return;
        }

        for(int row=0; row < board.length; row++){
            if (isSafeBet(col, row, board)){
                board[row][col] = 'Q';
                recursiveNQueens(board, col+1, result);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafeBet(int col, int row, char[][] board){

        // This works only with Row wise insertion not with Column wise insertion


        int dupRow= row;
        int dupCol = col;

        // check for the same row occurrence
        while ( dupCol >=0){
            if(board[row][dupCol] == 'Q'){
                return false;
            }
            dupCol--;
        }

        // check for the left upper diagonal
        dupCol= col;
        dupRow = row;
        while (dupRow >=0 && dupCol >= 0){
            if(board[dupRow][dupCol] == 'Q'){
                return false;
            }
            dupRow--;
            dupCol--;
        }

        // check for left down diagonal
        dupCol= col;
        dupRow = row;

        while(dupRow < board.length && dupCol >= 0){
            if(board[dupRow][dupCol] == 'Q'){
                return false;
            }
            dupRow++;
            dupCol--;
        }
        return true;
    }

    public void recursiveSolutionRowWise(char[][] board, int row, List<List<String>> result){

        if(row == board.length){
            List<String> internal = new ArrayList<>();
            for(char[] rowRow: board){
                internal.add(new String(rowRow));
            }
            result.add(internal);
            return;
        }

        for(int col=0; col < board.length; col++){
            if (isSafeBet(col, row, board)) {
                board[row][col] = 'Q';
                recursiveSolutionRowWise(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }
}
