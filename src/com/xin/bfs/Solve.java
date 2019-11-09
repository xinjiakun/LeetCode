package com.xin.bfs;

/**
 * @author 辛佳锟
 * @title: Solve
 * @projectName LeetCode
 * @description: 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *              bfs广搜   寻找和边界联通的 O
 *              边界上的 O 特殊处理，那么剩下的 O 替换成 X
 * @date 2019/11/9 22:13
 */
public class Solve {
    public void solve(char[][] board) {
        if (board.length == 0 || board == null) { //base case
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                if (m == 0 || n == 0 || m == row - 1 || n == col - 1) {
                    helper(m, n, board);//处理边界为O的值
                }
            }

        }
        for (int n = 0; n < row; n++) {//查找替换
            for (int m = 0; m < col; m++) {
                if ('O' == board[n][m]) {
                    board[n][m] = 'X';
                } else if ('A' == board[n][m]) {
                    board[n][m] = 'O';
                }
            }
        }
    }

    private void helper(int left, int right, char[][] board) {//递归bfs
        int row = board.length;
        int col = board[0].length;
        if (left < 0 || left >= row || right < 0 || right >= col || board[left][right] == 'A' || board[left][right] == 'X') {
            return;
        }
        board[left][right] = 'A';
        helper(left, right - 1, board);
        helper(left, right + 1, board);
        helper(left + 1, right, board);
        helper(left - 1, right, board);
    }

    public static void main(String[] args) {
        char[][] chars = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new Solve().solve(chars);
        for (char[] a : chars) {
            for (char b : a) {
                System.out.println(a);
            }
        }
    }
}
