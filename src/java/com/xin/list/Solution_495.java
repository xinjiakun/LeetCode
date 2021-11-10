package com.xin.list;

/**
 * @Classname Solution_495
 * @Description 提莫攻击
 * @Date 2021/11/10 17:44
 * @Created by xinjiakun
 */
public class Solution_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0) {
            return 0;
        }
        if (timeSeries.length == 1) {
            return duration;
        }
        int num = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            num += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return num;
    }
}
