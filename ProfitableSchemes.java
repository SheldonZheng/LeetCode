/**
 * LeetCode 879 Profitable Schemes
 */
class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        if (group == null || group.length == 0 || profit == null || profit.length == 0) {
            return 0;
        }
        int mod = (int) 1e9 + 7;
        int[][][] dp = new int[group.length + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= group.length; i++) {
            int curCount = group[i - 1];
            int curProfit = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j < curCount) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - curCount][Math.max(0,k - curProfit)]) % mod;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res = (res + dp[group.length][i][minProfit]) % mod;
        }
        return res;
    }
}
