package org.example.trees;

//We make n recursive calls, and in each substantial call, string length
//is increasing by almost 2x, -> exponential
//TC: O(N)
//SC: O(level of tree)
//Problem link: https://www.geeksforgeeks.org/problems/mirror-tree/1
//Level: Easy

public class MirrorTree {
    void mirror(Node node) {
        call(node);
    }

    private Node call(Node node) {
        if (node == null)
            return null;
        Node left = node.left;
        node.left = call(node.right);
        node.right = call(left);
        return node;
    }
}
