package com.xin.math;

/**
 * @author 辛佳锟
 * @title: Solution_492
 * @projectName LeetCode
 * @description: 构造矩形
 * @date 2021/10/23 10:48
 */
public class Solution_492 {
    public int[] constructRectangle(int area) {
        int a = (int) Math.sqrt(area);
        while (area % a != 0) {
            a--;
        }
        return new int[]{area / a, a};
    }
}
