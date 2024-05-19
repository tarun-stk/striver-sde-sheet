package org.example.string;

import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n)
//n -> length of string, m -> words in a string
//Space Complexity: O(n+m)
//Problem link: https://leetcode.com/problems/reverse-words-in-a-string/
//Level: Medium
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (word.length() > 0) {
                    list.add(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(s.charAt(i));
            }
        }
        if (word.length() > 0) {
            list.add(word.toString());
            word.setLength(0);
        }
        for (int i = list.size() - 1; i > -1; i--) {
            sb.append(list.get(i) + " ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
