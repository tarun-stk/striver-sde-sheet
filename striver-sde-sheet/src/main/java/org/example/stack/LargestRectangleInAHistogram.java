package org.example.stack;

import java.util.Stack;


//TC: O(n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/largest-rectangle-in-histogram/
// Level: Hard
public class LargestRectangleInAHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, ans = -1;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int[] pre = new int[n], post = new int[n];
        for(int i = 0; i < n; i ++){
            while(!st1.isEmpty() && heights[st1.peek()] >= heights[i]){
                st1.pop();
            }
            while(!st2.isEmpty() && heights[st2.peek()] >= heights[n-i-1]){
                st2.pop();
            }
            if(!st1.isEmpty()){
                pre[i] = st1.peek();
            }
            else{
                pre[i] = -1;
            }
            if(!st2.isEmpty()){
                post[n-i-1] = st2.peek();
            }
            else{
                post[n-i-1] = n;
            }
            st1.push(i);
            st2.push(n-i-1);
        }
        for(int i = 0; i < n; i ++){
            int temp = (post[i]-pre[i]-1)*heights[i];
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
