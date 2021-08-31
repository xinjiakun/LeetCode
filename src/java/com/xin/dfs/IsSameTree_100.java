package com.xin.dfs;

import com.xin.tree.bean.TreeNode;

/**
 * @author xinjiakun
 * @title: IsSameTree_100
 * @projectName coding
 * @description: 给定两个二叉树，编写一个函数来检验它们是否相同。
 * @date 2019/11/10 18:21
 */
public class IsSameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) ||(p != null && q == null) ){
            return false;
        }
            if (p.val == q.val) {
                if (isSameTree(p.left, q.left)
                &&isSameTree(p.right, q.right)){
                    return true;
                }
            }
            return false;
    }
}
