package org.example.arrays;


//TC: O(N)
//SC: O(1)
//Problem link: https://leetcode.com/problems/find-the-duplicate-number/description/
//Level: Medium
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // by modifying input
        for(int i = 0; i < nums.length; i ++){
            if(nums[Math.abs(nums[i])-1] < 0){
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
        }
        return -1;
        // return Arrays.stream(nums).sum()-IntStream.rangeClosed(1, nums.length-1).sum();
    }
}
