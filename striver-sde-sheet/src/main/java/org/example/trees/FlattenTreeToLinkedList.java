package org.example.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Problem link:

// Level: Medium
public class FlattenTreeToLinkedList {
    // recursion
    // TC: O(n)
    // SC: O(n)
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    // TC: O(n)
    // SC: O(n)
    public void flattenUsingStack(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode poll = st.pop();
            if (poll.right != null) {
                st.push(poll.right);
            }
            if (poll.left != null) {
                st.push(poll.left);
            }
            if (!st.isEmpty())
                poll.right = st.peek();
            poll.left = null;
        }
    }

    // TC: O(n)
    // SC: O(n)
    public void flattenUsingQueue(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        preorder(root, q);
        TreeNode head = root;
        head = q.poll();
        head.left = null;
        while (!q.isEmpty()) {
            head.right = q.poll();
            head = head.right;
            head.left = null;
        }
    }

    void preorder(TreeNode root, Queue<TreeNode> q) {
        if (root == null)
            return;
        q.offer(root);
        preorder(root.left, q);
        preorder(root.right, q);

    }
}
