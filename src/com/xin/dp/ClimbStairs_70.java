package com.xin.dp;

/**
 * @author xinjiakun
 * @title: ClimbStairs_70
 * @projectName coding
 * @description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *                 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @date 2019/11/1 17:00
 */
public class ClimbStairs_70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }
}
