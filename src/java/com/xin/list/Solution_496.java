package com.xin.list;

import java.util.*;

/**
 * @Classname Solution_496
 * @Description 下一个更大元素 I 单调栈
 * @Date 2021/10/26 18:09
 * @Created by xinjiakun
 */
public class Solution_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(8);
        for (int i = 0; i < nums2.length; i++) {
            int a = -1;
            for (int y = i + 1; y < nums2.length; y++) {
                if (nums2[i] < nums2[y]) {
                    a = nums2[y];
                    break;
                }
            }
            map.put(nums2[i], a);
        }
        int[] value = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            value[i] = map.get(nums1[i]);
        }
        return value;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(8);
        Deque<Integer> deque = new ArrayDeque();
        for (int i = nums2.length-1; i >=0; i--) {
            while (!deque.isEmpty()&&deque.peek()<nums2[i]){
                deque.pop();
            }
            map.put(nums2[i], deque.isEmpty()?-1:deque.peek());
            deque.push(nums2[i]);
        }
        int[] value = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            value[i] = map.get(nums1[i]);
        }
        return value;
    }


    public static void main(String[] args) {
        int[] u1 = {4, 1, 2};
        int[] u2 = {1, 3, 4, 2};
        new Solution_496().nextGreaterElement1(u1, u2);
    }
}
