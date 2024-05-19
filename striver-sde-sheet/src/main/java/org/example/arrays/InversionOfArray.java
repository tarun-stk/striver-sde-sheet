package org.example.arrays;

//TC: O(NlogN)
//SC: O(NlogN)
//Problem link: https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
//Level: Medium
public class InversionOfArray {
    static long inversionCount(long arr[], long N) {
        long[] ans = new long[1];
        long i = 0, j = N - 1;
        mergeSort(i, j, arr, ans);
        return ans[0];
    }

    private static long[] mergeSort(long i, long j, long[] arr, long[] ans) {
        if (i == j) {
            return new long[]{arr[(int) i]};
        }
        long mid = (j + i) / 2;
        long[] left = mergeSort(i, mid, arr, ans);
        long[] right = mergeSort(mid + 1, j, arr, ans);
        for (long k = 0; k < left.length; k++) {
            long ind = find(left[(int) k], right);
            ans[0] += ind;
        }
        long k = 0, n = left.length + right.length;
        long[] a = new long[(int) n];
        long l = 0, r = 0;
        for (; l < left.length && r < right.length; ) {
            if (left[(int) l] < right[(int) r]) {
                a[(int) k] = left[(int) l++];
            } else {
                a[(int) k] = right[(int) r++];
            }
            k++;
        }
        while (l < left.length) {
            a[(int) k++] = left[(int) l++];
        }
        while (r < right.length) {
            a[(int) k++] = right[(int) r++];
        }
        return a;
    }

    private static long find(long e, long[] arr) {
        long l = 0, h = arr.length - 1;
        while (l <= h) {
            long mid = h - (h - l) / 2;
            if (arr[(int) mid] >= e) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
