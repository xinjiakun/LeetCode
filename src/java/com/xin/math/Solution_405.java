package com.xin.math;

/**
 * @Classname Solution_405
 * @Description 数字转换为十六进制数
 * @Date 2021/10/5 18:59
 * @Created by xinjiakun
 */
public class Solution_405 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder string = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int value = num >> (4 * i) & 0xf;
            if (string.length() > 0 || value > 0) {
                if (value >= 10) {
                    string.append((char) ('a' + value - 10));
                } else {
                    string.append(value);
                }
            }
        }
        return string.toString();
    }
}
