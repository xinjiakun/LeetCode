package com.xin.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 辛佳锟
 * @title: Solution_1218
 * @projectName LeetCode
 * @description: 最长定差子序列
 * @date 2021/11/6 15:33
 */
public class Solution_1218 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> a = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            a.put(arr[i], a.getOrDefault(arr[i] - difference, 0) + 1);
            max = Math.max(max, a.get(arr[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        System.out.println(new Solution_1218().longestSubsequence(a, -2));
    }
}
