package org.example.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TC: O(N*N)
//SC: O(N+M)
//Problem link: https://leetcode.com/problems/word-break/
//Level: Medium
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        Boolean[] dp = new Boolean[n];
        return solve(0, set, s, s.length(), dp);
    }

    private boolean solve(int i, Set<String> set, String s, int n, Boolean[] dp) {
        if (i == n) {
            return true;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        StringBuilder sb = new StringBuilder("");
        for (int j = i; j < n; j++) {
            sb.append(s.charAt(j));
            if (set.contains(sb.toString())) {
                if (solve(j + 1, set, s, n, dp)) {
                    return dp[i] = true;
                }
            }
        }
        return dp[i] = false;
    }
}
