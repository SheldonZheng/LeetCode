/**
 * LeetCode 413 Arithmetic Slices
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        int diff = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            } else {
                diff = nums[i] - nums[i - 1];
            }
        }
        return res;
    }
}
