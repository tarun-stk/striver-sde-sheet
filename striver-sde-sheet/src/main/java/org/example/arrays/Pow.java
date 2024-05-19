package org.example.arrays;

//TC: O(logN)
//SC: O(logN) -> stack space
//Problem link: https://leetcode.com/problems/powx-n/
//Level: Medium
public class Pow {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE){
            return (1.0/x)*(1/pow(x, Integer.MAX_VALUE));
        }
        double ans = pow(x, Math.abs(n));
        if(n < 0)
            return 1/ans;
        return ans;

    }
    private double pow(double x, int n){
        if(n == 0)
            return 1;
        if(n%2 == 0){
            return pow(x*x, n/2);
        }
        else{
            return x*pow(x, n-1);
        }
    }
}
