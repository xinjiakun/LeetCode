package com.xin.list;

import java.util.Arrays;

/**
 * @Classname Solution_66
 * @Description 加一
 * @Date 2021/10/21 17:50
 * @Created by xinjiakun
 */
public class Solution_66 {
    public int[] plusOne(int[] digits) {
        int num = 0;
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] a = new int[length + 1];
        a[0] = 1;
        for (int i = 0; i < length; i++) {
            a[i + 1] = digits[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {9, 9, 9};
        int[] b = new Solution_66().plusOne(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
