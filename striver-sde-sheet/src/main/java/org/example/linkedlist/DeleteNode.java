package org.example.linkedlist;


//Problem link: https://leetcode.com/problems/delete-node-in-a-linked-list/
//Level: Easy
public class DeleteNode {
    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //TC: O(N)
    //SC: O(1)
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while (node != null && node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }

    //TC: O(1)
    //SC: O(1)
    public void deleteNode1(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
