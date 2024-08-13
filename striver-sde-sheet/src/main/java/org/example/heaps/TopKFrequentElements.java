package org.example.heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TC: O(n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/top-k-frequent-elements/
// Level: Medium
public class TopKFrequentElements {

//    BUCKET SORT
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length, l = 0;
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[n + 1];
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            bucket[i] = new ArrayList<>();
        }
        bucket[n] = new ArrayList<>();
        for (int ke : map.keySet()) {
            bucket[map.get(ke)].add(ke);
        }

        for (int i = n; i > -1 && k > 0; i--) {
            for (int j : bucket[i]) {
                ans[l++] = j;
                k--;
                if (k == 0)
                    break;
            }
        }

        return ans;

    }
}
