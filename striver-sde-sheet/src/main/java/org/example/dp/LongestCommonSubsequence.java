package org.example.dp;

import java.util.Arrays;

//Problem link: https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
// Level: Medium
public class LongestCommonSubsequence {
    // TC: O(2^(m+n))
    // SC: O(n+m)
    public int longestCommonSubsequence(String t1, String t2) {
        int m = t1.length(), n = t2.length();
        return rec(0, 0, m, n, t1, t2);
    }

    private int rec(int i, int j, int m, int n, String t1, String t2) {
        if (i == m || j == n) {
            return 0;
        }
        if (t1.charAt(i) == t2.charAt(j)) {
            return 1 + rec(i + 1, j + 1, m, n, t1, t2);
        }
        return Math.max(rec(i, j + 1, m, n, t1, t2), rec(i + 1, j, m, n, t1, t2));
    }

    // TC: O(m*n))
    // SC: O(n+m) + O(n*m)
    public int longestCommonSubsequenceUsingMemoization(String t1, String t2) {
        int m = t1.length(), n = t2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(0, 0, m, n, t1, t2, dp);
    }

    private int rec(int i, int j, int m, int n, String t1, String t2, int[][] dp) {
        if (i == m || j == n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (t1.charAt(i) == t2.charAt(j)) {
            return dp[i][j] = 1 + rec(i + 1, j + 1, m, n, t1, t2, dp);
        }
        return dp[i][j] = Math.max(rec(i, j + 1, m, n, t1, t2, dp), rec(i + 1, j, m, n, t1, t2, dp));
    }

    // TC: O(m*n))
    // SC: O(n*m)
    public int longestCommonSubsequenceUsingTabulation(String t1, String t2) {
        int m = t1.length(), n = t2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                if (t1.charAt(i) == t2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    continue;
                }
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
