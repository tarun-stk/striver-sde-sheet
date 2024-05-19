package org.example.arrays;

//TC: O(N)
//SC: O(1)
//Problem link: https://leetcode.com/problems/max-consecutive-ones/
//Level: Easy
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}
