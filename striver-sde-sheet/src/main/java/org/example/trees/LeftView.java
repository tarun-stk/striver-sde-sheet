package org.example.trees;

import java.util.ArrayList;

//TC: O(n)
//SC: O(n)
//Problem link: https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
//Level: Easy
public class LeftView {

    private class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        rec(root, ans, 0);
        return ans;
    }
    private void rec(Node root, ArrayList<Integer> ans, int d){
        if(root == null)
            return;
        if(ans.size() == d)
            ans.add(root.data);

        rec(root.left, ans, d+1);
        rec(root.right, ans, d+1);
    }
}
