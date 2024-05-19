package org.example.dp;

//TC: O(n*n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/target-sum/
// Level: Medium
public class MaxSum {
    public int maxSumIS(int arr[], int n) {
        //code here.
        int[] max = new int[n];
        int m = 0;
        max[0] = Math.max(0, arr[0]);
        for (int i = 0; i < n; i++) {
            max[i] = Math.max(0, arr[i]);
            for (int j = i - 1; j > -1; j--) {
                if (arr[j] < arr[i]) {
                    max[i] = Math.max(max[i], arr[i] + max[j]);

                }
            }
            m = Math.max(m, max[i]);
        }
        return m;
    }
}
