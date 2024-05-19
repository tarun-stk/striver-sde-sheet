package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

//TC: O(N*M)
//SC: O(N*M)
//Problem link: https://leetcode.com/problems/flood-fill/
//Level: Medium
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int col = image[sr][sc];
        if (col == color) {
            return image;
        }
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = dirs[i][0];
                int c = dirs[i][1];
                if (poll[0] + r > -1 && poll[0] + r < m && poll[1] + c > -1 && poll[1] + c < n) {
                    if (image[poll[0] + r][poll[1] + c] == col) {
                        q.offer
                                (new int[]{poll[0] + r, poll[1] + c});
                        image[poll[0] + r][poll[1] + c] = color;
                    }
                }
            }
        }
        return image;
    }
}
