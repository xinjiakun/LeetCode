package com.xin.list;

import java.util.PriorityQueue;

/**
 * @author 辛佳锟
 * @title: Solution_786
 * @projectName LeetCode
 * @description: 第 K 个最小的素数分数
 * @date 2021/11/29 21:56
 */
public class Solution_786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> {
            return arr[x[0]] * arr[y[1]] - arr[y[0]] * arr[x[1]];
        });
        for (int i = 1; i < arr.length; i++) {
            queue.offer(new int[]{0, i});
        }
        for (int i = 1; i < k; i++) {
            int[] a = queue.poll();
            if (a[0] + 1 < a[1]) {
                queue.offer(new int[]{a[0] + 1, a[1]});
            }
        }
        int [] x= queue.poll();
        return new int[]{arr[x[0]],arr[x[1]]};
    }

    public static void main(String[] args) {
        System.out.println(new Solution_786().kthSmallestPrimeFraction(new int[]{1,2,3,5},3));
    }
}
