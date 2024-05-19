package org.example.linkedlist;

//TC: O(N) -> find lenght + O(N) -> actual logic
//SC: O(2*K) -> ln space + O(N) -> stack space
//Problem link: https://leetcode.com/problems/reverse-nodes-in-k-group/
//Level: Hard
public class ReverseNodesInKGroup {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode temp = head, dummy = new ListNode(-1), t = null;
        while (temp != null) {
            ++len;
            temp = temp.next;
        }
        temp = head;
        int kg = len / k, cnt = 0;
        ListNode prev = dummy;
        if (kg == 0)
            return head;
        while (cnt < kg) {
            t = temp;
            ListNode[] ln = rec(temp, k, null);
            prev.next = ln[0];
            prev = temp;
            temp = ln[1];
            ++cnt;
        }
        t.next = temp;
        return dummy.next;
    }

    private ListNode[] rec(ListNode temp, int k, ListNode prev) {
        if (k == 1) {
            ListNode next = temp.next;
            temp.next = prev;
            ListNode[] ln = new ListNode[]{temp, next};
            return ln;
        }
        ListNode[] ln = rec(temp.next, k - 1, temp);
        temp.next = prev;
        return ln;
    }

}
