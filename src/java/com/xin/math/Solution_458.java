package com.xin.math;

/**
 * @Classname Solution_458
 * @Description 可怜的小猪
 * @Date 2021/11/25 12:20
 * @Created by xinjiakun
 */
public class Solution_458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int x = (minutesToTest / minutesToDie) + 1;
        String s =Double.valueOf(Math.ceil(Math.log(buckets) / Math.log(x))).toString();
        return Integer.parseInt(s.substring(0,s.indexOf(".")));
    }

    public static void main(String[] args) {
//        System.out.println(new Solution_458().poorPigs(1000,60,15));
        System.out.println(Integer.parseInt(Double.valueOf(Math.ceil(Math.log(1000) / Math.log(4))).toString()));
    }
}
