package org.example.arrays;

import java.util.HashMap;
import java.util.Map;

//Time Complexity: O(n)
//Space Complexity: O(n)
//Problem link: https://leetcode.com/problems/two-sum/description/
//Level: Easy
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(map.containsKey(target-nums[i]))
                return new int[]{i, map.get(target-nums[i])};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
