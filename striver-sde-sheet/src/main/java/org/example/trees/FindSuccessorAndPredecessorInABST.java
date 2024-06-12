package org.example.trees;

//Time Complexity: O(h)
//Space Complexity: O(1)
//Problem link: https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
//Level: Medium
public class FindSuccessorAndPredecessorInABST {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        findSuc(root, suc, key);
        findPre(root, pre, key);
    }

    private static void findSuc(Node root, Node[] suc, int key) {
        if (root == null) {
            return;
        }
        if (root.data <= key) {
            findSuc(root.right, suc, key);
            return;
        }
        if (root.data > key) {
            if (suc[0] != null && root.data > suc[0].data)
                return;
            suc[0] = root;
            findSuc(root.left, suc, key);
        }
    }

    private static void findPre(Node root, Node[] pre, int key) {
        if (root == null) {
            return;
        }
        if (root.data >= key) {
            findPre(root.left, pre, key);
            return;
        }
        if (root.data <= key) {
            if (pre[0] != null && root.data < pre[0].data)
                return;
            pre[0] = root;
            findPre(root.right, pre, key);
        }
    }
}
