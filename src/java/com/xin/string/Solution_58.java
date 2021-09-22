package com.xin.string;

/**
 * @Classname Solution_58
 * @Description 最后一个单词的长度
 * @Date 2021/9/21 9:08
 * @Created by xinjiakun
 */
public class Solution_58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int length = s.length();
        char[] chars = s.toCharArray();
        int index = 0;
        for (int a = 0; a < length; a++) {
            if (chars[a] == ' ') {
                index = a + 1;
            }
        }
        return length - index;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_58().lengthOfLastWord( "   fly me   to   the moon  "));
    }
}
