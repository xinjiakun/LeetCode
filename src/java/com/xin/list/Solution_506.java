package com.xin.list;

import java.util.Arrays;

/**
 * @author 辛佳锟
 * @title: Solution_506
 * @projectName LeetCode
 * @description: 相对名次
 * @date 2021/12/2 22:46
 */
public class Solution_506 {

    public String[] findRelativeRanks(int[] score) {
        String[] ss = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] a = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            a[i] = new int[]{score[i], i};
        }
        Arrays.sort(a, (x, y) -> y[0] - x[0]);
        String[] x = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            if (i < 3) {
                x[a[i][1]] = ss[i];
            } else {
                x[a[i][1]] = String.valueOf(i + 1);
            }
        }
        return x;
    }
}
