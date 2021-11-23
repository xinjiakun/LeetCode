package com.xin.math;

/**
 * @Classname Solution_859
 * @Description 亲密字符串
 * @Date 2021/11/23 12:38
 * @Created by xinjiakun
 */
public class Solution_859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        char[] a = new char[2];
        char[] b = new char[2];
        int[] ss = new int[26];
        boolean x = false;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!x) {
                x = ++ss[s.charAt(i) - 'a'] > 1;
            }
            if (s.charAt(i) != goal.charAt(i)) {
                if (num >= 2) {
                    return false;
                }
                a[num] = s.charAt(i);
                b[num] = goal.charAt(i);
                num++;
            }
        }
        return (num == 2 || x) && a[0] == b[1] && a[1] == b[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_859().buddyStrings("a", "ab"));
    }
}
