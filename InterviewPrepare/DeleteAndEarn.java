/**
 * LeetCode 740 Delete and Earn
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return rob(sum);
    }
    
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        return dp[n - 1];
    }
}
