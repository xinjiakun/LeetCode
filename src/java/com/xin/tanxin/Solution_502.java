package com.xin.tanxin;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 辛佳锟
 * @title: Solution_502
 * @projectName LeetCode
 * @description: IPO
 * @date 2021/9/8 20:48
 */
public class Solution_502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = capital[i];
            a[i][1] = profits[i];
        }
        int b = 0;
        Arrays.sort(a, (a1, a2) -> a1[0] - a2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; i++) {
            for (; b < n && a[b][0] < w; b++) {
                pq.add(a[b][1]);
            }
            if (pq.isEmpty()) {
                break;
            } else {
                w += pq.poll();
            }
        }
        return w;
    }
}
