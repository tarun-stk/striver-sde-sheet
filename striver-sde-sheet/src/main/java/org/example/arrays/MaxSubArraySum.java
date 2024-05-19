package org.example.arrays;

//TC: O(N)
//SC: O(1)
    //Problem link: https://leetcode.com/problems/maximum-subarray/description/
//Level: Medium

//Kadane's Algo
public class MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int prev = nums[n-1], max = nums[n-1];
        for(int i = n-2; i > -1; i --){
            if(nums[i] < nums[i]+prev){
                prev = nums[i]+prev;
            }
            else
                prev = nums[i];
            max = Math.max(max, prev);
        }
        return max;
    }
}
