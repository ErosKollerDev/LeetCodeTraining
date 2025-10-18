package com.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class Leet_076_DeleteNodeInLinkedList_237 {
    public static void main(String[] args) {
        Leet_076_DeleteNodeInLinkedList_237 leet = new Leet_076_DeleteNodeInLinkedList_237();
        ListNode one = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5, new ListNode(6))))));
        ListNode four = one.next.next.next;
        System.out.println(four);
        System.out.println(one);
        leet.deleteNode(four);
        System.out.println(one);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

