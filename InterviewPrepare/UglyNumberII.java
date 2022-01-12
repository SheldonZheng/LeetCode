/**
 * LeetCode Ugly Number II
 */
class Solution {
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1,p3 = 1,p5 = 1;
        for (int i = 2; i <= n; i++) {
            int next2 = dp[p2] * 2,next3 = dp[p3] * 3,next5 = dp[p5] * 5;
            dp[i] = Math.min(next2,Math.min(next3,next5));
            if (dp[i] == next2) {
                p2++;
            }
            if (dp[i] == next3) {
                p3++;
            }
            if (dp[i] == next5) {
                p5++;
            }
        }
        return dp[n];
    }
}
