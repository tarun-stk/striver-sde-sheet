package org.example.trees;

//TC: O(n)
//SC: O(1)
//Problem link: https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
//Level: Medium
public class KthLargestInBST {
    public int kthLargest(Node root, int K) {
        //Your code here
        int[] ans = new int[1], temp = new int[1];
        solve(root, K, ans, temp);
        return ans[0];
    }

    private void solve(Node root, int k, int[] ans, int[] temp) {
        if (root == null)
            return;
        solve(root.right, k, ans, temp);
        temp[0] += 1;
        if (temp[0] == k) {
            ans[0] = root.data;
            return;
        }
        solve(root.left, k, ans, temp);
    }
}
