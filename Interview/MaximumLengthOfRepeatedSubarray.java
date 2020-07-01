/**
 * LeetCode 718 Maximum Length of Repeated Subarray
 */
class Solution {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
