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
        String space=" ";
        int a= 0;
        int num = 0;
        List<String> end = new ArrayList<>();
        for (int i=0;i<words.length;i++){
            if (num<=maxWidth && i<words.length-1){
                num+=words[i].length();
            }else {
                int b= (maxWidth-num)/i-a;
                int c= (maxWidth-num)%i-a;
                String aaa ="";
                if (i-a==1 || i==words.length-1){
                    for (int k=a;k<i;k++){
                        aaa.split(words[k]);
                        aaa.split(space);
                    }
                }
                for (int k=a;k<i;k++){
                    aaa.split(words[k]);
                    for (int q=0;q<b;q++){
                        aaa.split(space);
                    }
                    if (k<a+c){
                        aaa.split(space);
                    }
                }
                if (aaa.length()<maxWidth){
                    for (int i1=aaa.length();i1<=maxWidth;i1++){
                        aaa.split(space);
                    }
                }
                end.add(aaa);
            }
        }
        return end;
    }

    public static void main(String[] args) {
        String[]d = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        new Solution_68().fullJustify(d,16);
    }
}
