package org.example.stack;

import java.util.Stack;

//Problem link: https://leetcode.com/problems/min-stack/
//155. Min Stack
//Level: Medium
class MinStack {

    // TC: O(n) for all functions
    // SC: O(n)

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val)
            minStack.push(val);
    }

    public void pop() {
        int val = stack.pop();
        if(minStack.peek() == val)
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
