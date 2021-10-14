package com.xin.list;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Classname Solution_offer_069
 * @Description 山峰数组的顶部
 * @Date 2021/10/14 18:12
 * @Created by xinjiakun
 */
public class Solution_offer_069 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;
        int mid = (left + right) / 2;
        while (true) {
            if (mid == 0) {
                left = 1;
                right = arr.length;
            } else {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                }
                if (arr[mid] > arr[mid - 1]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            mid = (left + right) / 2;
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1};
        System.out.println(new Solution_offer_069().peakIndexInMountainArray(arr));
    }
}
