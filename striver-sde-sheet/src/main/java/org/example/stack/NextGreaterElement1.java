package org.example.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//TC: O(n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/next-greater-element-i/
// Level: Easy
public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n2 = nums2.length, n1 = nums1.length;
        int[] ans = new int[n1];
        for (int i = n2 - 1; i > -1; i--) {
            map.put(nums2[i], -1);
            while (!st.isEmpty() && nums2[i] >= st.peek()) {
                st.pop();
            }
            if (!st.isEmpty())
                map.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }

        for (int i = n1 - 1; i > -1; i--) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
