package org.example.linkedlist;

//TC: O(2*N)
//SC: O(n) -> rec stack space
//Problem link: https://leetcode.com/problems/rotate-list/
//Level: Medium
public class RotateList {
    //      Definition for singly-linked list.
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

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        int len = 0;
        ListNode temp = head, prev = null;
        while (temp != null) {
            len++;
            prev = temp;
            temp = temp.next;
        }
        k %= len;
        if (k == 0)
            return head;
        return rec(head, head, len, k, prev, null);
    }

    private ListNode rec(ListNode t, ListNode head, int len, int k, ListNode end, ListNode prev) {
        if (len == k) {
            end.next = head;
            prev.next = null;
            return t;
        }
        return rec(t.next, head, len - 1, k, end, t);
    }
}
