package com.xin.list;

import javafx.scene.shape.VLineTo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution_352
 * @Description 将数据流变为多个不相交区间
 * @Date 2021/10/9 16:07
 * @Created by xinjiakun
 */
public class Solution_352 {
    class Node {
        Integer start;
        Integer end;

        Node() {
        }

        Node(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

    }

    List<Node> list = null;

    public Solution_352() {
        list = new LinkedList<>();
    }

    public void addNum(int val) {
        if (list == null || list.isEmpty()) {
            list.add(new Node(val, val));
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).start <= val && list.get(i).end >= val) {
                    break;
                }
                if (list.get(i).start > val && list.get(i).end > val) {
                    if (val + 1 == list.get(i).start) {
                        if (i > 0 && val - 1 == list.get(i - 1).end) {
                            list.get(i - 1).end = list.get(i).end;
                            list.remove(i);
                            break;
                        }
                        list.get(i).start = val;
                        break;
                    } else if (i > 0 && val - 1 == list.get(i - 1).end) {
                        list.get(i - 1).end = val;
                        break;
                    } else {
                        list.add(i, new Node(val, val));
                        break;
                    }
                } else if (i == list.size() - 1) {
                    if (i > 0 && val - 1 == list.get(i).end) {
                        list.get(i).end = val;
                        break;
                    }
                    list.add(new Node(val, val));
                    break;
                }
            }
        }
    }

    public int[][] getIntervals() {
        int[][] a = new int[list.size()][2];
        int i = 0;
        for (Node node : list) {
            a[i][0] = node.start;
            a[i][1] = node.end;
            i++;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution_352 solution_352 = new Solution_352();
        solution_352.addNum(1);
        solution_352.getIntervals();
        solution_352.addNum(3);
        solution_352.getIntervals();
        solution_352.addNum(7);
        solution_352.getIntervals();
        solution_352.addNum(2);
        solution_352.getIntervals();
        solution_352.addNum(6);
        solution_352.getIntervals();
        solution_352.addNum(9);
        solution_352.getIntervals();
        solution_352.addNum(4);
        solution_352.getIntervals();
        solution_352.addNum(10);
        solution_352.getIntervals();
        solution_352.addNum(5);
        solution_352.getIntervals();
    }
}
