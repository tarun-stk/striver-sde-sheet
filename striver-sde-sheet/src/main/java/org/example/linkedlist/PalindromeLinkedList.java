package org.example.linkedlist;

//TC: O(N)
//SC: O(1) -> rec stack space
//Problem link: https://leetcode.com/problems/palindrome-linked-list/
//Level: Medium
public class PalindromeLinkedList {

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

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = rev(slow, null);
        slow = head;
        while (slow != null && middle != null) {
            if (slow.val != middle.val)
                return false;
            slow = slow.next;
            middle = middle.next;
        }
        return true;
    }

    private ListNode rev(ListNode temp, ListNode prev) {
        if (temp == null) {
            return prev;
        }
        ListNode nhead = rev(temp.next, temp);
        temp.next = prev;
        return nhead;
    }
}
