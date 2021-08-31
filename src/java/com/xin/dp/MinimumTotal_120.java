package com.xin.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinjiakun
 * @title: MinimumTotal_120
 * @projectName coding
 * @description: 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * @date 2019/11/1 17:39
 */
public class MinimumTotal_120 {
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        } else if (triangle.size() == 2) {
            int num1 = triangle.get(0).get(0) + triangle.get(1).get(0);
            int num2 = triangle.get(0).get(0) + triangle.get(1).get(1);
            return num1 < num2 ? num1 : num2;
        }
        int min = 0;
        int[] num = new int[triangle.size()];
        for (int i = 1; i < triangle.size(); i++) {
            for (int m = 0; m < i + 1; m++) {
                if (m == 0) {
                    triangle.get(i).set(m, triangle.get(i).get(m) + triangle.get(i - 1).get(m));
                    num[m] = triangle.get(i).get(m);
                } else if (m == i) {
                    triangle.get(i).set(m, triangle.get(i).get(m) + triangle.get(i - 1).get(m - 1));
                    num[m] = triangle.get(i).get(m);
                } else {

                    if (triangle.get(i - 1).get(m - 1) < triangle.get(i - 1).get(m)) {
                        triangle.get(i).set(m,triangle.get(i - 1).get(m - 1) + triangle.get(i).get(m));
                        num[m] = triangle.get(i).get(m);
                    } else {
                        triangle.get(i).set(m,triangle.get(i - 1).get(m) + triangle.get(i).get(m));
                        num[m] =triangle.get(i).get(m);
                    }
                }
                if(i == triangle.size() - 1 && m == 0){
                    min = num[m];
                }
                if (i == triangle.size() - 1 && m != 0) {
                    min = num[m] < min ? num[m] : min;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumTotal_120 total120 = new MinimumTotal_120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>(1));
        triangle.add(new ArrayList<Integer>(2));
        triangle.add(new ArrayList<Integer>(3));
        triangle.add(new ArrayList<Integer>(4));
        triangle.get(0).add(2);
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);
        System.out.println(total120.minimumTotal(triangle));
    }
}
