package com.xin.string;

/**
 * @Classname Solution_583
 * @Description 两个字符串的删除操作
 * @Date 2021/9/26 17:51
 * @Created by xinjiakun
 */
public class Solution_583 {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        char[] word1Char = word1.toCharArray();
        char[] word2Char = word2.toCharArray();

        int[][] data = new int[length1][length2];
        if (word1Char[0] == word2Char[0]) {
            data[0][0] = 1;
        }
        for (int x = 1; x < length1; x++) {
            int a = 0;
            if (word1Char[x] == word2Char[0]) {
                a = 1;
            }
            data[x][0] = Math.max(a, data[x - 1][0]);
        }
        for (int y = 1; y < length2; y++) {
            int a = 0;
            if (word2Char[y] == word1Char[0]) {
                a = 1;
            }
            data[0][y] = Math.max(a, data[0][y - 1]);

        }
        for (int x = 1; x < length1; x++) {
            for (int y = 1; y < length2; y++) {
                int a = data[x - 1][y - 1];
                if (word1Char[x] == word2Char[y]) {
                    a = data[x - 1][y - 1] + 1;
                }
                data[x][y] = Math.max(a, Math.max(data[x - 1][y], data[x][y - 1]));
            }
        }
        return length1 + length2 - (2 * data[length1 - 1][length2 - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_583().minDistance("park", "spake"));
    }
}
