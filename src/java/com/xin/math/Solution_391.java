package com.xin.math;

/**
 * @Classname Solution_391
 * @Description 完美矩形
 * @Date 2021/11/16 21:02
 * @Created by xinjiakun
 */
public class Solution_391 {
    public boolean isRectangleCover(int[][] rectangles) {
        int[] a1 = new int[2];
        int[] a2 = new int[2];
        int[] b1 = new int[2];
        int[] b2 = new int[2];
        for (int i = 0; i < rectangles.length; i++) {
            int a = rectangles[i][0];
            int b = rectangles[i][1];
            int c = rectangles[i][2];
            int d = rectangles[i][3];
            if (a < a1[0] || d > a1[1]) {
                a1[0] = a;
                a1[1] = d;
            }
            if (a < a2[0] || b < a2[1]) {
                a2[0] = a;
                a2[1] = b;
            }
            if (c > b1[0] || d > b1[1]) {
                b1[0] = c;
                b1[1] = d;
            }
            if (b < b2[0] || c > b2[1]) {
                b2[0] = b;
                b2[1] = c;
            }
        }
        return a1[0] == a2[1] && b1[0] == b2[0] && a1[1] == b1[1] && a2[1] == b2[1];
    }

}
