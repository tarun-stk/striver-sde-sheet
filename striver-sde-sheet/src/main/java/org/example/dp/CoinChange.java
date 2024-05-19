package org.example.dp;

import java.util.Arrays;

//Problem link: https://leetcode.com/problems/coin-change/
//Level: Medium
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = rec(0, amount, coins, n, dp);
        if (ans >= (int) 1e9)
            return -1;
        return ans;
    }

    private int rec(int i, int amount, int[] coins, int n, int[][] dp) {
        if (i == n) {
            if (amount == 0) {
                return 0;
            }
            return (int) 1e9;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int pick = Integer.MAX_VALUE;
        if (coins[i] <= amount) {
            pick = 1;
            pick += rec(i, amount - coins[i], coins, n, dp);
        }
        int nonpick = rec(i + 1, amount, coins, n, dp);
        return dp[i][amount] = Math.min(pick, nonpick);
    }

    // TC: O(n*amount)
    // SC: O(n*amount)
    public int coinChange1(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        Arrays.fill(dp[n-1], (int)1e9);
        for(int i = 0; i <= amount; i ++){
            if(i%coins[n-1] == 0){
                dp[n-1][i] = i/coins[n-1];
            }
        }

        for(int i = n-2; i > -1; i --){
            for(int am = 0; am <= amount; am ++){
                int pick = Integer.MAX_VALUE;
                if(coins[i] <= am){
                    pick = 1;
                    pick += dp[i][am-coins[i]];
                }
                int nonpick = dp[1+i][am];
                dp[i][am] = Math.min(pick, nonpick);
            }
        }

        return dp[0][amount] >= (int)1e9? -1: dp[0][amount];
    }


}
