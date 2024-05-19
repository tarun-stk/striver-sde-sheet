package org.example.trees;

//TC: O(n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
// Level: Medium
public class KthSmallestInABST {
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1], cnt = new int[1];
        solve(root, k, ans, cnt);
        return ans[0];
    }
    private void solve(TreeNode root, int k, int[] ans, int[] cnt){
        if(root == null){
            return;
        }
        solve(root.left, k, ans, cnt);
        cnt[0] += 1;
        if(cnt[0] == k){
            ans[0] = root.val;
        }
        solve(root.right, k, ans, cnt);
    }
}
