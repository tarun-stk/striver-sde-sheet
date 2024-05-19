package org.example.string;

//TC: O(max(m+n))
//SC: O(n+m)
//Problem link: https://leetcode.com/problems/compare-version-numbers/
// Level: Medium
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int m = v1.length, n = v2.length, i = 0;
        while(i < (m < n? m: n)){
            int j = 0, k = 0;
            int m1 = v1[i].length(), n1 = v2[i].length();
            while(j < m1 && v1[i].charAt(j) == '0'){
                j ++;
            }
            while(k < n1 && v2[i].charAt(k) == '0'){
                k ++;
            }
            while(j < m1 && k < n1 &&  v1[i].charAt(j) == v2[i].charAt(k)){
                j ++;
                k ++;
            }
            if(j < m1 && k < n1){
                if(m1 > n1){
                    return 1;
                }
                else if(m1 < n1){
                    return -1;
                }
                if(v1[i].charAt(j) > v2[i].charAt(k)){
                    return 1;
                }
                else if(v1[i].charAt(j) < v2[i].charAt(k)){
                    return -1;
                }
            }
            if(j < m1){
                return 1;
            }
            if(k < n1){
                return -1;
            }
            i ++;
        }
        while(i < m){
            int j = 0;
            while(j < v1[i].length()){
                if(v1[i].charAt(j) != '0'){
                    return 1;
                }
                j ++;
            }
            i ++;
        }
        while(i < n){
            int j = 0;
            while(j < v2[i].length()){
                if(v2[i].charAt(j) != '0'){
                    return -1;
                }
                j ++;
            }
            i ++;
        }
        return 0;
    }
}
