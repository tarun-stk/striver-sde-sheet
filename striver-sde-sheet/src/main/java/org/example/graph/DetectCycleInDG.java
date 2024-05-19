package org.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TC: O(V+E)
//SC: O(V+E)
//Adjacency List (adj): The space required for the adjacency list is O(V + E)
// since each vertex is stored once and each edge is stored once.
//Problem link: https://leetcode.com/problems/course-schedule/
//Level: Medium
public class DetectCycleInDG {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];
        int[] in = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
        }
        for (int[] p : prerequisites) {
            in[p[0]]++;
            adj[p[1]].add(p[0]);
        }
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int no : adj[poll]) {
                if (--in[no] == 0) {
                    q.offer(no);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (in[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
