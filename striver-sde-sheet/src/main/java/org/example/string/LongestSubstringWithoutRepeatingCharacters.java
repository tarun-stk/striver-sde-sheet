package org.example.string;

import java.util.HashSet;
import java.util.Set;

//TC: O(N)
//SC: O(N)
//Problem link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
//Level: Medium
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int st = 0, e = 0, n = s.length(), max = 0;
        for (; e < n; e++) {
            while (set.contains(s.charAt(e))) {
                set.remove(s.charAt(st));
                st++;
            }
            set.add(s.charAt(e));
            max = Math.max(max, e - st + 1);
        }
        return max;
    }
}
