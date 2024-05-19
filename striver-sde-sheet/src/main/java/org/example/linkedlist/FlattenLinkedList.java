package org.example.linkedlist;

//k ->  is the number of lists.
//n -> total number of nodes
//Time Complexity: O(nlogk)
//Space Complexity: O(1)
//Problem link: https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
//Level: Medium
public class FlattenLinkedList {

    private class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    private Node flatten(Node root) {
        // Your code here
        return mergeNSortedLists(root);
    }

    private Node mergeNSortedLists(Node root) {
        if (root.next == null)
            return root;
        Node next = mergeNSortedLists(root.next);
        return merge(root, next);
    }

    private Node merge(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node ans = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                dummy.bottom = l1;
                l1 = l1.bottom;
            } else {
                dummy.bottom = l2;
                l2 = l2.bottom;
            }
            dummy = dummy.bottom;
        }
        if (l1 != null) dummy.bottom = l1;
        if (l2 != null) dummy.bottom = l2;
        return ans.bottom;
    }
}
