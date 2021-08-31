package com.xin.dp;

/**
 * @author xinjiakun
 * @title: UniquePaths_62
 * @projectName coding
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *                 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *                 问总共有多少条不同的路径？
 * @date 2019/11/1 15:37
 */
public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] arrays = new int[m][n];
        arrays[0][0] = 1;
        for (int i = 1; i < m; i++) {
            arrays[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            arrays[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int y = 1; y < n; y++) {
                arrays[i][y] = arrays[i - 1][y] + arrays[i][y - 1];
            }
        }
        return arrays[m - 1][n - 1];
    }
}
