package com.xin.math;

/**
 * @Classname Solution_223
 * @Description 矩形面积
 * @Date 2021/9/30 13:44
 * @Created by xinjiakun
 */
public class Solution_223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        if (((ax1 <= bx1 && bx1 <= ax2) || (ax1 >= bx1 && ax1 <= bx2)) && ((ay1 <= by1 && by1 <= ay2) || (ay1 >= by1 && ay1 <= by2)) && !(ax1 == ay1 && ay1 == ax2 && ax2 == ay2) && !(bx1 == by1 && by1 == bx2 && bx2 == by2)) {
            int x = (ax2 < bx2 ? ax2 : bx2) - (ax1 < bx1 ? bx1 : ax1);
            int y = (ay2 < by2 ? ay2 : by2) - (ay1 < by1 ? by1 : ay1);
            return area - x * y;
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_223().computeArea(-2, -2, 2, 2, -1, -1, 1, 1));
    }
}
