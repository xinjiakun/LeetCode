package com.xin.list;

/**
 * @Classname Solution_237
 * @Description 删除链表中的节点
 * @Date 2021/11/2 15:26
 * @Created by xinjiakun
 */
public class Solution_237 {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
