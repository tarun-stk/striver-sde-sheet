package org.example.trees;

//TC: O(n)
//SC: O()
//Problem link: https://leetcode.com/problems/diameter-of-binary-tree/description/
// Level: Easy
public class MaxDiameter {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] arr = new int[1];
        diam(root, arr);
        return arr[0];
    }

    private int diam(TreeNode root, int[] arr) {
        if (root == null)
            return 0;
        int left = diam(root.left, arr);
        int right = diam(root.right, arr);
        arr[0] = Math.max(arr[0], left + right);
        return Math.max(left, right) + 1;
    }
}
