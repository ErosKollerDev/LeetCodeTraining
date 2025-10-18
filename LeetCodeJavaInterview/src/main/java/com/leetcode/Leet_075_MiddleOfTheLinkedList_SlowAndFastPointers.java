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
 */
public class Leet_075_MiddleOfTheLinkedList_SlowAndFastPointers {
    public static void main(String[] args) {
        Leet_075_MiddleOfTheLinkedList_SlowAndFastPointers leet = new Leet_075_MiddleOfTheLinkedList_SlowAndFastPointers();
        ListNode one = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5, new ListNode(6))))));
        System.out.println(leet.middleNode(one));
    }

    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;
        ListNode slow = head, fast = head;
        //Means our LinkedList is even
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }//TC: O(n), SC: O(1)

}

