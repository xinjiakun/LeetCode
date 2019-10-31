package com.xin.dp;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author 辛佳锟
 * @title: longestValidParentheses_32
 * @projectName LeetCode
 * @description: 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *                  对于遇到的每个 ‘(’ ，我们将它的下标放入栈中。
 *                 对于遇到的每个 ‘)’ ，我们弹出栈顶的元素并将当前元素的下标与弹出元素下标作差
 * @date 2019/10/31 21:05
 */
public class longestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        int num = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    num = num > i - stack.peek() ? num : i - stack.peek();
                }
            }
        }
        return num;
    }
}
