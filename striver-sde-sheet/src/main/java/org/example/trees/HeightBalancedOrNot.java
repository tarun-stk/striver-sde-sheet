package org.example.trees;

//TC: O(N)
//SC: O(N)
//Problem link: https://leetcode.com/problems/balanced-binary-tree/
//Level: Easy
public class HeightBalancedOrNot {
    public boolean isBalanced(TreeNode root) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        dfs(root, ans);
        return ans[0];
    }

    private int dfs(TreeNode root, boolean[] ans) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, ans);
        int right = dfs(root.right, ans);
        if (Math.abs(left - right) > 1) {
            ans[0] = false;
        }
        return Math.max(left, right) + 1;
    }
}
