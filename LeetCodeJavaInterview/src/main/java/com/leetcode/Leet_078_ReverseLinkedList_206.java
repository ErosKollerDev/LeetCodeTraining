package com.leetcode;
//https://leetcode.com/problems/reverse-linked-list/
public class Leet_078_ReverseLinkedList_206 {
    public static void main(String[] args) {
        Leet_078_ReverseLinkedList_206 leet = new Leet_078_ReverseLinkedList_206();
        ListNode one = new ListNode(1, new ListNode(2,
                new ListNode(3,
                        new ListNode(4,
                                new ListNode(5,
                                        new ListNode(6))))));
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode current = head;
        ListNode prev = null;
        while(current != null){
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }//TC: O(n), SC O(1)


    public ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode current = head;
        ListNode prev = null;
        while(current != null){
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }//TC: O(n), SC O(1)

}