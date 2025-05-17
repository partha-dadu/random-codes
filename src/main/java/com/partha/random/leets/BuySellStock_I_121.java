package com.partha.random.leets;

public class BuySellStock_I_121 {

    /***
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     * */

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        int i = 0;
        while(i < prices.length){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else{
                int profit = prices[i] - minPrice;
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
            i++;
        }
        return maxProfit;
    }
}
