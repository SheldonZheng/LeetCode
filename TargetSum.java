/**
 * LeetCode 494 Target Sum
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[][] dp = new int[nums.length + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            int cur = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                if (j >= cur) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - cur];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][neg];
    }
}
