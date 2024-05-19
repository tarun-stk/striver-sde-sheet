package org.example.trees;

//TC: O(N)
//SC: O(N)
//Problem link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
//Level: Easy
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
