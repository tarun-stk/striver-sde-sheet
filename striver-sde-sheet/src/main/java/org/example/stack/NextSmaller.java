package org.example.stack;

import java.util.ArrayList;
import java.util.Stack;

//TC: O(n)
//SC: O(n)
//Problem link: https://www.interviewbit.com/problems/nearest-smaller-element/
//Level: Medium
public class NextSmaller {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            while (!st.isEmpty() && st.peek() >= A.get(i)) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(st.peek());
            }
            st.push(A.get(i));
        }
        return ans;
    }
}
