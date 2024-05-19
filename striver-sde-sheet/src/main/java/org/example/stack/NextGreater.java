package org.example.stack;

import java.util.Stack;

//Problem link: https://leetcode.com/problems/daily-temperatures/description/
//739. Daily Temperatures
//Level: Medium
public class NextGreater {
    // TC: O(n)
    // SC: O(n)
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[t.length];
        for(int i = t.length-1; i > -1; i --){
            while(!st.isEmpty() && t[i] >= t[st.peek()]){
                st.pop();
            }
            if(st.isEmpty())
                ans[i] = 0;
            else
                ans[i] = st.peek()-i;
            st.push(i);
        }
        return ans;
    }
}
