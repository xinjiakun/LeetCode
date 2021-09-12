package com.xin.tanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 辛佳锟
 * @title: Solution_68
 * @projectName LeetCode
 * @description: 文本左右对齐
 * @date 2021/9/9 21:32
 */
public class Solution_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        String space = " ";
        int stringNum = 0;//单词数
        int charNum = 0;//字符数
        int startIndex = 0;
        List<String> end = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (charNum + words[i].length() + stringNum  <= maxWidth) {//添加单词未超过最大长度
                charNum += words[i].length();
                stringNum++;
                if (i == words.length - 1) {//最后一位添加后还未达最大长度
                    String aaa = "";
                    for (int k = startIndex; k <= i; k++) {//单词拼接
                        aaa = aaa.concat(words[k]);
                        if (k!=i) {
                            aaa = aaa.concat(space);
                        }
                    }
                    if (aaa.length() < maxWidth) {//行末尾补充空格
                        for (int i1 = aaa.length(); i1 < maxWidth; i1++) {
                            aaa = aaa.concat(space);
                        }
                    }
                    end.add(aaa);
                }
            } else {

                int b = stringNum > 1 ? (maxWidth - charNum) / (stringNum - 1) : 0;
                int c = stringNum > 1 ? (maxWidth - charNum) % (stringNum - 1) : 0;
                String aaa = "";
                if (stringNum == 1) {//本行为一个单词
                    for (int k = startIndex; k < i; k++) {
                        aaa = aaa.concat(words[k]);
                    }
                } else {
                    for (int k = startIndex; k < i; k++) {//单词拼接
                        aaa = aaa.concat(words[k]);
                        if (k != i - 1) {
                            for (int q = 0; q < b; q++) {
                                aaa = aaa.concat(space);
                            }
                            if (k < startIndex + c) {
                                aaa = aaa.concat(space);
                            }
                        }
                    }
                }
                if (aaa.length() < maxWidth) {//行末尾补充空格
                    for (int i1 = aaa.length(); i1 < maxWidth; i1++) {
                        aaa = aaa.concat(space);
                    }
                }
                end.add(aaa);
                stringNum = 0;
                charNum = 0;//字符数
                startIndex = i;
                i--;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        String[] d = new String[]{"Listen","to","many,","speak","to","a","few."
        };
        System.out.println(new Solution_68().fullJustify(d, 6));
    }
}
