package com.xin.dp;

/**
 * @author xinjiakun
 * @title: NumTrees_96
 * @projectName coding
 * @description: 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @date 2019/11/4 11:15
 */
public class NumTrees_96 {
    public int numTrees(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < n + 1; i++) {//长度为i的树的个数
            for (int m = 1; m < i; m++) {
                nums[i] = nums[m - 1] * nums[i - m];//以m为根节点树的个数 = 长度为m-1的树的个数(左子树) * 长度为i-m的树的个数(右子树)
            }
        }
        return nums[n];
    }
}
