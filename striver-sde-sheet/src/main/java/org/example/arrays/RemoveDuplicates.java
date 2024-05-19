package org.example.arrays;

//TC: O(N)
//SC: O(1)
//Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//Level: Easy
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        while(i < n){
            while(i+1 < n && nums[i] == nums[i+1])
                i ++;
            nums[j] = nums[i];
            j ++;
            i ++;
        }
        return j;
    }
}
