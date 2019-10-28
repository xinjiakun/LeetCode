package com.xin.dp;

/**
 * @author xinjiakun
 * @title: LongestPalindrome_5
 * @projectName coding
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @date 2019/10/28 15:45
 */
public class LongestPalindrome_5 {
    public static void main(String[] args) {
        LongestPalindrome_5 longest = new LongestPalindrome_5();
        longest.longestPalindrome("ac");
    }
    public String longestPalindrome(String s) {
        int[][] map = new int[s.length()][s.length()];
        return longest(map,s);
    }
    public String longest(int[][] map ,String s){
        int start = 0 ;
        int end = 0;
        int length = 1;
        for(int i = 0 ;i < s.length(); i++){
            for(int b = 0 ;b < s.length()-i; b++){
                if(i+b == b){
                    map[b][i+b] = 1;
                }
                else if(i == 1 && (s.charAt(i+b) == s.charAt(b))){
                    map[b][i+b] = 2;
                }
                else {
                    if(map[b+1][i+b-1] == 0){
                        map[b][i+b] = 0;
                    }else {
                        map[b][i+b] = s.charAt(i+b) == s.charAt(b) ? map[b+1][i+b-1] + 2 : 0;
                    }
                }
//                length = length > map[b][i+b] ? length : map[b][i+b];
                if(length < map[b][i+b]){
                    length = map[b][i+b];
                    start = b;
                    end = i+b;

                }

            }
        }
        if(end+1 >= s.length()){
            return s.substring(start);
        }else {
            return s.substring(start,end+1);
        }

    }
}
