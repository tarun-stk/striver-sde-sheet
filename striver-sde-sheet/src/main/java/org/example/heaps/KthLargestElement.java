package org.example.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

//TC: O(nlogn)
//SC: O(n)
//Problem link: https://leetcode.com/problems/kth-largest-element-in-an-array/
// Level: Medium
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : nums) {
            pq.add(i);
        }
        while (k > 1 && !pq.isEmpty()) {
            pq.remove();
            k--;
        }
        return !pq.isEmpty() ? pq.peek() : -1;
    }
}
