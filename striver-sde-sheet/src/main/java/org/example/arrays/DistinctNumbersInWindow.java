package org.example.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TC: O(n)
//SC: O(n)
//Problem link: https://www.interviewbit.com/problems/distinct-numbers-in-window/
// Level: Medium
public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        int s = 0, e = 0, count = 0;
        Map<Integer, Integer> map = new HashMap();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (e < B && e < n) {
            map.put(A.get(e), map.getOrDefault(A.get(e), 0) + 1);
            if (map.get(A.get(e)) == 1) {
                count++;
            }
            e++;
        }
        if (B <= n) ans.add(count);
        while (e < n) {
            map.put(A.get(e), map.getOrDefault(A.get(e), 0) + 1);
            if (map.get(A.get(e)) == 1) {
                count++;
            }
            map.put(A.get(s), map.get(A.get(s)) - 1);
            if (map.get(A.get(s)) == 0) {
                count--;
            }
            ans.add(count);
            e++;
            s++;
        }
        return ans;

    }
}
