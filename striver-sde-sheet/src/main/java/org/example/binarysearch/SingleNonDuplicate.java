package org.example.binarysearch;

//Time Complexity: O(logn)
//Space Complexity: O(1)
//Problem link: https://leetcode.com/problems/single-element-in-a-sorted-array/
//Level: Medium
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1, n = nums.length;
        while (l < h) {
            int m = h - (h - l) / 2;
            boolean isDupOnLeft = false, isDupOnRight = false;
            if (m > 0 && nums[m - 1] == nums[m]) {
                isDupOnLeft = true;
            } else if (m < n - 1 && nums[m] == nums[m + 1]) {
                isDupOnRight = true;
            }
            if (!isDupOnLeft && !isDupOnRight) {
                return nums[m];
            }
            if (isDupOnLeft) {
                if ((m - 1) % 2 == 0) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            } else {
                if ((n - m) % 2 == 0) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return nums[l];
    }
}
