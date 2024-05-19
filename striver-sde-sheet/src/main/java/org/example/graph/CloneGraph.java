package org.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TC: O(V+E)
//SC: O(V) + O(V+E)
//Problem link: https://leetcode.com/problems/clone-graph/
//Level: Medium
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        // old, new
        Map<Node, Node> map = new HashMap<>();
        solve(node, map);
        return map.get(node);
    }

    private void solve(Node node, Map<Node, Node> map) {
        if (map.containsKey(node) || node == null) {
            return;
        }
        Node newNode = new Node(node.val, new ArrayList());
        map.put(node, newNode);
        for (Node n : node.neighbors) {
            solve(n, map);
        }
        for (Node n : node.neighbors) {
            map.get(node).neighbors.add(map.get(n));
        }
    }
}
