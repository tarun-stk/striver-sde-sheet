package org.example.dp;

import java.util.Arrays;

//Problem link: https://leetcode.com/problems/partition-equal-subset-sum/
//416. Partition Equal Subset Sum
//Level: Medium
public class SubsetSum {
    // TC: O(n*totSum/2) -> building dp array + O(n) -> calc totalsum
    // SC: O(n*totSum/2) -> dp array +O(n) -> stakc space
    public boolean canPartitionBottomUp(int[] nums) {
        int n = nums.length;
        int totSum = Arrays.stream(nums).reduce((a, b) -> a + b).getAsInt();
        if (totSum % 2 != 0)
            return false;
        Boolean[][] dp = new Boolean[n][totSum / 2 + 1];
        return rec(0, n, nums, dp, totSum / 2);
    }

    private boolean rec(int i, int n, int[] nums, Boolean[][] dp, int sum) {
        if (i == n) {
            if (sum == 0)
                return true;
            return false;
        }
        if (dp[i][sum] != null)
            return dp[i][sum];
        // pick
        boolean pick = false;
        if (sum - nums[i] >= 0) {
            pick = rec(i + 1, n, nums, dp, sum - nums[i]);
        }
        // nonpic
        boolean nonpick = rec(i + 1, n, nums, dp, sum);
        return dp[i][sum] = pick || nonpick;
    }

    public boolean canPartitionTopDown(int[] nums) {
//        TC: O(n)*O(totSum/2)
//        SC: O(n)*O(totSum/2)
        int n = nums.length;
        int totSum = Arrays.stream(nums).reduce((a, b) -> a + b).getAsInt();
        if (totSum % 2 != 0)
            return false;
        Boolean[][] dp = new Boolean[n][totSum / 2 + 1];
        Arrays.fill(dp[n-1], false);
        if(nums[n-1] <= totSum/2){
            dp[n - 1][nums[n - 1]] = true;
        }
        for (int i = n - 2; i > -1; i--) {
            for(int j = totSum/2; j > -1; j --){
                // pick
                boolean pick = false;
                if (j - nums[i] >= 0) {
                    pick = dp[i + 1][j - nums[i]];
                }
                // nonpic
                boolean nonpick = dp[i + 1][j];
                dp[i][j] = pick || nonpick;
            }
        }
        return dp[0][totSum/2];
    }

}
