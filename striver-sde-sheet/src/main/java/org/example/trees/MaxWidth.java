package org.example.trees;

import java.util.LinkedList;
import java.util.Queue;

//TC: O(N)
//SC: O(N)
//Problem link: https://leetcode.com/problems/maximum-width-of-binary-tree/
//Level: Medium
public class MaxWidth {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));

        while(!q.isEmpty()){
            int s = q.size();
            int s1 = s, f = -1;
            int track = 0;
            while(s -- > 0){
                Pair p = q.poll();
                if(s1-1 == s){
                    f = p.pos;
                }
                track = p.pos;
                if(p.root.left != null){
                    q.offer(new Pair(p.root.left, 2*p.pos-1));
                }
                if(p.root.right != null){
                    q.offer(new Pair(p.root.right, 2*p.pos));
                }
            }
            ans = Math.max(ans, track+1-f);
        }
        return ans;

    }
    class Pair{
        TreeNode root;
        int pos;
        Pair(TreeNode root, int pos){
            this.pos = pos;
            this.root = root;
        }
    }
}
