package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

//TC: O(N!)
//SC: O(N!N^2)
//The ans list stores all the valid configurations. In the worst case, there can be N! valid configurations,
//each containing N strings of length N (representing the rows of the chessboard). So, the space
//required for storing ans is O(N! * N^2).
//The list list stores the current configuration of the chessboard, which can have at most N elements.
//The sb StringBuilder is used to construct each row of the chessboard. It requires O(N) space.
//Additionally, there's space required for the recursive call stack. Since the maximum depth of
//recursion is N (equal to the number of rows in the chessboard), the space required for the call
//stack is O(N).
//Therefore, the overall space complexity is O(N! * N^2) in the worst case.
//Problem link: https://leetcode.com/problems/n-queens/
//Level: Hard
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        solve(0, n, ans, new ArrayList<>());
        return ans;
    }

    private void solve(int i, int n, List<List<String>> ans, List<String> list) {
        if (i == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        StringBuilder sb = new StringBuilder("");
        for (int j = 0; j < n; j++) {
            sb.append(".");
        }
        for (int j = 0; j < n; j++) {
            if (check(i - 1, j, n, list)) {
                sb.setCharAt(j, 'Q');
                list.add(sb.toString());
                solve(i + 1, n, ans, list);
                list.remove(list.size() - 1);
                sb.setCharAt(j, '.');
            }

        }
    }

    private boolean check(int i, int j, int n, List<String> ans) {
        int r = i, c = j;
        while (r > -1) {
            if (ans.get(r).charAt(c) == 'Q')
                return false;
            r--;
        }
        r = i;
        c = j - 1;
        while (r > -1 && c > -1) {
            if (ans.get(r).charAt(c) == 'Q')
                return false;
            r--;
            c--;
        }
        r = i;
        c = j + 1;
        while (r > -1 && c < n) {
            if (ans.get(r).charAt(c) == 'Q')
                return false;
            r--;
            c++;
        }
        return true;
    }
}
