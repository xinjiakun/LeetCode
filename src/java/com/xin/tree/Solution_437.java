package com.xin.tree;

/**
 * @author 辛佳锟
 * @title: Solution_437
 * @projectName LeetCode
 * @description: 路径总和 III
 * @date 2021/9/28 21:00
 */
public class Solution_437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int now = rootSum(root, targetSum);
        now += pathSum(root.left, targetSum);
        now += pathSum(root.right, targetSum);
        return now;
    }

    public int rootSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val == targetSum) {
            sum++;
        }
        sum += rootSum(root.left, targetSum - root.val);
        sum += rootSum(root.right, targetSum - root.val);
        return sum;
    }

}


