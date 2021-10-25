package com.xin.list;

/**
 * @Classname Solution_240
 * @Description 搜索二维矩阵 II
 * @Date 2021/10/25 18:23
 * @Created by xinjiakun
 */
public class Solution_240 {


    public boolean searchMatrix(int[][] matrix, int target) {
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        int x = 0;
        int y = yLength - 1;
        while (x >= 0 && x < xLength && y >= 0 && y < yLength) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

}
