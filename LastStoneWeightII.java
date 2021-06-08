/**
 * LeetCode 1049 Last Stone Weight II
 */
class Solution {
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int sum = Arrays.stream(stones).sum();
        int diff = sum / 2;
        int[][] dp = new int[stones.length + 1][diff + 1];
        for (int i = 1; i <= stones.length; i++) {
            int cur = stones[i - 1];
            for (int j = 0; j <= diff; j++) {
                if (j >= cur) {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - cur] + cur);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return sum - dp[stones.length][diff] - dp[stones.length][diff];
    }
}
