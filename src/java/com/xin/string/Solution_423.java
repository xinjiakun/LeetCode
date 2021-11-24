package com.xin.string;

/**
 * @Classname Solution_423
 * @Description 从英文中重建数字
 * @Date 2021/11/24 18:21
 * @Created by xinjiakun
 */
public class Solution_423 {
    public String originalDigits(String s) {
        int[] ss = new int[26];
        for (char c : s.toCharArray()) {
            ++ss[c - 'a'];
        }
        int[] aaa = new int[10];
        aaa[8] = ss['g' - 'a'];
        aaa[6] = ss['x' - 'a'];
        aaa[4] = ss['u' - 'a'];
        aaa[2] = ss['w' - 'a'];
        aaa[0] = ss['z' - 'a'];
        aaa[7] = ss['s' - 'a'] - aaa[6];
        aaa[5] = ss['v' - 'a'] - aaa[7];
        aaa[3] = ss['h' - 'a'] - aaa[8];
        aaa[9] = ss['i' - 'a'] - aaa[5] - aaa[6] - aaa[8];
        aaa[1] = ss['o' - 'a'] - aaa[0] - aaa[2] - aaa[4];
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < aaa.length; i++) {
            while (aaa[i]-- > 0){
                x.append(i);
            }
        }
        return x.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_423().originalDigits("zerozero"));
    }
}
