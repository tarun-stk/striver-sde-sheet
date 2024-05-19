package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//TC(Time Complexity): O((V + E) * log V), where V is the number of vertices and E is the number of
//  edges in the graph. This is because in the worst case, each vertex and each edge may be processed once,
//  and the priority queue operations take O(log V) time.
//SC(Space Complexity):The space complexity of this implementation is O(V+E),
//  where V is the number of vertices and E is the number of edges.
//  This is due to the space used for the distance array(dist[]),the priority queue(pq),
//  and the adjacency list representation of the graph(adj).
//Problem link: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
//Level: Hard
public class MinimumSpanningTree {
    static int spanningTree(int V, int E, int edges[][]) {
        // Code Here.
        List<List<Integer>>[] adj = new ArrayList[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] v = new boolean[V];
        int sum = 0;
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(Arrays.asList(edge[1], edge[2]));
            adj[edge[1]].add(Arrays.asList(edge[0], edge[2]));
        }
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.remove();
            int node = poll[1];
            int wt = poll[0];
            if (!v[node]) {
                v[node] = true;
                sum += wt;
                for (List<Integer> list : adj[node]) {
                    if (!v[list.get(0)]) {
                        pq.add(new int[]{list.get(1), list.get(0)});
                    }
                }
            }
        }
        return sum;
    }
}
