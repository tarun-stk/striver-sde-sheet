package org.example.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//TC: O(2^n*k)
//SC: O(N) + O(size of ans)
//Problem link: https://leetcode.com/problems/combination-sum-ii/
//Level: Medium
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(candidates);
        solve(0, candidates.length, candidates, target, ans, new LinkedList<>());
        return ans;
    }

    private void solve(int i, int n, int[] c, int t, List<List<Integer>> ans, List<Integer> list) {

        if (t == 0) {
            ans.add(new LinkedList<>(list));
            return;
        }
        if (i == n)
            return;
        for (int j = i; j < n; j++) {
            if (j > i && c[j] == c[j - 1]) {
                continue;
            }
            if (t >= c
                    [j]) {
                list.add(c[j]);
                solve(j + 1, n, c, t - c[j], ans, list);
                list.remove(list.size() - 1);
            }

        }
    }
}
