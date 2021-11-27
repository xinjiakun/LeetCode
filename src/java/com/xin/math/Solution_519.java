package com.xin.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 辛佳锟
 * @title: Solution_519
 * @projectName LeetCode
 * @description: 随机翻转矩阵
 * @date 2021/11/27 11:00
 */
public class Solution_519 {
    Map<Integer, Integer> map = new HashMap<>();
    int m;
    int n;
    int num;
    Random random = new Random();

    public Solution_519(int m, int n) {
        this.m = m;
        this.n = n;
        this.num = m * n;
    }

    public int[] flip() {
        int x = random.nextInt(num--);
        int a = map.getOrDefault(x, x);
        map.put(x, map.getOrDefault(num, num));
        return new int[]{a / n, a % n};
    }

    public void reset() {
        num = m * n;
        map.clear();
    }
}
