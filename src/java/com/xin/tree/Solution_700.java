package com.xin.tree;

/**
 * @author 辛佳锟
 * @title: Solution_700
 * @projectName LeetCode
 * @description:  二叉搜索树中的搜索
 * @date 2021/11/26 20:29
 */
public class Solution_700 {
    public static class TreeNode {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode treeNode = searchBST(root.left, val);
        if (treeNode != null) {
            return treeNode;
        }
        return searchBST(root.right, val);

    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2, treeNode1, treeNode2);
        TreeNode treeNode4 = new TreeNode(7);

        TreeNode treeNode = new TreeNode(4, treeNode3, treeNode4);
        new Solution_700().searchBST(treeNode,5);
    }
}
