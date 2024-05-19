package org.example.binarysearch;

//Time Complexity: O(log(n+m))
//Space Complexity: O(1)
//Problem link: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
//Level: Medium
public class MedianInTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Approach from TUF.
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1;
        int left = (n1 + n2 + 1) / 2;
        while (low <= high) {
            int mid1 = high - (high - low) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 - 1 > -1) l1 = nums1[mid1 - 1];
            if (mid2 - 1 > -1) l2 = nums2[mid2 - 1];
            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 0)
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2);
                return Math.max(l1, l2);
            }
            if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return -1;
    }
}
