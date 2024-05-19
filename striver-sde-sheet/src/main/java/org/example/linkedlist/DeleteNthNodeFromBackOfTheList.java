package org.example.linkedlist;

//TC: O(N)
//SC: O(N) -> stack space
//Problem link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//Level: Medium
public class DeleteNthNodeFromBackOfTheList {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int no = rec(head, n);
        if (no == n) {
            return head.next;
        }
        return head;
    }

    private int rec(ListNode head, int n) {
        if (head == null)
            return 0;
        int no = rec(head.next, n);
        if (no == n) {
            head.next = head.next.next;
        }
        return no + 1;

    }
}
