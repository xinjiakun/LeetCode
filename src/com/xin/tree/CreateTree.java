package com.xin.tree;

import java.util.Iterator;

//构建二叉树
public class CreateTree {
    private static void findBiggerNode(BinaryTreeNode tree ,Integer value){
        if(tree.getNode() == null){//根节点为空
            tree.setNode(value);
            return;
        }
        //根节点不为空
        if(tree.getNode() > value){//根节点大于目标数
            if(tree.getLeftNode() == null){//左子树为空
                tree.setLeftNode(new BinaryTreeNode(value));
            }else {//左子树不为空 递归
                findBiggerNode(tree.getLeftNode(),value);
            }
        }else {//目标大于等于根节点
            if(tree.getRightNode() == null){//右子树为空
                tree.setRightNode(new BinaryTreeNode(value));
            }else {//右子树不为空 递归
                findBiggerNode(tree.getRightNode(),value);
            }
        }
    }
    private static BinaryTreeNode createBinaryTree(Integer[] arrayList){
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode();
        for (Integer arr: arrayList){
            findBiggerNode(binaryTreeNode,arr);
        }
        return binaryTreeNode;
    }
    private static Integer[] createArray(int length){
        Integer [] array = new Integer[length];
        for (int i=0 ;i < length ;i++){
            array[i] = (int)( Math.random()*1000);
            System.out.print(array[i]+" ");

        }
        return array;
    }
    public static BinaryTreeNode createTree(int length){
        return  createBinaryTree(createArray(length));
    }
}
