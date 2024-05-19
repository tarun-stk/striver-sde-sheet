package org.example.queue;

import java.util.ArrayDeque;
import java.util.Deque;

//TC: O(n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/sliding-window-maximum/
// Level: Hard
public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deck = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int i = 0, j = 0, l = 0;
        for (; j < n; j++) {
            if (j < k - 1) {
                refresh(j, nums, deck);
                continue;
            }
            refresh(j, nums, deck);
            ans[l] = nums[deck.peekFirst()];
            if (deck.peek() == i) {
                deck.removeFirst();
            }
            i++;
            l++;
        }
        return ans;
    }

    private void refresh(int i, int[] nums, Deque<Integer> deck) {
        while (!deck.isEmpty() && nums[i] >= nums[deck.peekLast()]) {
            deck.removeLast();
        }
        deck.addLast(i);
    }
}
