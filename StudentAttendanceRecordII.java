/**
 * LeetCode 552 Student Attendance Record II
 */
class Solution {
    public int checkRecord(int n) {
        final int MOD_NUM = (int) (1e9 + 7);
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {

            //end with P
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD_NUM;
                }
            }

            //end with A
            for (int k = 0; k <= 2; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD_NUM;
            }

            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD_NUM;
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= 1; i++) {
            for (int k = 0; k <= 2; k++) {
                res = (res + dp[n][i][k]) % MOD_NUM;
            }
        }
        return res;
    }
}
