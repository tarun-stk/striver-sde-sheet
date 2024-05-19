package org.example.dp;

import java.util.Arrays;

//TC: O(n*n*n)
//SC: O(n*n) + O(n)
//Problem link: https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
// Level: Medium
public class MatrixChainMultiplication {
    static int matrixMultiplication(int N, int arr[]) {
        // code here
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(1, N - 1, arr, dp);
    }

    static private int solve(int i, int j, int[] arr, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solve(i, k, arr, dp) + solve(k + 1, j, arr, dp);
            temp += arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, temp);
        }
        return dp[i][j] = min;
    }
}
