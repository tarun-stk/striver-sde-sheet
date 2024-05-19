package org.example.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//TC: O(N), O(nlogn) if using sort
//SC: O(1)
//Problem link: https://leetcode.com/problems/next-permutation/
//Level: Medium
public class NextPermutation {
    // Observations:
    // 1. keep prefix longer, find first break point where array starts increasing
    // 2. swap break point index with just large element on its right
    // 3. put all the remaining elements on right in ascending order

    // TC: O(n)
    // SC: O(1)

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;
        for (int i = n - 2; i > -1; i--) {
            // 1.
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        // it means given array is the greatest, then next permutation will always be first possible perm
        // which is least
        if (ind == -1) {
            Arrays.sort(nums);
            return;
        }

        for (int i = n - 1; i > ind; i--) {
            // 2.
            if (nums[i] > nums[ind]) {
                int t = nums[i];
                nums[i] = nums[ind];
                nums[ind] = t;
                break;
            }
        }

        // 3.
        reverse(nums, ind + 1, n - 1);

    }

    private int[] reverse(int[] nums, int from, int to) {
        Integer[] boxedArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        List<Integer> list = Arrays.asList(Arrays.copyOfRange(boxedArray, from, to + 1));
        Collections.sort(list);
        for (int i = from, j = 0; i < to + 1; i++, j++) {
            nums[i] = list.get(j);
        }
        return nums;
    }
}
