package com.xin.string;

/**
 * @Classname Solution_165
 * @Description 版本号比较
 * @Date 2021/9/1 9:34
 * @Created by xinjiakun
 */
public class Solution_165 {
    public int compareVersion(String version1, String version2) {
        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");
        for (int i = 0; i < (Math.max(strings1.length, strings2.length)); i++) {
            int a = i < strings1.length ? Integer.parseInt(strings1[i]) : 0;
            int b = i < strings2.length ? Integer.parseInt(strings2[i]) : 0;
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }
        return 0;
    }
}
