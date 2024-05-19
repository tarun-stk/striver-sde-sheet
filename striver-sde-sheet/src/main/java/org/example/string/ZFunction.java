package org.example.string;

//TC: O(N1*N2)
//SC: O(1)
//Problem link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
//Level: Easy
public class ZFunction {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int n1 = haystack.length(), n2 = needle.length();
        for (; i < n1; i++) {
            int temp = i;
            while (i < n1 && j < n2 && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == n2)
                return temp;
            j = 0;
            i = temp;
        }
        return -1;
    }
}
