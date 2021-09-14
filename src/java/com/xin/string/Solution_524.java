package com.xin.string;

import java.util.List;

/**
 * @Classname Solution_524
 * @Description 通过删除字母匹配到字典里最长单词
 * @Date 2021/9/14 21:09
 * @Created by xinjiakun
 */
public class Solution_524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String r = "";
        for (String str : dictionary) {
            int a1 = 0;

            for (int a = 0; a < s.length(); a++) {
                if (a1 == str.length()) {
                    break;
                }
                if (str.charAt(a1) == s.charAt(a)) {
                    a1++;
                }
            }
            if (a1 == str.length()) {
                if (str.length() > r.length() || (a1 == r.length() && str.compareTo(r) < 0)) {
                    r = str;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {

    }
}
