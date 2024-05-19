package org.example.linkedlist;

//Time Complexity: O(n)
//Space Complexity: O(1)
//Problem link: https://leetcode.com/problems/linked-list-cycle/
//Level: Easy
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
