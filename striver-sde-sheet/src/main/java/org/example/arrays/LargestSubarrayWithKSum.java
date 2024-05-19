package org.example.arrays;

import java.util.HashMap;
import java.util.Map;

//TC: O(N)
//SC: O(N)
//Problem link: https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
//Level: Medium
public class LargestSubarrayWithKSum {
    int maxLen(int arr[], int n) {
        // Your code here
        Map<Integer, Integer> map = new HashMap<>();
        int rSum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            rSum += arr[i];
            if (map.containsKey(rSum)) {
                max = Math.max(max, i - map.get(rSum));
                continue;
            }
            if (rSum == 0) {
                max = i + 1;
                continue;
            }
            map.put(rSum, i);

        }
        return max;
    }
}
