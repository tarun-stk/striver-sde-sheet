package org.example.trees;

import java.util.*;

//TC: O(1)
//SC: O(n)
//Problem link: https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
// Level: Medium
public class BottomView {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int s = q.size();
            while (s-- > 0) {
                Pair p = q.poll();
                map.put(p.vp, p.root.data);
                if (p.root.left != null) {
                    q.offer(new Pair(p.root.left, p.vp - 1));
                }
                if (p.root.right != null) {
                    q.offer(new Pair(p.root.right, p.vp + 1));
                }
            }
        }
        return new ArrayList<>(map.values());
    }

    class Pair {
        Node root;
        int vp;

        public Pair(Node node, int vp) {
            root = node;
            this.vp = vp;
        }
    }
}
