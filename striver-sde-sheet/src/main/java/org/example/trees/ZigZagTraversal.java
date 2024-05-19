package org.example.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//TC: O(n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
// Level: Medium
public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        List<List<Integer>> ans = new LinkedList<>();

        int l = 0;
        st.push(root);
        while (!st.isEmpty()) {

            if (l % 2 != 0) {
                st = even(st, ans);
            } else {
                st = odd(st, ans);
            }
            l++;

        }
        return ans;
    }

    private Stack<TreeNode> even(Stack<TreeNode> st, List<List<Integer>> ans) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!st.isEmpty()) {
            TreeNode r = st.pop();
            list.add(r.val);
            if (r.right != null) {
                stack.push(r.right);
            }
            if (r.left != null) {
                stack.push(r.left);
            }
        }

        ans.add(list);
        return stack;
    }

    private Stack<TreeNode> odd(Stack<TreeNode> st, List<List<Integer>> ans) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!st.isEmpty()) {
            TreeNode r = st.pop();
            list.add(r.val);
            if (r.left != null) {
                stack.push(r.left);
            }
            if (r.right != null) {
                stack.push(r.right);
            }

        }
        ans.add(list);
        return stack;
    }
}
