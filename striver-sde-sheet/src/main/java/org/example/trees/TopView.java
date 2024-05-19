package org.example.trees;

import java.util.*;

//TC: O(N)
//SC: O(n)
//Problem link: https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
//Level: Medium

public class TopView {

    static ArrayList<Integer> topView(Node root) {
        // add your code
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        q.offer(new Pair(0, root));
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                Pair qp = q.poll();
                Node node = qp.node;
                if (!map.containsKey(qp.hd)) {
                    map.put(qp.hd, node.data);
                }
                if (node.left != null) {
                    q.offer(new Pair(qp.hd - 1, node.left));
                }
                if (node.right != null) {
                    q.offer(new Pair(qp.hd + 1, node.right));
                }
            }
        }

        return new ArrayList<>(map.values());
    }
}

class Pair {
    int hd;
    Node node;

    public Pair(int hd, Node node) {
        this.hd = hd;
        node = node;
    }
}


