package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

//TC: O(2^t*k)
//SC: O(k*x)
//t -> target, k -> avg length of combination, x -> tot num of combs
//in worst case tar == 10 and element = 1, then pick element target num of times
//Problem link: https://leetcode.com/problems/combination-sum/description/
//Level: Med
public class CombinationSum1 {
    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
