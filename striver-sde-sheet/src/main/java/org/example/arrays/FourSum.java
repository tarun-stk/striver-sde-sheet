package org.example.arrays;

import java.util.*;

//https://leetcode.com/problems/4sum/
public class FourSum {
    // TC: O(nlogn) + O(n^3)
    // SC: O(quads) + O(quads)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int k = j + 1, l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
                    if (sum > (long) target) {
                        l--;
                    } else if (sum < (long) target) {
                        k++;
                    } else {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // TC: O(nlogn) + O(n^3)
    // SC: O(quads)
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> set = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j - 1 > i && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1, l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
                    if (sum > (long) target) {
                        l--;
                    } else if (sum < (long) target) {
                        k++;
                    } else {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && l < n - 1 && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }

                }
            }
        }
        return set;
    }
}
