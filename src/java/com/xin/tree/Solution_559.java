package com.xin.tree;

import java.util.List;

/**
 * @author 辛佳锟
 * @title: Solution_559
 * @projectName LeetCode
 * @description: N 叉树的最大深度
 * @date 2021/11/21 20:53
 */
public class Solution_559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
    int deep = 0;

    public int maxDepth(Node root) {
        deep = 0;
        dfs(root, 0);
        return deep;
    }

    void dfs(Node root, int x) {
        if (root == null) {
            return;
        }
        x++;
        if (root.children == null || root.children.size() == 0) {
            deep = Math.max(deep, x);
            return;
        }

        for (Node node : root.children) {
            dfs(node, x);
        }
    }
}
