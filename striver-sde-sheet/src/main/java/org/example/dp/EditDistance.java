package org.example.dp;

import java.util.Arrays;

//Problem link: https://leetcode.com/problems/edit-distance/
//Level: Medium
public class EditDistance {

//    TC: O(m)(n)
//    SC: O(m)(n) + O(m+n)
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(0, 0, m, n, word1, word2, dp);
    }

    private int rec(int i, int j, int m, int n, String w1, String w2, int[][] dp) {
        if (i == m) {
            return n - j;
        }
        if (j == n) {
            return m - i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (w1.charAt(i) == w2.charAt(j)) {
            return rec(i + 1, j + 1, m, n, w1, w2, dp);
        }
        return dp[i][j] = 1 + Math.min(rec(i + 1, j, m, n, w1, w2, dp), Math.min(rec(i, j + 1, m, n, w1, w2, dp), rec(i + 1, j + 1, m, n, w1, w2, dp)));
    }
}
