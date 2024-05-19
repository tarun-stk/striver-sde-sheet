package org.example.recursion;

import java.util.ArrayList;

//TC: O(4^N)
//SC: O(N+4^N)
//Problem link: https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
//Level: Medium
public class RatInAMaze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here

        ArrayList<String> ans = new ArrayList<String>();
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) {
            return ans;
        }
        solve(0, 0, n, m, "", ans);
        return ans;
    }

    private static void solve(int i, int j, int n, int[][] m, String s, ArrayList<String> ans) {
        if (i == n - 1 && j == n - 1) {
            ans.add(s);
            return;
        }
        if (i < 0 || j < 0 || i == n || j == n || m[i][j] == 0) {
            return;
        }
        m[i][j] = 0;
        solve(i + 1, j, n, m, s + "D", ans);
        solve(i - 1, j, n, m, s + "U", ans);
        solve(i, j - 1, n, m, s + "L", ans);
        solve(i, j + 1, n, m, s + "R", ans);
        m[i][j] = 1;
    }
}
