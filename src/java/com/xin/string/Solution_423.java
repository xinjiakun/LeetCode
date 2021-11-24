package com.xin.string;

/**
 * @Classname Solution_423
 * @Description TODO
 * @Date 2021/11/24 18:21
 * @Created by xinjiakun
 */
public class Solution_423 {
    public String originalDigits(String s) {
        int[] ss = new int[26];
        int a = 0;
        for (char c : s.toCharArray()) {
            ++ss[c - 'a'];
            a |= 1 << (c - 'a');
        }
    }
}
