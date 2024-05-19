package org.example.string;

import java.util.Arrays;

//Problem link: https://leetcode.com/problems/longest-common-prefix/
//Level: Easy
public class LongestCommonPrefix {
    // TC: O(nlogn)
    // SC: O(1)
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length;
        int i = 0;
        String ans = "";
        while (i < strs[0].length() && i < strs[n - 1].length() && strs[0].charAt(i) == strs[n - 1].charAt(i)) {
            ans += strs[0].charAt(i);
            i++;
        }
        return ans;
    }

    // TC: O(n)
    // SC: O(1)
    public String longestCommonPrefix1(String[] strs) {
        int n = strs.length;
        int min = strs[0].length();
        String ans = strs[0];
        for (int i = 1; i < n; i++) {
            int j = 0;
            while (j < min && j < strs[i].length() && ans.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            if (min > j) {
                ans = ans.substring(0, j);
                min = j;
            }
        }
        return ans;
    }
}
