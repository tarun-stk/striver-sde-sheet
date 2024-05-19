package org.example.arrays;

import java.util.HashMap;
import java.util.Map;

//TC: O(N)
//SC: O(N)
//Problem link: https://leetcode.com/problems/longest-consecutive-sequence/
//Level: Easy
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i : nums) {
            if (!map.containsKey(i)) {
                int left = map.containsKey(i - 1) ? map.get(i - 1) : 0;
                int right = map.containsKey(i + 1) ? map.get(i + 1) : 0;
                int sum = left + right + 1;
                map.put(i, sum);
                // update left boundary
                map.put(i - left, sum);
                // update right boundary
                map.put(i + right, sum);
                // update max
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
