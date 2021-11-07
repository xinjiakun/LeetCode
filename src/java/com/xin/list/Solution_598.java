package com.xin.list;

/**
 * @author 辛佳锟
 * @title: Solution_598
 * @projectName LeetCode
 * @description: 范围求和 II
 * @date 2021/11/7 22:01
 */
public class Solution_598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }
        int x = ops[0][0];
        int y = ops[0][1];
        for (int i = 1; i < ops.length; i++) {
            x = Math.min(x, ops[i][0]);
            y = Math.min(y, ops[i][1]);
        }
        return Math.min(m, x) * Math.min(n, y);
    }
}
