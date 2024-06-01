package org.example.trees;

//Time Complexity: O(n*n)
//Space Complexity: O(n)
//Problem link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
//Level: Medium
public class BuildTreeFromInAndPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return build(0, n-1, 0, n-1, inorder, postorder);
    }
    private TreeNode build(int i_in, int j_in, int i_po, int j_po, int[] in, int[] post){
        if(i_in > j_in || i_po > j_po){
            return null;
        }
        TreeNode root = new TreeNode(post[j_po]);
        int ind = findIndex(post[j_po], in, i_in, j_in);
        int left = ind-i_in, right = j_in-ind;
        root.left = build(i_in, ind-1, i_po, i_po+left-1, in, post);
        root.right = build(ind+1, j_in, j_po-right, j_po-1, in, post);
        return root;
    }
    private int findIndex(int ele, int[] in, int i, int j){
        while(i <= j){
            if(in[i] == ele){
                return i;
            }
            i ++;
        }
        return -1;
    }
}
