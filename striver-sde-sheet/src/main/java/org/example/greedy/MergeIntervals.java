package org.example.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC: O(N)
//SC: O(N)
//Problem link: https://leetcode.com/problems/merge-intervals/
//Level: Medium
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int sv = intervals[0][0], ev = intervals[0][1];
        for(int i = 1; i < n; i ++){
            if(ev >= intervals[i][0]){
                ev = Math.max(ev, intervals[i][1]);
                continue;
            }
            list.add(new int[]{sv, ev});
            sv = intervals[i][0];
            ev = intervals[i][1];
        }
        list.add(new int[]{sv, ev});
        return list.stream().toArray(int[][]::new);
    }
}
