package org.example.trees;

import java.util.LinkedList;
import java.util.Queue;

//TC: O(N)
//SC: O(N)
//Problem link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//Level: Medium
public class NextRightPointer {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int s = q.size();
            while (s-- > 0) {
                Node node = q.poll();
                if (s != 0) {
                    node.next = q.peek();
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return root;
    }
}
