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
//Problem link: https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
//Level: Medium

public class Dijkshtra {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{S, 0});
        dist[S] = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.remove();
            int d = poll[1];
            int n = poll[0];
            for (List<Integer> list : adj.get(n)) {
                if (dist[list.get(0)] > d + list.get(1)) {
                    dist[list.get(0)] = d + list.get(1);
                    pq.add(new int[]{list.get(0), d + list.get(1)});
                }
            }
        }
        return dist;
    }
}
