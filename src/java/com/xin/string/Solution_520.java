package com.xin.string;

/**
 * @author 辛佳锟
 * @title: Solution_520
 * @projectName LeetCode
 * @description: 检测大写字母
 * @date 2021/11/13 11:23
 */
public class Solution_520 {
    public boolean detectCapitalUse(String word) {
        int a = 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                if (a == 1 || word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
                    return false;
                }
                a = 2;
            } else {
                if (a == 2) {
                    return false;
                }
                a = 1;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_520().detectCapitalUse("Leetcode"));
    }
}
