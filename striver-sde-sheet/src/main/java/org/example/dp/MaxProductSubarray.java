package org.example.dp;

//TC: O(N)
//SC: O(1)
//Problem link: https://leetcode.com/problems/maximum-product-subarray/description/
//Level: Medium
public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int suff = 1;
        int pre = 1;
        int n = nums.length;
        for(int i = 0; i < n; i ++){
            if(pre == 0)
                pre = 1;
            if(suff == 0)
                suff = 1;
            pre = pre*nums[i];
            suff = suff * nums[n-i-1];
            max = Math.max(max, Math.max(pre, suff));
        }
        return max;
    }
}
