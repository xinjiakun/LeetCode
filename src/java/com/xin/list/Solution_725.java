package com.xin.list;

/**
 * @Classname solution_725
 * @Description 分隔链表
 * @Date 2021/9/22 14:00
 * @Created by xinjiakun
 */
public class Solution_725 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 1;
        ListNode[] nodes = new ListNode[k];
        if (head == null) {
            return nodes;
        }
        ListNode v = head;
        while (head.next != null) {
            head = head.next;
            length++;
        }
        int min = length / k;
        int max = length % k;
        int now = 0;
        while (v!=null) {
            now++;
            int len = now <= max ? min + 1 : min;
            ListNode node = v;
            for (int i = 0; i < (len - 1); i++) {
                v = v.next;
            }
            ListNode val = v.next;
            v.next = null;
            v = val;
            nodes[now-1] = node;
        }
        return nodes;
    }

    public static void main(String[] args) {
        ListNode listNode = new Solution_725.ListNode();
        listNode.val = 1;
        ListNode listNode1 = new Solution_725.ListNode();
        listNode1.val = 2;
        ListNode listNode2 = new Solution_725.ListNode();
        listNode2.val = 3;
        listNode1.next = listNode2;
        listNode.next = listNode1;
        System.out.println(new Solution_725().splitListToParts(listNode, 5));
    }
}
