package org.example.string;

//Time Complexity: O(n*n)
//Space Complexity: O(1)
//Problem link: https://leetcode.com/problems/longest-palindromic-substring/
//Level: Medium
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int max = 0;
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l > -1 && r < n && s.charAt(l) == s.charAt(r)) {
                if (max < r - l + 1) {
                    max = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l > -1 && r < n && s.charAt(l) == s.charAt(r)) {
                if (max < r - l + 1) {
                    max = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}
