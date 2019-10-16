/**
 * LeetCode 300 Longest Increasing Subsequence
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLength = 0;
        if (nums == null || nums.length == 0) {
            return maxLength;
        }

        int[] dp = new int[nums.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }

        return maxLength;
    }
}
