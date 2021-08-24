/**
 * LeetCode 787 Cheapest Flights Within K Stops
 */
class Solution {
    public int findCheapestPrice(int n,int[][] flights,int src,int dst,int k) {
        if (flights == null || flights.length == 0) {
            return 0;
        }
        final int MAX = Integer.MAX_VALUE - 100000;
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dp[i],MAX);
        }
        dp[0][src] = 0;
        for (int t = 1; t <= k + 1; t++) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1],cost = flight[2];
                dp[t][i] = Math.min(dp[t][i],dp[t - 1][j] + cost);
            }
        }
        int res = MAX;
        for (int t = 1; t <= k + 1; t++) {
            res = Math.min(res,dp[t][dst]);
        }
        return res == MAX ? -1 : res;
    }
}
