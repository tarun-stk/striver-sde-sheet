package org.example.stack;

import java.util.Stack;

//TC: O(1)
//SC: O(n)
//Problem link: https://leetcode.com/problems/online-stock-span/
// Level: Medium
public class OnlineStockSpan {
    Stack<int[]> st;

    public OnlineStockSpan() {
        st = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            count += st.peek()[1];
            st.pop();
        }
        st.push(new int[]{price, count});
        return count;
    }
}
