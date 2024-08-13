package org.example.arrays;

//TC: O(N)
//SC: O(1)
//Problem link: https://leetcode.com/problems/majority-element/
//Level: Easy
public class MajorityElementMoreThanHalf {
    // Moore's voting algo
//    it states that count must stay positive if majority element is there in the array
    public int majorityElement(int[] nums) {
        int ele = -1, f = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
//            if freq becomes zero then make element as incoming element
//            because prev element may not be majority ele
            if (f == 0) {
                f = 1;
                ele = nums[i];
            }
//            if current ele not equal to ele, then reduce freq
            else if (nums[i] != ele) {
                f--;
            }
//            if current equal to ele, then increase freq
            else {
                f++;
            }
        }
        // below block only if problem statement doesn't guarantee if element exists
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (ele == nums[i])
                cnt++;
        }
        if (cnt > n / 2)
            return ele;
        return -1;
    }
}
