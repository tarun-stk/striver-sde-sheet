package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

//TC: O(m*n)
//SC: O(m*n)
//Problem link: https://leetcode.com/problems/rotting-oranges/
// Level: Medium
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
        byte[][] dirs = new byte[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int s = q.size();
            while (s-- > 0) {
                int[] poll = q.poll();
                int r = poll[0], c = poll[1];
                for (int i = 0; i < 4; i++) {
                    if (r + dirs[i][0] > -1 && r + dirs[i][0] < m && c + dirs[i][1] > -1 && c + dirs[i][1] < n && grid[r + dirs[i][0]][c + dirs[i][1]] == 1) {
                        grid[r + dirs[i][0]][c + dirs[i][1]] = 2;
                        q.offer(new int[]{r + dirs[i][0], c + dirs[i][1]});
                    }
                }
            }
            count++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count - 1 < 0 ? 0 : count - 1;
    }
}
