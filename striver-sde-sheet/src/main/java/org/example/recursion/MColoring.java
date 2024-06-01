package org.example.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity: O(n*m^n)
//Space Complexity: O(n^2)
//Problem link: https://leetcode.com/problems/palindrome-partitioning/description/
//Level: Medium
public class MColoring {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        List<Integer>[] adj = new ArrayList[n];
        int[] col = new int[n];
        Arrays.fill(col, -1);
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j]) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (col[i] == -1) {
                if (!dfs(0, adj, m, n, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, List<Integer>[] adj, int m, int n, int[] col) {
        if (node == n) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            if (col[node] == -1) {
                col[node] = i;
                if (!isPossible(node, adj, col)) {
                    col[node] = -1;
                    continue;
                } else {
                    if (dfs(node + 1, adj, m, n, col)) {
                        return true;
                    } else {
                        col[node] = -1;
                    }
                }
            }
        }
        return false;
    }

    private boolean isPossible(int node, List<Integer>[] adj, int[] col) {
        for (int nei : adj[node]) {
            if (col[node] == col[nei]) {
                return false;
            }
        }
        return true;
    }
}
