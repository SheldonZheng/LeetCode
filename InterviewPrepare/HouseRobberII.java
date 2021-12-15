/**
 * LeetCode 213 House Robber II
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 4) {
            return Arrays.stream(nums).max().getAsInt();
        }

        int containOne = rangeFind(nums,0,nums.length - 2);
        int containLast = rangeFind(nums,1,nums.length - 1);
        return Math.max(containOne,containLast);
    }

    private int rangeFind(int[] nums, int start,int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        return dp[end];
    }
}
