package org.example.binarysearch;

//Time Complexity: O(logn)
//Space Complexity: O(1)
//Problem link: https://leetcode.com/problems/search-in-rotated-sorted-array/
//Level: Medium
public class FindInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        if (nums[l] <= nums[h]) {
            return findAns(nums, target, l, h);
        }
        int rotIndex = find(nums);
        if (target >= nums[l] && target <= nums[rotIndex - 1]) {
            return findAns(nums, target, l, rotIndex - 1);
        }
        return findAns(nums, target, rotIndex, h);
    }

    private int findAns(int[] nums, int t, int l, int h) {
        while (l <= h) {
            int m = h - (h - l) / 2;
            if (nums[m] > t) {
                h = m - 1;
            } else if (nums[m] < t) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    private int find(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (nums[low] > nums[mid] && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[low] > nums[mid]) {
                high = mid - 1;
            } else if (nums[low] < nums[mid]) {
                low = mid;
            }
        }
        return -1;
    }
}
