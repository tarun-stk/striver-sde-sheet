package org.example.arrays;

import java.util.LinkedList;
import java.util.List;

//TC: O(N*(sum of N numbers))
//SC: O(N*(sum of N numbers))
//Problem link: https://leetcode.com/problems/pascals-triangle/description/
//Level: Medium
public class PascalsTriangle {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = 0; i < n; i ++){
            List<Integer> list = new LinkedList<>();
            list.add(1);
            if(i == 0){
                ans.add(list);
                continue;
            }
            for(int j = 1; j < i; j ++){
                list.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}
