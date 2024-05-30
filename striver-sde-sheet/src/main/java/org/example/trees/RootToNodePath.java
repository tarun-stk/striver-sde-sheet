package org.example.trees;

import java.util.ArrayList;

//TC: O(n)
//SC: O(height of tree)
//Problem link: https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
// Level: Medium
public class RootToNodePath {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        dfs(root, new ArrayList<>(), ans);
        return ans;
    }
    private static void dfs(Node root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.data);
            ans.add(new ArrayList(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.data);
        dfs(root.left, list, ans);
        dfs(root.right, list, ans);
        list.remove(list.size()-1);

    }
}
