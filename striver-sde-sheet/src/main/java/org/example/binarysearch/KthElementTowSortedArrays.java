package org.example.binarysearch;

//TC: O(log(m+n))
//SC: O(1)
//Problem link: https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
//Level: Medium
public class KthElementTowSortedArrays {
    public long kthElement(int nums1[], int nums2[], int n1, int n2, int k) {
        // Approach from TUF.
        int n = n1 + n2;
        if (n1 > n2)
            return kthElement(nums2, nums1, n2, n1, k);
        int low = Math.max(0, k - n2);
        int high = Math.min(n1, k);
        // int left = k;
        while (low <= high) {
            int mid1 = high - (high - low) / 2;
            int mid2 = k - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 - 1 > -1) l1 = nums1[mid1 - 1];
            if (mid2 - 1 > -1) l2 = nums2[mid2 - 1];
            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (l1 <= r2 && l2 <= r1) {
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
