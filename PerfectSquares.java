/**
 * LeetCode 279 Perfect Squares
 */
class Solution {
    public int numSquares(int n) {
        if (n < 0) {
            return -1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int curMin = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                curMin = Math.min(curMin,dp[i - (j * j)]);
            }
            dp[i] = curMin + 1;
        }
        return dp[n];
    }
}
