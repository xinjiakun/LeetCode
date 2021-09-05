package com.xin.math;

/**
 * @author 辛佳锟
 * @title: Solution_470
 * @projectName LeetCode
 * @description: 用 Rand7() 实现 Rand10()
 * @date 2021/9/5 19:19
 */
public class Solution_470 {
    public int rand7() {
        return 1;
    }

    public int rand10() {
        int i = ((rand7() - 1) * 7) + rand7();
        while (i > 40) {
            i = ((rand7() - 1) * 7) + rand7();
        }
        return i % 10 + 1;
    }
}
