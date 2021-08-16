/**
 * LeetCode 526 Beautiful Arrangement
 */
class Solution {
    public int countArrangement(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for (int mask = 1;mask < (1 << n);mask++) {
            int num = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && ((num % (i + 1) == 0) || (i + 1) % num == 0)) {
                    dp[mask] += dp[mask ^ (1 << i)];
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
