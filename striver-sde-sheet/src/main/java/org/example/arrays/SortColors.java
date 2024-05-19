package org.example.arrays;

//TC: O(N)
//SC: O(1)
//Problem link: https://leetcode.com/problems/sort-colors/
//Level: Medium
public class SortColors {
    public void sortColors(int[] nums) {
        int z = 0, o = 0, t = nums.length-1;
        while(o <= t){
            if(nums[o] == 0){
                nums[o] = nums[z];
                nums[z] = 0;
                o ++;
                z ++;
            }
            else if(nums[o] == 1){
                o ++;
            }
            else{
                nums[o] = nums[t];
                nums[t] = 2;
                t --;
            }
        }
    }
}
