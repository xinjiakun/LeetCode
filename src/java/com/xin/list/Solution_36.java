package com.xin.list;

/**
 * @Classname Solution_36
 * @Description 有效的数独
 * @Date 2021/9/17 20:28
 * @Created by xinjiakun
 */
public class Solution_36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] x = new int[9][9];
        int[][] y = new int[9][9];
        int[][][] block = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int a = 0; a < board[0].length; a++) {
                if (board[i][a] != '.') {
                    if (x[i][board[i][a] - 49] == 1 || y[a][board[i][a] - 49] == 1 || block[i / 3][a / 3][board[i][a] - 49] == 1) {
                        return false;
                    }
                    x[i][board[i][a] - 49] = 1;
                    y[a][board[i][a] - 49] = 1;
                    block[i / 3][a / 3][board[i][a] - 49] = 1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new Solution_36().isValidSudoku(board);

    }
}
