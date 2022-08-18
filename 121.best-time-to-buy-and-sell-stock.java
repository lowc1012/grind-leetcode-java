/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int minBuyingPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i]-minBuyingPrice);
            minBuyingPrice = Math.min(minBuyingPrice, prices[i]);
        }
        return profit;
    }
}
// @lc code=end

