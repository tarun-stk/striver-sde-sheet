package org.example.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//TC: O(N!)
//SC: O(N*N) -> O(N) for rec stack space, O(N) -> for list holding values at any point of time
//it always has less than or equal to N elements
//Problem link: https://leetcode.com/problems/permutations/
//Level: Easy
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        rec(0, nums.length, nums, ans, new ArrayList<>());
        return ans;
    }
    private void rec(int i, int n, int[] nums, List<List<Integer>> ans, List<Integer> set){
        if(i == n){
            // System.out.println("i: 3" + " set: " + set);
            ans.add(new LinkedList<>(set));
            return;
        }
        for(int j = 0; j < n; j ++){
            if(!set.contains(nums[j])){
                set.add(nums[j]);
                rec(i+1, n, nums, ans, set);
                set.remove(set.size()-1);
            }
            // System.out.println("i: " + i + " j: " + j + " set: " + set);
        }
    }
}
