package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//TC: O(v*e)
//SC: O(v)
//Problem link: https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/0?fbclid=IwAR2_lL0T84DnciLyzMTQuVTMBOi82nTWNLuXjUgahnrtBgkphKiYk6xcyJU
//Level: Medium
public class BellmanFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] d = new int[V];
        Arrays.fill(d, (int) 1e8);
        d[S] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (List<Integer> list : edges) {
                int u = list.get(0);
                int v = list.get(1);
                int dist = list.get(2);
                if (d[u] != (int) 1e8 && d[u] + dist < d[v]) {
                    d[v] = d[u] + dist;
                }
            }
        }

        for (List<Integer> list : edges) {
            int u = list.get(0);
            int v = list.get(1);
            int dist = list.get(2);
            if (d[u] != (int) 1e8 && d[u] + dist < d[v]) {
                return new int[]{-1};
            }
        }

        return d;
    }
}
