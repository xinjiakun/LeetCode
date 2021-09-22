package com.xin.math;

import org.omg.CORBA.IRObject;

/**
 * @Classname Solution_650
 * @Description 只有两个键的键盘
 * @Date 2021/9/19 20:14
 * @Created by xinjiakun
 */
public class Solution_650 {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int[] index = new int[n + 1];
        index[0] = 0;
        index[1] = 0;
        index[2] = 2    ;
        for (int i = 2; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                if (i % k == 0) {
                    if (index[i] == 0) {
                        index[i] = index[k] + i / k;
                    } else {
                        index[i] = Math.min(index[i], index[k] + i / k);
                    }
                }
            }
        }
        return index[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_650().minSteps(5));
    }
}
