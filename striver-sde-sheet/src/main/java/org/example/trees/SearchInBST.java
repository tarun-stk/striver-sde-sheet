package org.example.trees;

//TC: O(N)
//SC: O(N)
//Problem link: https://leetcode.com/problems/search-in-a-binary-search-tree/
//Level: Easy
public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(root.val > val){
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}
