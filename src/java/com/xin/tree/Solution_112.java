package com.xin.tree;

/**
 * @author 辛佳锟
 * @title: Solution_112
 * @projectName LeetCode
 * @description: 路径总和
 * @date 2021/9/28 21:54
 */
public class Solution_112 {
    static public class TreeNode {
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

    int value = -1;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        get(root, targetSum);
        return value == 0;
    }

    public void get(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            value = targetSum == 0 ? 0 : value;
        }
        get(root.left, targetSum);
        get(root.right, targetSum);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new Solution_112.TreeNode(7);
        TreeNode treeNode2 = new Solution_112.TreeNode(2);
        TreeNode treeNode3 = new Solution_112.TreeNode(11, treeNode1, treeNode2);
        TreeNode treeNode4 = new Solution_112.TreeNode(2);
        TreeNode treeNode5 = new Solution_112.TreeNode(1);
        TreeNode treeNode6 = new Solution_112.TreeNode(4, null, treeNode5);
        TreeNode treeNode7 = new Solution_112.TreeNode(13);
        TreeNode treeNode8 = new Solution_112.TreeNode(8, treeNode7, treeNode6);

        TreeNode treeNode = new Solution_112.TreeNode(1, treeNode4, null);
        new Solution_112().hasPathSum(treeNode, 1);
    }
}
