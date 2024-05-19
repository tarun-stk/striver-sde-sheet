package org.example.string;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

//TC: O(k)
//SC: O(k)
//Problem link: https://leetcode.com/problems/integer-to-roman/
//Level: Easy
public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder()) {{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};

        for (int k : map.keySet()) {
            ans.append(map.get(k).repeat(num / k));
            num %= k;
        }
        return ans.toString();
    }
}
