package com.xin.dfs;

/**
 * @author xinjiakun
 * @title: FindCircleNum_547
 * @projectName coding
 * @description: 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *  深搜遍历图   图表示关系
 * @date 2019/11/14 18:45
 */
public class FindCircleNum_547 {
    public static int personNum = 0;//记录已遍历节点
    public int findCircleNum(int[][] M) {
        if (M == null) {//base case
            return 0;
        } else if (M.length == 1) {
            return 1;
        }
        int max = 0;
        //表示对每一个学生的遍历
        for (int i = 0; i < M.length; i++) {
            if (helper(M, i)) {
                personNum++;
                max++;
            }
        }
        return max + M.length - personNum;
    }
    //以当前学生index为根节点深搜 有子节点则返回true  无子节点则返回false
    private boolean helper(int[][] M, int index) {
        int num = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[index][i] == 1 && i != index) {
                M[index][i] = 0;//遍历过该关系则标记为0
                M[i][index] = 0;//无向图
                personNum++;
                helper(M, i);
            } else {
                num++;
            }
        }
        if (num == M.length) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[][] pa = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(new FindCircleNum_547().findCircleNum(pa));
    }
}
