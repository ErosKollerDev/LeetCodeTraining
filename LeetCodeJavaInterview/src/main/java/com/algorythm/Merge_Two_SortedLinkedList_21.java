package com.algorythm;

import com.leetcode.ListNode;

public class Merge_Two_SortedLinkedList_21 {
    public static void main(String[] args) {
        ListNode odd = new ListNode(1,
                new ListNode(3,
                        new ListNode(5,
                                new ListNode(7))));
        ListNode even = new ListNode(2,
                new ListNode(4,
                        new ListNode(6,
                                new ListNode(8))));

        Merge_Two_SortedLinkedList_21 leet = new Merge_Two_SortedLinkedList_21();
        ListNode fullList = leet.mergeTwoLists(odd, even);
        System.out.println(fullList.toString());

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode fakeHead = new ListNode(-9999);
        ListNode pointerOne = list1, pointerTwo = list2, current = fakeHead;
        while(pointerOne != null && pointerTwo != null){
            if(pointerOne.getVal() < pointerTwo.getVal() ){
                current.setNext(pointerOne);
                current = current.getNext();
                pointerOne = pointerOne.getNext();
            }else{
                current.setNext(pointerTwo);
                current = current.getNext();
                pointerTwo = pointerTwo.getNext();
            }
        }
        if(pointerOne == null && pointerTwo != null)current.setNext(pointerTwo);
        if(pointerTwo == null && pointerOne != null)current.setNext(pointerOne);
        return fakeHead.getNext();
    }//TC: O(m + n), SC: O(1)


}