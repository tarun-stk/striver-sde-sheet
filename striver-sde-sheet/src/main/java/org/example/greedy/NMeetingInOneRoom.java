package org.example.greedy;

import java.util.Arrays;

//TC: O(nlogn)
//SC: O(n)
//Problem link: https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
//Level: Easy
public class NMeetingInOneRoom {
    public int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int[][] meet = new int[n][2];
        int ans = 0, currEnd = -1;
        for(int i = 0; i < n; i ++){
            meet[i][0] = start[i];
            meet[i][1] = end[i];
        }
        Arrays.sort(meet, (a, b)->a[1]-b[1]);
        for(int i = 0; i < n; i ++){
            if(currEnd < meet[i][0]){
                ans ++;
                currEnd = meet[i][1];
            }
        }
        return ans;
    }
}
