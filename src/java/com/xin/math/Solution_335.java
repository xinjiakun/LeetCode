package com.xin.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author 辛佳锟
 * @title: Solution_335
 * @projectName LeetCode
 * @description: 3路径交叉
 * @date 2021/10/30 18:33
 */
public class Solution_335 {
    public boolean isSelfCrossing(int[] distance) {
        for (int i = 3; i < distance.length; i++) {
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }
            if (i == 4 && distance[i] >= (distance[2] - distance[0]) && distance[3] == distance[1]) {
                return true;
            }
            if (i >= 5 && distance[i - 1] >= distance[i - 3] - distance[i - 5] && distance[i] >= (distance[i - 2] - distance[i - 4])
                    && distance[i - 1] <= distance[i - 3] && distance[i - 2] >= distance[i - 4]
            ) {
                return true;
            }
        }
        return false;
    }
}
