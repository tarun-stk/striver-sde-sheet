package org.example.trees;

//TC: O(N*N)
//SC: O(N)
//Problem link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//Level: Medium
public class BuildTreeFromInorderAndPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] arr = new int[1];
        arr[0] = -1;
        return build(0, preorder.length - 1, arr, preorder, inorder);
    }

    private TreeNode build(int i, int j, int[] arr, int[] p, int[] in) {
        if (i > j) {
            return null;
        }
        arr[0]++;
        TreeNode root = new TreeNode(p[arr[0]]);
        int ind = find(p[arr[0]], in, i, j);
        root.left = build(i, ind - 1, arr, p, in);
        root.right = build(ind + 1, j, arr, p, in);
        return root;
    }

    private int find(int k, int[] arr, int i, int j) {
        while (i <= j) {
            if (arr[i] == k) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
