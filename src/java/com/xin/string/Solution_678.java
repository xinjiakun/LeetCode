package com.xin.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 辛佳锟
 * @title: Solution_678
 * @projectName LeetCode
 * @description: 有效的括号字符串
 * @date 2021/9/12 12:23
 */
public class Solution_678 {
    public boolean checkValidString(String s) {
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> num = new LinkedList<>();
        char[]list=s.toCharArray();
        for (int i=0;i<list.length;i++) {
            if (list[i] == '(') {
                left.push(i);
            }
            if (list[i] == '*') {
                num.push(i);
            }
            if (list[i] == ')') {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (left.isEmpty() &&  !num.isEmpty()) {
                    num.pop();
                } else {
                    return false;
                }
            }
        }
        while (!left.isEmpty()&&!num.isEmpty()){
            if (left.pop()>num.pop()){
                return false;
            }
        }
        return left.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_678().checkValidString("(((((*(((((*((**(((*)*((((**))*)*)))))))))((*(((((**(**)"));
    }
}
