package com.xin.list;


import java.util.Iterator;

/**
 * @Classname Solution_284
 * @Description 窥探迭代器
 * @Date 2021/10/5 16:36
 * @Created by xinjiakun
 */
public class Solution_284 implements Iterator<Integer> {
    int[] value = new int[16];
    int head = 0;
    int tail = 0;
    int length;

    public Solution_284(Iterator<Integer> iterator) {
        // initialize any member here.
        while (iterator.hasNext()) {
            if (value.length <= length) {
                int[] newVlaue = new int[value.length + 16];
                for (int i = 0; i < value.length; i++) {
                    newVlaue[i] = value[i];
                }
                value = newVlaue;
            }

            value[tail] = iterator.next();
            tail++;
            length++;
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return hasNext() ? value[head] : 0;
    }

    @Override
    public boolean hasNext() {
        return head < length;
    }

    @Override
    public Integer next() {
        return hasNext() ? value[head++] : 0;
    }
}
