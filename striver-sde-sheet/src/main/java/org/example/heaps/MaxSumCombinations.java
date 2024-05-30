package org.example.heaps;

import java.util.*;

//TC: O(nlogn)
//SC: O(n)
//Problem link: https://www.geeksforgeeks.org/problems/maximum-sum-combination/1
// Level: Medium
public class MaxSumCombinations {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        Arrays.sort(A);
        Arrays.sort(B);
        List<Integer> ans = new LinkedList<>();
        Set<String> set = new HashSet<>();
        PriorityQueue<int[]> pq  = new PriorityQueue<int[]>((a, b) -> b[0]-a[0]);
        int n = N, c = 0;
        pq.add(new int[]{A[n-1]+B[n-1], n-1, n-1});
        set.add((n-1) + " " + (n-1));
        while(c < K){
            int[] poll = pq.remove();
            ans.add(poll[0]);
            int i = poll[1], j = poll[2];
            if(i != 0){
                if(!set.contains(i-1 + " " + j)){
                    pq.add(new int[]{A[i-1]+B[j], i-1, j});
                    set.add(i-1 + " " + j);
                }

            }
            if(j != 0){
                if(!set.contains(i + " " + (j-1))){
                    pq.add(new int[]{A[i]+B[j-1], i, j-1});
                    set.add(i + " " + (j-1));
                }
            }
            c ++;
        }
        return ans;

    }
}
