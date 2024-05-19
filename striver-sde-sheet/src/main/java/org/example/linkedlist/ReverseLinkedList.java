package org.example.linkedlist;

//TC: O(n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/reverse-linked-list/
//Level: Easy
public class ReverseLinkedList {
    private class ListNode {
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

    public ListNode reverseList(ListNode head) {
        return rec(head, null);
    }

    private ListNode rec(ListNode head, ListNode prev) {
        if (head == null)
            return prev;
        ListNode nhead = rec(head.next, head);
        head.next = prev;
        return nhead;
    }
}
