/**
 * LeetCode 516 Longest Palindromic Subsequence
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        char[] cs = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                    int r = l + len - 1;
                    if (len == 1) {
                        dp[l][r] = 1;
                    } else if (len == 2) {
                        dp[l][r] = cs[l] == cs[r] ? 2 : 1;
                    } else {
                        dp[l][r] = Math.max(dp[l + 1][r],dp[l][r - 1]);
                        dp[l][r] = Math.max(dp[l][r],dp[l + 1][r - 1] + (cs[l] == cs[r] ? 2 : 0));
                    }
            }
        }
        return dp[0][n - 1];
    }
}
