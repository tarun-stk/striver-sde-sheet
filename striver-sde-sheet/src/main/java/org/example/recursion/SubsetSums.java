package org.example.recursion;

import java.util.ArrayList;

//Problem link: https://www.geeksforgeeks.org/problems/subset-sums2234/1
//Subset Sums
//Level: Medium
public class SubsetSums {

//    TC: O(2^n)
//    SC: output list -> O(2^n) + stack space -> O(n)
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        rec(0, n, list, arr, 0);
        return list;
    }
    private void rec(int i, int n, ArrayList<Integer> list, ArrayList<Integer> arr, int sum){
        if(i == n){
            list.add(sum);
            return;
        }
//        pick
        rec(i+1, n, list, arr, sum+arr.get(i));
//        nonpick
        rec(i+1, n, list, arr, sum);

    }
}
