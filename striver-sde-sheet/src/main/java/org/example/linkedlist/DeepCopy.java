package org.example.linkedlist;

import java.util.HashMap;
import java.util.Map;

//TC: O(N)
//SC: O(N) -> new nodes + O(N) -> stack space
//Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
//Level: Medium
public class DeepCopy {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        return copy(head, map);
    }
    private Node copy(Node head, Map<Node, Node> map){
        if(head == null)
            return null;
        Node newhead = new Node(head.val);
        map.put(head, newhead);
        newhead.next = copy(head.next, map);
        newhead.random = map.get(head.random);
        return newhead;
    }
}
