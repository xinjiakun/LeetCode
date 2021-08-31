package com.xin.dp;

/**
 * @author xinjiakun
 * @title: UniquePathsWithObstacles_63
 * @projectName coding
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *                 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *                 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * @date 2019/11/1 16:20
 */
public class UniquePathsWithObstacles_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] != 1) {
            obstacleGrid[0][0] = 1;
        } else {
            obstacleGrid[0][0] = 0;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            } else {
                obstacleGrid[i][0] = 0;
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0) {
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            } else {
                obstacleGrid[0][i] = 0;
            }

        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int y = 1; y < obstacleGrid[0].length; y++) {
                if (obstacleGrid[i][y] == 0) {
                    obstacleGrid[i][y] = obstacleGrid[i - 1][y] + obstacleGrid[i][y - 1];
                }else {
                    obstacleGrid[i][y] = 0;
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles_63 unique = new UniquePathsWithObstacles_63();
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(unique.uniquePathsWithObstacles(arr));
    }
}
