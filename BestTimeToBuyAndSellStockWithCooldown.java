/**
 * LeetCode 309 Best Time to Buy and Sell Stock with Cooldown
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int [][]dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0],dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1],0 - prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
