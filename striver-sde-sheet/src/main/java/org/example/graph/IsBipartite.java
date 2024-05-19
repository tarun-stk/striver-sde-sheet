package org.example.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//TC: O(N)
//SC: O(n)+O(n) -> charArray,rec stack space
//Problem link: https://leetcode.com/problems/is-graph-bipartite/
//Level: Medium
public class IsBipartite {

    //    DFS
    //TC: O(N)
    //SC: O(n)+O(n) -> rec stack space
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        char[] set = new char[n];
        Arrays.fill(set, 'C');
        for (int i = 0; i < n; i++) {
            if (set[i] == 'C') {
                if (!dfs(i, graph, set, 'D', 'A')) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int[][] graph, char[] set, char prev, char next) {
        if (set[node] == prev) {
            return false;
        }
        if (set[node] != 'C')
            return true;
        set[node] = next;
        if (set[node] == 'A') {
            next = 'B';
        } else {
            next = 'A';
        }
        for (int neigh : graph[node]) {
            if (!dfs(neigh, graph, set, set[node], next)) {
                return false;
            }
        }
        return true;
    }

    //    BFS
    //TC: O(N)
    //SC: O(n)+O(n) -> charArray,queue
    public boolean isBipartite1(int[][] graph) {
        int n = graph.length;
        char[] set = new char[n];
        Arrays.fill(set, 'C');
        for (int i = 0; i < n; i++) {
            if (set[i] == 'C') {
                if (!bfs(i, graph, set)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int node, int[][] graph, char[] set) {
        Queue<Integer> q = new LinkedList<>();
        set[node] = 'A';
        q.offer(node);
        while (!q.isEmpty()) {
            int s = q.size();
            while (s-- > 0) {
                int p = q.poll();
                char next;
                if (set[p] == 'A') {
                    next = 'B';
                } else {
                    next = 'A';
                }
                for (int nei : graph[p]) {
                    if (set[nei] == set[p]) {
                        return false;
                    }
                    if (set[nei] != 'C')
                        continue;
                    set[nei] = next;
                    q.offer(nei);
                }
            }
        }
        return true;
    }
}

