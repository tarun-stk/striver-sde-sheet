package org.example.linkedlist;

//TC: O(N+M)
//SC: O(1)
//Problem link: https://leetcode.com/problems/intersection-of-two-linked-lists/description/
//Level: Medium
public class Intersection {
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tA = headA, tB = headB;
        int l1 = 1, l2 = 1;
        while (tA.next != null) {
            l1++;
            tA = tA.next;
        }
        while (tB.next != null) {
            l2++;
            tB = tB.next;
        }
        tA = headA;
        tB = headB;
        while (l1 > l2) {
            l1--;
            tA = tA.next;
        }
        while (l2 > l1) {
            l2--;
            tB = tB.next;
        }
        while (tA != tB) {
            tA = tA.next;
            tB = tB.next;
        }
        return tA;
    }
}
