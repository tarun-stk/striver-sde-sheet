package org.example.binarysearch;

import java.util.Arrays;

//TC: O(NlogN) + O(N * log(max(stalls[])-min(stalls[])))
//O(NlogN) -> sorting
//O(N * log(max(stalls[])-min(stalls[]))) -> looping thru out the array for every possible dist
//SC: O(1) -> total number of chars stored in Trie
//Problem link: https://www.naukri.com/code360/problems/aggressive-cows_1082559
//Level: Medium
public class AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int n = stalls.length;
        int l = 0, h = stalls[n - 1] - stalls[0];
        while (l <= h) {
            int mid = h - (h - l) / 2;
            if (canPlace(mid, stalls, k)) {
                // ans = l;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l - 1 < 0 ? 0 : l - 1;
    }

    private static boolean canPlace(int dist, int[] stalls, int k) {
        int p = 0, c = 1;
        for (int i = 1; i < stalls.length && c < k; i++) {
            if (stalls[i] - stalls[p] >= dist) {
                p = i;
                c++;
            }
        }
        return c >= k;
    }
}
