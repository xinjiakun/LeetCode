package com.xin.list;

/**
 * @author 辛佳锟
 * @title: Solution_1894
 * @projectName LeetCode
 * @description:  找到需要补充粉笔的学生编号
 * @date 2021/9/10 22:10
 */
public class Solution_1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int num = 0;
        for (int i=0;i<chalk.length;i++){
            num+=chalk[i];
            if (num>k){
                return i;
            }
        }
        k=k%num;
        num=0;
        for (int i=0;i<chalk.length;i++){
            num+=chalk[i];
            if (num>k){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4,1,2};
        new Solution_1894().chalkReplacer(a,25);
    }
}
