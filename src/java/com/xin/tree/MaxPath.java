package com.xin.tree;

import java.util.Arrays;

/**
 * @Classname demo
 * @Description 最大路径序列
 * @Date 2021/9/30 10:28
 * @Created by xinjiakun
 */
public class MaxPath {
    int[] max = new int[1000];

    int[] getMaxPath(int[] data) {
        cumulative(data, 0, new int[1000], 0);
        return max;
    }

    void cumulative(int[] data, int index, int[] transition, int level) {
        if (index > data.length - 1) {
            int transitionSum = Arrays.stream(transition).sum();
            int maxSum = Arrays.stream(max).sum();
            max = transitionSum > maxSum ? Arrays.copyOf(transition, transition.length) : max;
            return;
        }
        ++level;
        transition[index] = data[index];
        cumulative(data, index + level, transition, level);
        setZero(transition, index + 1);
        cumulative(data, index + level + 1, transition, level);
        --level;
        setZero(transition, index + 1);
    }

    void setZero(int[] transition, int startIndex) {
        for (int i = startIndex; i < transition.length; i++) {
            transition[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 10, 9, 8, 7};
        int[] b = new MaxPath().getMaxPath(a);
        for (int s : b) {
            if (s != 0) {
                System.out.println(s);
            }
        }
    }

}
