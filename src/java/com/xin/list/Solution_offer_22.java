package com.xin.list;

/**
 * @Classname Solution_offer_22
 * @Description 链表中倒数k第k个节点
 * @Date 2021/9/2 9:16
 * @Created by xinjiakun
 */
public class Solution_offer_22 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1.next != null ) {
            p1 = p1.next;
            if (--k <= 0) {
                p2 = p2.next;
            }
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(5);

        System.out.println(getKthFromEnd(listNode,2).val);
    }
}
