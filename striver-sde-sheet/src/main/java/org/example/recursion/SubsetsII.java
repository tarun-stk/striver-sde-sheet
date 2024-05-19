package org.example.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//TC: O(2^N)
//SC: O(N*2^N)
//Problem link: https://leetcode.com/problems/subsets-ii/description/
//Level: Medium
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList();
        Arrays.sort(nums);
        solve(0, nums.length, nums, ans, new LinkedList<>());
        return ans;
    }

    private void solve(int i, int n, int[] nums, List<List<Integer>> ans, List<Integer> list) {
        ans.add(new LinkedList<>(list));
        for (int j = i; j < n; j++) {
            if (j > i && nums[j] == nums[j - 1])
                continue;
            list.add(nums[j]);
            solve(j + 1, n, nums, ans, list);
            list.remove(list.size() - 1);
        }
    }
}
