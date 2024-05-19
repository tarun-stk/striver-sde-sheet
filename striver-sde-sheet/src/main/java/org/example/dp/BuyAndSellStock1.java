package org.example.dp;

//TC: O(N)
//SC: O(1)
//Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//Level: Easy
public class BuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int ans = 0;
        for(int i = n-1; i > -1; i --){
            ans = Math.max(ans, max-prices[i]);
            max = Math.max(max, prices[i]);
        }
        return ans;
    }
}
