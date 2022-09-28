/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // The first thing I want to do is clarifying the
        // question.

        // 1. only hold at most one share of the stock at any time
        // 2. buy it then immediately sell it on the same day
        
        // Find consecutive valleys and peaks
        // Time complexity: O(n)
        int result = 0, i = 0;
        int valley = prices[0], peak = prices[0];

        while (i < prices.length-1) {
            // find the valley
            while (i < prices.length-1 && prices[i] >= prices[i+1]) {
                i++;
            }
            valley = prices[i];

            // find the peak
            while (i < prices.length-1 && prices[i] <= prices[i+1]) {
                i++;
            }
            peak = prices[i];

            // sum up the differences between peaks and valleys
            result += peak - valley;
        }

        return result;
    }
}
// @lc code=end

