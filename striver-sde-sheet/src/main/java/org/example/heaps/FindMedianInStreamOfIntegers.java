package org.example.heaps;

import java.util.PriorityQueue;

//Time Complexity: O(logn)
//Space Complexity: O(n)
//Problem link: https://leetcode.com/problems/find-median-from-data-stream/
//Level: Hard
public class FindMedianInStreamOfIntegers {
    int countOnLeft, countOnRight;
    PriorityQueue<Integer> left, right;

    public FindMedianInStreamOfIntegers() {
        countOnLeft = 0;
        countOnRight = 0;
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (countOnLeft == 0 && countOnRight == 0) {
            countOnLeft++;
            left.add(num);
            return;
        } else if (countOnRight > countOnLeft) {
            if (num > right.peek()) {
                left.add(right.remove());
                right.add(num);
            } else {
                left.add(num);
            }
            countOnLeft++;
        } else if (countOnLeft > countOnRight) {
            if (num < left.peek()) {
                right.add(left.remove());
                left.add(num);
            } else {
                right.add(num);
            }
            countOnRight++;
        } else if (countOnLeft == countOnRight) {
            if (num < left.peek()) {
                left.add(num);
                countOnLeft++;
            } else {
                right.add(num);
                countOnRight++;
            }
        }
    }

    public double findMedian() {
        if (countOnLeft == countOnRight) {
            return ((double) (left.peek()) + right.peek()) / 2;
        }
        return countOnRight > countOnLeft ? right.peek() : left.peek();
    }
}
