package com.xin.tree.bean;

import java.util.Objects;
//二叉树节点
public class BinaryTreeNode {
    private Integer node;
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(Integer node) {
        this.node = node;
    }

    public BinaryTreeNode(Integer node, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.node = node;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }
}
