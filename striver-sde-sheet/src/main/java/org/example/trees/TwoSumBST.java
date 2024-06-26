package org.example.trees;

import java.util.HashSet;
import java.util.Set;

//TC: O(n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
// Level: Medium
public class TwoSumBST {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
}
