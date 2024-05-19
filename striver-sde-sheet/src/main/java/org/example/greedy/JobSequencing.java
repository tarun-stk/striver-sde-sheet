package org.example.greedy;

import java.util.Arrays;

//TC: O(NlogN) + O(M*N)
//SC: O(N)
//Problem link: https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
//Level: Medium
public class JobSequencing {

    private class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        int max = 0;
        for (Job j : arr) {
            max = Math.max(max, j.deadline);
        }
        int[] jobs = new int[max + 1];
        Arrays.fill(jobs, -1);
        int njobs = 0, ans = 0;
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);  //O(NlogN)
//        O(N*M)
//        N -> size of jobs array
//        M -> internally we travel from given job to index 1 ~ M
        for (Job j : arr) {
            int dead = j.deadline;
            while (dead > 1 && jobs[dead] != -1) {
                dead--;
            }
            if (dead >= 1 && jobs[dead] == -1) {
                jobs[dead] = j.id;
                ans += j.profit;
                njobs++;
            }
        }

        return new int[]{njobs, ans};
    }
}
