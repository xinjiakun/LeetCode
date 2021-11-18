package com.xin.tree;

/**
 * @Classname Solution_563
 * @Description 二叉树的坡度
 * @Date 2021/11/18 12:34
 * @Created by xinjiakun
 */
public class Solution_563 {
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

    Integer sum = 0;

    public int findTilt(TreeNode root) {
        sum = 0;
        helper(root);
        return sum;
    }

    int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        sum += (Math.max(left, right) - Math.min(left, right));
        return node.val + left + right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        new Solution_563().findTilt(treeNode);
    }
}
