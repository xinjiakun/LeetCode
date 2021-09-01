package com.xin.list;

import java.util.Arrays;

/**
 * @Classname list_1109
 * @Description 航班预订统计
 * @Date 2021/8/31 11:58
 * @Created by xinjiakun
 */
public class Solution_1109 {

    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        System.out.println(Arrays.toString(new Solution_1109().corpFlightBookings(bookings, 5)));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] list = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            list[bookings[i][0] - 1] += bookings[i][2];
            if (bookings[i][1] < n) {
                list[bookings[i][1]] -= bookings[i][2];
            }
        }
        for (int i = 1; i < list.length; i++) {
            list[i] += list[i - 1];
        }
        return list;
    }
}
