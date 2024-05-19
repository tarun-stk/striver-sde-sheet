package org.example.recursion;

//TC: O(2^n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/target-sum/
// Level: Medium
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return rec(0, target, nums, n);
    }

    private int rec(int idx, int target, int[] nums, int n) {
        if (idx == n - 1) {
            if (target == -nums[idx] && target == nums[idx]) {
                return 2;
            }
            if (target == -nums[idx] || target == nums[idx]) {
                return 1;
            }
            return 0;
        }
        return rec(idx + 1, target - nums[idx], nums, n) + rec(idx + 1, target + nums[idx], nums, n);
    }
}
