package org.example.heaps;

import java.util.ArrayList;

//Time Complexity: O(tot elements)
//Space Complexity: O(tot elements)
//Problem link: https://www.naukri.com/code360/problems/merge-k-sorted-arrays_975379
//Level: Medium
public class MergeKSortedLists {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<Integer>();
        return solve(0, k, kArrays);
    }

    private static ArrayList<Integer> solve(int l, int k, ArrayList<ArrayList<Integer>> kArrays) {
        if (l == k - 1) {
            return kArrays.get(l);
        }
        ArrayList<Integer> list2 = solve(l + 1, k, kArrays), list1 = kArrays.get(l), ans = new ArrayList<Integer>();
        int i = 0, j = 0;
        int m = list1.size(), n = list2.size();
        while (i < m && j < n) {
            if (list1.get(i) < list2.get(j)) {
                ans.add(list1.get(i));
                i++;
            } else {
                ans.add(list2.get(j));
                j++;
            }
        }
        while (i < m) {
            ans.add(list1.get(i));
            i++;
        }
        while (j < n) {
            ans.add(list2.get(j));
            j++;
        }
        return ans;
    }
}
