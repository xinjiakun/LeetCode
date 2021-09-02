package com.xin.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Classname Solution_94
 * @Description 二叉树中序遍历
 * @Date 2021/9/2 9:13
 * @Created by xinjiakun
 */
public class Solution_94 {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
//        getTree(tree, root);
        getDeque(tree, root);

        return tree;
    }

    //递归
    private void getTree(List<Integer> tree, TreeNode root) {
        if (root == null) {
            return;
        }
        getTree(tree, root.left);
        tree.add(root.val);
        getTree(tree, root.right);
    }

    //栈
    private void getDeque(List<Integer> tree, TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque();
        while (root != null || deque.size() != 0) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            tree.add(root.val) ;
            root = root.right;
        }
    }
}
