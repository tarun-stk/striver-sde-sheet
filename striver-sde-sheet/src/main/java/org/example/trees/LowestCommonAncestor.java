package org.example.trees;

import java.util.HashMap;
import java.util.Map;

//TC: O(n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Level: Medium
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        findPar(root, null, map);
        int pheight = findHeight(root, p, 0);
        int qheight = findHeight(root, q, 0);
        while(pheight > qheight){
            p = map.get(p);
            pheight --;
        }
        while(qheight > pheight){
            q = map.get(q);
            qheight --;
        }
        while(p != q){
            p = map.get(p);
            q = map.get(q);
        }
        return p;
    }
    private void findPar(TreeNode root, TreeNode par, Map<TreeNode, TreeNode> map){
        if(root == null)
            return;
        map.put(root, par);
        findPar(root.left, root, map);
        findPar(root.right, root, map);
    }
    private int findHeight(TreeNode root, TreeNode r, int h){
        if(root == null)
            return 0;
        if(root == r)
            return h;
        return findHeight(root.left, r, h+1) + findHeight(root.right, r, h+1);
    }
}
