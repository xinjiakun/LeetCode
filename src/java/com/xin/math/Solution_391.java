package com.xin.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution_391
 * @Description 完美矩形
 * @Date 2021/11/16 21:02
 * @Created by xinjiakun
 */
public class Solution_391 {
    public boolean isRectangleCover(int[][] rectangles) {
        int[] a1 = {rectangles[0][0], rectangles[0][3]};
        int[] a2 = {rectangles[0][0], rectangles[0][1]};
        int[] b1 = {rectangles[0][2], rectangles[0][3]};
        int[] b2 = {rectangles[0][2], rectangles[0][1]};
        Map<String, Integer> map = new HashMap();
        long x = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int a = rectangles[i][0];
            int b = rectangles[i][1];
            int c = rectangles[i][2];
            int d = rectangles[i][3];
            x += (c - a) * (d - b);
            map.put(a + "" + d, map.getOrDefault(a + "" + d, 0) + 1);
            map.put(a + "" + b, map.getOrDefault(a + "" + b, 0) + 1);
            map.put(c + "" + d, map.getOrDefault(c + "" + d, 0) + 1);
            map.put(c + "" + b, map.getOrDefault(c + "" + b, 0) + 1);

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
            if (b < b2[1] || c > b2[0]) {
                b2[0] = c;
                b2[1] = b;
            }
        }

        for (String aa : map.keySet()) {
            if (aa.equals(a1[0] + "" + a1[1]) || aa.equals(a2[0] + "" + a2[1]) || aa.equals(b1[0] + "" + b1[1]) || aa.equals(b2[0] + "" + b2[1])) {
                if (map.get(aa) != 1) {
                    return false;
                }
            } else {
                if (map.get(aa) % 2 != 0) {
                    return false;
                }
            }
        }
        return (a1[1] - a2[1]) * (b1[0] - a1[0]) == x;


    }

    public static void main(String[] args) {
        int[][] a = {{0, -1, 1, 0}, {0, 0, 1, 1}, {0, 1, 1, 2}, {0, 2, 1, 3}};
        new Solution_391().isRectangleCover(a);
    }
}
