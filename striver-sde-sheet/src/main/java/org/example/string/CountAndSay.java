package org.example.string;

//We make n recursive calls, and in each substantial call, string length
//is increasing by almost 2x, -> exponential
//TC: O(2^N) -> exponential
//SC: O(2^N) -> exponential
//Problem link: https://leetcode.com/problems/count-and-say/
//Level: Medium
public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String str = countAndSay(n-1);
        String ans = "";
        int count = 1, len = str.length();
        for(int i = 1; i < str.length(); i ++){
            if(str.charAt(i) != str.charAt(i-1)){
                ans += count+""+str.charAt(i-1);
                count = 1;
                continue;
            }
            count ++;
        }
        ans += count+""+str.charAt(len-1);
        return ans;
    }
}
