package org.example.arrays;

//TC: O(2*N)
//SC: O(2*N)
//Problem link: https://leetcode.com/problems/trapping-rain-water/
//Level: Hard
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length, ml = 0, mr = 0, ans = 0;
        int[] prem = new int[n], suffm = new int[n];
        for (int i = 0; i < n; i++) {
            ml = Math.max(ml, height[i]);
            prem[i] = ml;
            mr = Math.max(mr, height[n - i - 1]);
            suffm[n - 1 - i] = mr;
        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(prem[i], suffm[i]) - height[i];
        }
        return ans;
    }
}
