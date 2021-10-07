package com.xin.string;

/**
 * @Classname Solution_434
 * @Description 字符串中的单词数
 * @Date 2021/10/7 8:52
 * @Created by xinjiakun
 */
public class Solution_434 {
    public int countSegments(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                a++;
            }
        }
        return a;
    }
}
