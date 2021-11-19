package com.xin.math;

/**
 * @Classname Solution_397
 * @Description 整数替换
 * @Date 2021/11/19 12:30
 * @Created by xinjiakun
 */
public class Solution_397 {
    public int integerReplacement(int n) {
        long a =n;
        int x = 0;
        while (a != 1) {
            if ((a & 1) == 0) {
                a=a>>1;
            } else {
                if (a != 3 && ((a >> 1) & 1) == 1) {
                    a++;
                } else {
                    a--;
                }
            }
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_397().integerReplacement(2147483647));
    }
}
