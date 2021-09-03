package com.xin.list;

import java.util.Arrays;

/**
 * @Classname Solution_17_14
 * @Description 最小k个元素
 * @Date 2021/9/3 9:25
 * @Created by xinjiakun
 */
public class Solution_17_14 {
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);

    }

    void quickSort(int[] arr, int head, int tail, int k) {
        if (head >= tail) {
            return;
        }
        int mid = partSort(arr, head, tail);
//        if (mid == k) {
//            arr = Arrays.copyOfRange(arr, 0, k);
//            ;
//        }
        quickSort(arr, head, mid - 1, k);
        quickSort(arr, mid + 1, tail, k);
    }

    int partSort(int[] arr, int left, int right) {
        int value = arr[left];
        int key = left;
        while (left < right) {
            while (arr[right] >= value && left < right) {
                right--;
            }
            swap(arr, left, right);
            while (arr[left] <= value && left < right) {
                left++;
            }
            swap(arr, left, right);
        }
        return left;
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        ;
        for(int next :new Solution_17_14().smallestK(arr, 4)) {
            System.out.println(next);
        }
    }
}
