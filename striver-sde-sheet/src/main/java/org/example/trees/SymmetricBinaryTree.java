package org.example.trees;

//We make n recursive calls, and in each substantial call, string length
//is increasing by almost 2x, -> exponential
//TC: O(N)
//SC: O(level of tree)
//Problem link: https://leetcode.com/problems/symmetric-tree/
//Level: Medium

public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return rec(root.left, root.right);
    }

    private boolean rec(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;
        if (r1 == null)
            return false;
        if (r2 == null)
            return false;
        if (r1.val != r2.val)
            return false;
        return rec(r1.left, r2.right) && rec(r1.right, r2.left);
    }
}
