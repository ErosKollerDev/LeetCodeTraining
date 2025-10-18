package com.leetcode;

public class Leet_077_Merge_Two_SortedList_21 {
    public static void main(String[] args) {
        ListNode odd = new ListNode(1,
                new ListNode(3,
                        new ListNode(5,
                                new ListNode(7))));
        ListNode even = new ListNode(2,
                new ListNode(4,
                        new ListNode(6,
                                new ListNode(8))));

        Leet_077_Merge_Two_SortedList_21 leet = new Leet_077_Merge_Two_SortedList_21();
        ListNode fullList = leet.mergeTwoLists(odd, even);
        System.out.println(fullList.toString());

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode fakeHead = new ListNode(-9999);
        ListNode pointerOne = list1, pointerTwo = list2, current = fakeHead;
        while(pointerOne != null && pointerTwo != null){
            if(pointerOne.val < pointerTwo.val ){
                current.next = pointerOne;
                current = current.next;
                pointerOne = pointerOne.next;
            }else{
                current.next = pointerTwo;
                current = current.next;
                pointerTwo = pointerTwo.next;
            }
        }
        if(pointerOne == null && pointerTwo != null)current.next = pointerTwo;
        if(pointerTwo == null && pointerOne != null)current.next = pointerOne;
        return fakeHead.getNext();
    }//TC: O(m + n), SC: O(1)


}