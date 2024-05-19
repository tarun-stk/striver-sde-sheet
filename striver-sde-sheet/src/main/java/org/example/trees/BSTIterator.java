package org.example.trees;

import java.util.Stack;

//TC: O(1)
//SC: O(n)
//Problem link: https://leetcode.com/problems/binary-search-tree-iterator/
// Level: Medium
class BSTIterator {

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }

    }

    public int next() {
        TreeNode poll = st.pop();
        int val = poll.val;
        poll = poll.right;
        while (poll != null) {
            st.push(poll);
            poll = poll.left;
        }
        return val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
