package org.example.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

//TC: O(NlogN) -> find lenght + O(N) -> actual logic
//SC: O(2*N) -> ard arr + O(N) -> pq
//Problem link: https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
//Level: Hard
public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        int[][] ard = new int[n][2];
        for (int i = 0; i < n; i++) {
            ard[i][0] = arr[i];
            ard[i][1] = dep[i];
        }
        Arrays.sort(ard, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty()) {
                if (pq.peek() < ard[i][0]) {
                    pq.remove();
                }

            }
            pq.add(ard[i][1]);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}
