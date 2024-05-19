package org.example.linkedlist;

//N1-length of l1
//N2-length of l2
//TC: O(max(N1*N2))
//SC: O(max(N1*N2))
//Problem link: https://leetcode.com/problems/add-two-numbers/
//Level: Easy
public class AddTwoLinkedLists {

    class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode h = dummy;
        int carry = 0;
        while (t1 != null && t2 != null) {
            int sum = t1.val + t2.val + carry;
            carry = 1;
            if (sum < 10)
                carry = 0;
            h.next = new ListNode(sum % 10);
            h = h.next;
            t1 = t1.next;
            t2 = t2.next;
        }
        while (t1 != null) {
            int sum = t1.val + carry;
            carry = 1;
            if (sum < 10)
                carry = 0;
            h.next = new ListNode(sum % 10);
            h = h.next;
            t1 = t1.next;
        }
        while (t2 != null) {
            int sum = t2.val + carry;
            carry = 1;
            if (sum < 10)
                carry = 0;
            h.next = new ListNode(sum % 10);
            h = h.next;
            t2 = t2.next;
        }
        if (carry == 1)
            h.next = new ListNode(1);
        return dummy.next;
    }
}
