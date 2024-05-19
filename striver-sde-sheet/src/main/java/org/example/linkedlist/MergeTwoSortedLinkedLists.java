package org.example.linkedlist;

//Time Complexity: O(n)
//Space Complexity: O(1)
//Problem link: https://leetcode.com/problems/merge-two-sorted-lists/
//Level: Medium
public class MergeTwoSortedLinkedLists {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 != null) dummy.next = l1;
        if (l2 != null) dummy.next = l2;
        return ans.next;
    }
}
