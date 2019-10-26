package com.xin.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层遍历输出
 */
public class LayerSort {
    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = CreateTree.createTree(20);
        print(binaryTreeNode);
    }
    public static void print(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(binaryTreeNode);
        BinaryTreeNode node ;
        System.out.println(" ");
        System.out.println("=====================");
        while (queue != null){
            try {
                node = queue.remove();
                System.out.print(node.getNode()+" ");
                if(node.getLeftNode() != null){
                    queue.add(node.getLeftNode());
                }
                if(node.getRightNode() != null){
                    queue.add(node.getRightNode());
                }
            }catch (Exception e){

            }

        }
    }
}
