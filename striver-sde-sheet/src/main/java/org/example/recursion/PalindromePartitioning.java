package org.example.recursion;

import java.util.LinkedList;
import java.util.List;

//Time Complexity: O(n*2^n)
//Space Complexity: O(n*2^n)
//Problem link: https://leetcode.com/problems/palindrome-partitioning/description/
//Level: Medium
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new LinkedList<>();
        solve(0, n, s, ans, new LinkedList<>());
        return ans;
    }
    private void solve(int i, int n, String s, List<List<String>> ans, List<String> list){
        if(i == n){
            ans.add(new LinkedList(list));
            return;
        }
        for(int j = i; j < n; j ++){
            if(isPalindrome(s.substring(i, j+1))){
                list.add(s.substring(i, j+1));
                solve(j+1, n, s, ans, list);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){

        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
