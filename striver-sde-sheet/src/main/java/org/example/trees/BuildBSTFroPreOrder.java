package org.example.trees;

//Time Complexity: O(n*n)  -> n for solve function, n for findGreaterIndex function in worst case
//it will scan all elements in while loop
//Space Complexity: O(n)
//Problem link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
//Level: Medium
public class BuildBSTFroPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return solve(0, n-1, preorder);
    }
    private TreeNode solve(int i, int j, int[] preorder){
        if(i > j){
            return null;
        }
        if(i == j){
            return new TreeNode(preorder[i]);
        }
        TreeNode root = new TreeNode(preorder[i]);
        int ind = findGreaterIndex(preorder[i], i+1, j, preorder);
        root.left = solve(i+1, ind-1, preorder);
        root.right = solve(ind, j, preorder);
        return root;
    }
    private int findGreaterIndex(int ele, int i, int j, int[] preorder){
        while(i <= j){
            if(preorder[i] > ele){
                return i;
            }
            i ++;
        }
        return j+1;
    }
}
