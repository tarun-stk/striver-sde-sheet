package org.example.arrays;

import java.util.Arrays;

//TC: O(N*M)
//SC: O(2*n)
//Problem link: https://leetcode.com/problems/unique-paths/
//Level: Medium
public class GridUniquePaths {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 1);
        for(int i = m-2; i > -1; i --){
            int[] curr = new int[n];
            for(int j = n-1; j > -1; j --){
                // right
                if(j < n-1){
                    curr[j] += curr[j+1];
                }
                // down
                curr[j] += prev[j];
            }
            prev = curr;
        }
        return prev[0];
    }
}
