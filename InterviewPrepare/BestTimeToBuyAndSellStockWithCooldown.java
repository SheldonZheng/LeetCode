/**
 * LeetCode 309 Best Time to Buy and Sell Stock with Cooldown
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0; // not cooldown
        dp[0][1] = 0; // cooldown
        dp[0][2] = 0 - prices[0]; //  have 1 stock
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
            dp[i][1] = dp[i - 1][2] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2],dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[prices.length - 1][0],dp[prices.length - 1][1]);
    }
}
